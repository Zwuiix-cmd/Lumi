package cn.nukkit.item;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemBread extends ItemFood {

    public ItemBread() {
        this(0, 1);
    }

    public ItemBread(Integer meta) {
        this(meta, 1);
    }

    public ItemBread(Integer meta, int count) {
        super(BREAD, meta, count, "Bread");
    }

    @Override
    public int getFoodRestore() {
        return 5;
    }

    @Override
    public float getSaturationRestore() {
        return 6F;
    }
}
