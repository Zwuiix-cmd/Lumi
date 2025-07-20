package cn.nukkit.item;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemPotatoBaked extends ItemFood {

    public ItemPotatoBaked() {
        this(0, 1);
    }

    public ItemPotatoBaked(Integer meta) {
        this(meta, 1);
    }

    public ItemPotatoBaked(Integer meta, int count) {
        super(BAKED_POTATO, meta, count, "Baked Potato");
    }

    @Override
    public int getFoodRestore() {
        return 5;
    }

    @Override
    public float getSaturationRestore() {
        return 7.2F;
    }
}
