package cn.nukkit.item;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemApple extends ItemFood {

    public ItemApple() {
        this(0, 1);
    }

    public ItemApple(Integer meta) {
        this(meta, 1);
    }

    public ItemApple(Integer meta, int count) {
        super(APPLE, 0, count, "Apple");
    }

    @Override
    public int getFoodRestore() {
        return 4;
    }

    @Override
    public float getSaturationRestore() {
        return 2.4F;
    }
}
