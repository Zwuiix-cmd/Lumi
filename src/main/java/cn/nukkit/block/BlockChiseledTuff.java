package cn.nukkit.block;

import cn.nukkit.item.ItemTool;

public class BlockChiseledTuff extends BlockSolid {

    @Override
    public int getId() {
        return CHISELED_TUFF;
    }

    @Override
    public String getName() {
        return "Chiseled Tuff";
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
