package cn.nukkit.item;

import cn.nukkit.item.trim.ItemTrimMaterialType;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemAmethystShard extends StringItemBase implements ItemTrimMaterial {

    public ItemAmethystShard() {
        super(ItemNamespaceId.AMETHYST_SHARD, "Amethyst Shard");
    }

    @Override
    public ItemTrimMaterialType getMaterial() {
        return ItemTrimMaterialType.MATERIAL_AMETHYST;
    }
}
