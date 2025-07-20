package cn.nukkit.item;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package cn.nukkit.item in project nukkit.
 */
public class ItemSalmonCooked extends ItemFish {

    public ItemSalmonCooked() {
        this(0, 1);
    }

    public ItemSalmonCooked(Integer meta) {
        this(meta, 1);
    }

    public ItemSalmonCooked(Integer meta, int count) {
        super(COOKED_SALMON, meta, count, "Cooked Salmon");
    }

    @Override
    public int getFoodRestore() {
        return 6;
    }

    @Override
    public float getSaturationRestore() {
        return 9.6F;
    }
}
