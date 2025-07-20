package cn.nukkit.item;

import cn.nukkit.block.Block;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemPotato extends ItemFood {

    public ItemPotato() {
        this(0, 1);
    }

    public ItemPotato(Integer meta) {
        this(meta, 1);
    }

    public ItemPotato(Integer meta, int count) {
        super(POTATO, meta, count, "Potato");
        this.block = Block.get(POTATO_BLOCK);
    }

    protected ItemPotato(int id, Integer meta, int count, String name) {
        super(id, meta, count, name);
    }

    @Override
    public int getFoodRestore() {
        return 1;
    }

    @Override
    public float getSaturationRestore() {
        return 0.6F;
    }
}
