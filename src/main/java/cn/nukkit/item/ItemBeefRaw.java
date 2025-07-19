package cn.nukkit.item;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemBeefRaw extends ItemFood {

    public ItemBeefRaw() {
        this(0, 1);
    }

    public ItemBeefRaw(Integer meta) {
        this(meta, 1);
    }

    public ItemBeefRaw(Integer meta, int count) {
        super(RAW_BEEF, meta, count, "Raw Beef");
    }

    @Override
    public int getFoodRestore() {
        return 3;
    }

    @Override
    public float getSaturationRestore() {
        return 1.8F;
    }
}
