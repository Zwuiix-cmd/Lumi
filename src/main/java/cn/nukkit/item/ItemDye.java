package cn.nukkit.item;

import cn.nukkit.item.data.DyeColor;

public class ItemDye extends Item {

    public ItemDye() {
        this(0, 1);
    }

    public ItemDye(Integer meta) {
        this(meta, 1);
    }

    public ItemDye(DyeColor dyeColor) {
        this(dyeColor.getDyeData(), 1);
    }

    public ItemDye(DyeColor dyeColor, int amount) {
        this(dyeColor.getDyeData(), amount);
    }

    public ItemDye(Integer meta, int amount) {
        super(DYE, meta, amount, meta >= 0 && meta <= 20 ? DyeColor.getByDyeData(meta).getDyeName() : UNKNOWN_STR);
    }

    public DyeColor getDyeColor() {
        return DyeColor.getByDyeData(meta);
    }

    public void setDyeColor(DyeColor dyeColor) {
        this.setDamage(dyeColor.getDyeData());
    }
}
