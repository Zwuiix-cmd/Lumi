package cn.nukkit.item;

public class ItemMuttonCooked extends ItemFood {

    public ItemMuttonCooked() {
        this(0, 1);
    }

    public ItemMuttonCooked(Integer meta) {
        this(meta, 1);
    }

    public ItemMuttonCooked(Integer meta, int count) {
        super(COOKED_MUTTON, meta, count, "Cooked Mutton");
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
