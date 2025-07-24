package cn.nukkit.block;

import cn.nukkit.item.ItemTool;

public class BlockPolishedTuff extends BlockSolid {

    @Override
    public int getId() {
        return POLISHED_TUFF;
    }

    @Override
    public String getName() {
        return "Polished Tuff";
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
    public boolean canHarvestWithHand() {
        return false;
    }
}
