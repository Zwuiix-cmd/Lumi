package cn.nukkit.item;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemSteak extends ItemFood {

    public ItemSteak() {
        this(0, 1);
    }

    public ItemSteak(Integer meta) {
        this(meta, 1);
    }

    public ItemSteak(Integer meta, int count) {
        super(STEAK, meta, count, "Steak");
    }

    @Override
    public int getFoodRestore() {
        return 8;
    }

    @Override
    public float getSaturationRestore() {
        return 12.8F;
    }
}
