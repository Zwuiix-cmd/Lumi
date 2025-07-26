package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBlock;
import cn.nukkit.item.ItemTool;

public class BlockDoubleSlabTuff extends BlockSolidMeta {

    public BlockDoubleSlabTuff() {
        this(0);
    }

    public BlockDoubleSlabTuff(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return TUFF_DOUBLE_SLAB;
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public double getResistance() {
        return 6;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int getToolTier() {
        return ItemTool.TIER_WOODEN;
    }

    @Override
    public String getName() {
        return "Tuff Slab";
    }

    @Override
    public Item toItem() {
        return new ItemBlock(Block.get(TUFF_SLAB));
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{
                new ItemBlock(Block.get(TUFF_SLAB), 0, 2)
        };
    }
}