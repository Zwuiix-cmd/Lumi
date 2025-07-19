package cn.nukkit.item;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemMelon extends ItemFood {

    public ItemMelon() {
        this(0, 1);
    }

    public ItemMelon(Integer meta) {
        this(meta, 1);
    }

    public ItemMelon(Integer meta, int count) {
        super(MELON, meta, count, "Melon");
    }

    @Override
    public int getFoodRestore() {
        return 2;
    }

    @Override
    public float getSaturationRestore() {
        return 1.2F;
    }
}
