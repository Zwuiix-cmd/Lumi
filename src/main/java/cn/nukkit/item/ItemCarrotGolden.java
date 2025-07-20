package cn.nukkit.item;

public class ItemCarrotGolden extends ItemFood {

    public ItemCarrotGolden() {
        this(0, 1);
    }

    public ItemCarrotGolden(Integer meta) {
        this(meta, 1);
    }

    public ItemCarrotGolden(Integer meta, int count) {
        super(GOLDEN_CARROT, 0, count, "Golden Carrot");
    }

    @Override
    public int getFoodRestore() {
        return 6;
    }

    @Override
    public float getSaturationRestore() {
        return 14.4F;
    }
}
