package cn.nukkit.item;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemFish extends ItemFood {

    public ItemFish() {
        this(0, 1);
    }

    public ItemFish(Integer meta) {
        this(meta, 1);
    }

    public ItemFish(Integer meta, int count) {
        super(RAW_FISH, meta, count, "Raw Fish");
    }

    protected ItemFish(int id, Integer meta, int count, String name) {
        super(id, meta, count, name);
    }

    @Override
    public int getFoodRestore() {
        return 2;
    }

    @Override
    public float getSaturationRestore() {
        return 0.4F;
    }
}
