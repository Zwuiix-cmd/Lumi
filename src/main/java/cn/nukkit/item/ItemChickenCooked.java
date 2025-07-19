package cn.nukkit.item;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemChickenCooked extends ItemFood {

    public ItemChickenCooked() {
        this(0, 1);
    }

    public ItemChickenCooked(Integer meta) {
        this(meta, 1);
    }

    public ItemChickenCooked(Integer meta, int count) {
        super(COOKED_CHICKEN, meta, count, "Cooked Chicken");
    }


    @Override
    public int getFoodRestore() {
        return 6;
    }

    @Override
    public float getSaturationRestore() {
        return 7.2F;
    }
}
