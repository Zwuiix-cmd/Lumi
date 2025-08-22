package cn.nukkit.registry;

import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.types.inventory.creative.CreativeItemCategory;
import cn.nukkit.network.protocol.types.inventory.creative.CreativeItemData;
import cn.nukkit.network.protocol.types.inventory.creative.CreativeItemGroup;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.*;

public class CreativeItemRegistry implements IRegistry<Item, CreativeItemRegistry.CreativeItemDefinition, CreativeItemRegistry.CreativeItemDefinition> {

    @Override
    public void init() {

    }

    @Override
    public void register(Item key, CreativeItemDefinition value) {

    }

    @Override
    public CreativeItemDefinition get(Item key) {
        return null;
    }

    @Override
    public void trim() {

    }

    @Override
    public void reload() {

    }

    public record CreativeItemDefinition(Item item, CreativeItemCategory category, String group) {

    }

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

        public List<CreativeItemGroup> getGroups() {
            return groups;
        }

        public Map<Item, CreativeItemGroup> getContents() {
            return contents;
        }

        public List<CreativeItemData> getCreativeItemDatas() {
            int creativeNetId = 1; // 0 is not indexed by client
            ObjectArrayList<CreativeItemData> list = new ObjectArrayList<>(this.getContents().size());
            for (Map.Entry<Item, CreativeItemGroup> entry : this.getContents().entrySet()) {
                list.add(new CreativeItemData(entry.getKey(), creativeNetId++, entry.getValue() != null ? entry.getValue().getGroupId() : 0));
            }
            return list;
        }
    }
}
