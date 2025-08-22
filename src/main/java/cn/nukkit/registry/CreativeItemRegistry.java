package cn.nukkit.registry;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemNamespaceId;
import cn.nukkit.item.RuntimeItemMapping;
import cn.nukkit.item.RuntimeItems;
import cn.nukkit.network.protocol.ProtocolInfo;
import cn.nukkit.network.protocol.types.inventory.creative.CreativeItemCategory;
import cn.nukkit.network.protocol.types.inventory.creative.CreativeItemData;
import cn.nukkit.network.protocol.types.inventory.creative.CreativeItemGroup;
import cn.nukkit.utils.Utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.Getter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CreativeItemRegistry implements IRegistry<Integer, CreativeItemRegistry.CreativeItems, CreativeItemRegistry.CreativeItems> {

    private static final Object2ObjectOpenHashMap<Integer, CreativeItems> CREATIVE_ITEMS = new Object2ObjectOpenHashMap<>();

    private static final AtomicBoolean isLoad = new AtomicBoolean(false);

    @Override
    public void init() {
        if (isLoad.getAndSet(true)) return;

        for (Integer protocol : ProtocolInfo.SUPPORTED_PROTOCOLS) {
            try (InputStream stream = CreativeItemRegistry.class.getClassLoader().getResourceAsStream("creative_items_" + protocol + ".json")) {
                if (stream == null) {
                    return;
                }

                if (protocol >= ProtocolInfo.v1_21_60) {
                    this.initNewItems(stream, protocol);
                } else {
                    this.initOldItems(stream, protocol);
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to load creative_items_" + protocol + ".json");
            }
        }
    }

    private void initNewItems(InputStream stream, int protocol) {
        RuntimeItemMapping mapping = RuntimeItems.getMapping(protocol);

        JsonArray groups = JsonParser.parseReader(new InputStreamReader(stream)).getAsJsonObject().get("groups").getAsJsonArray();
        if (groups.isEmpty()) {
            throw new RuntimeException("Creative groups empty");
        }

        int creativeGroupId = 0;

        CreativeItems creativeItems = new CreativeItems();

        for (JsonElement element : groups.asList()) {
            JsonObject group = element.getAsJsonObject();

            Item icon = mapping.parseCreativeItem(group.get("icon").getAsJsonObject(), true, protocol);
            if (icon == null) {
                icon = Item.get(ItemNamespaceId.AIR);
            }

            CreativeItemGroup creativeGroup = new CreativeItemGroup(creativeGroupId++,
                    CreativeItemCategory.valueOf(
                            group.get("category").getAsString().toUpperCase(Locale.ROOT)
                    ),
                    group.get("name").getAsString(),
                    icon
            );

            creativeItems.addGroup(creativeGroup);
        }

        this.register(protocol, creativeItems);
    }

    private void initOldItems(InputStream stream, int protocol) {
        JsonArray items = JsonParser.parseReader(new InputStreamReader(stream)).getAsJsonObject().getAsJsonArray("items");

        int creativeGroupId = 0;

        CreativeItems creativeItems = new CreativeItems();

        for (JsonElement element : items) {
            try {
                JsonObject item = element.getAsJsonObject();

                byte[] nbtBytes = new byte[0];
                if (item.has("nbt_b64")) {
                    nbtBytes = Base64.getDecoder().decode(item.get("nbt_b64").getAsString());
                } else if (item.has("nbt_hex")) {
                    nbtBytes = Utils.parseHexBinary(item.get("nbt_hex").getAsString());
                }

                String id = item.get("id").getAsString();
                int damage = item.has("damage") ? item.get("damage").getAsInt() : 0;
                int count = item.has("count") ? item.get("count").getAsInt() : 1;

                if (!Utils.hasItemOrBlock(id)) {
                    continue;
                }

                Item icon = Item.get(id, damage);
                icon.setCount(count);
                icon.setCompoundTag(nbtBytes);

                CreativeItemGroup creativeGroup = new CreativeItemGroup(creativeGroupId++, CreativeItemCategory.ITEMS, "", icon);

                creativeItems.addGroup(creativeGroup);
            } catch (Exception e) {
                throw new RuntimeException("Creative groups empty");
            }

            this.register(protocol, creativeItems);
        }
    }

    @Override
    public void register(Integer protocol, CreativeItems creativeItems) {
        CREATIVE_ITEMS.put(protocol, creativeItems);
    }

    public void register(Integer protocol, Item icon) {
        CREATIVE_ITEMS.computeIfAbsent(protocol, p -> new CreativeItems()).add(icon);
    }

    @Override
    public CreativeItems get(Integer protocol) {
        return CREATIVE_ITEMS.get(protocol);
    }

    public boolean isCreativeItem(int protocol, Item item) {
        for (Item creativeItem : this.get(protocol).getItems()) {
            if (item.equals(creativeItem, !item.isTool())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void trim() {
        CREATIVE_ITEMS.trim();
    }

    @Override
    public void reload() {
        isLoad.set(false);
        CREATIVE_ITEMS.clear();
        init();
    }

    @Getter
    public static class CreativeItems {

        private final List<CreativeItemGroup> groups = new ArrayList<>();
        private final Map<Item, CreativeItemGroup> contents = new LinkedHashMap<>();

        public void clear() {
            groups.clear();
            contents.clear();
        }

        public void add(Item item) {
            add(item, CreativeItemCategory.ITEMS, ""); // TODO: vanilla items back to correct categories & groups
        }

        public void add(Item item, CreativeItemGroup group) {
            contents.put(item, group);
        }

        public void add(Item item, CreativeItemCategory category, String group) {
            CreativeItemGroup creativeGroup = null;

            for (CreativeItemGroup existing : groups) {
                if (existing.category == category && existing.name.equals(group)) {
                    creativeGroup = existing;
                    break;
                }
            }

            if (creativeGroup == null) {
                creativeGroup = new CreativeItemGroup(groups.size(), category, group, item);
                groups.add(creativeGroup);
            }

            contents.put(item, creativeGroup);
        }

        public void addGroup(CreativeItemGroup creativeGroup) {
            groups.add(creativeGroup);
        }

        public Collection<Item> getItems() {
            return contents.keySet();
        }

        public List<CreativeItemData> getCreativeItemData() {
            int creativeNetId = 1; // 0 is not indexed by client
            var list = new ObjectArrayList<CreativeItemData>(this.getContents().size());
            for (Map.Entry<Item, CreativeItemGroup> entry : this.getContents().entrySet()) {
                list.add(new CreativeItemData(entry.getKey(), creativeNetId++, entry.getValue() != null ? entry.getValue().getGroupId() : 0));
            }
            return list;
        }
    }
}
