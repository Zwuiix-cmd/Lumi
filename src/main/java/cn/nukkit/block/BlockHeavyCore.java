package cn.nukkit.block;

import cn.nukkit.item.ItemTool;

public class BlockHeavyCore extends BlockTransparent {
    @Override
    public int getId() {
        return HEAVY_CORE;
    }

    @Override
    public String getName() {
        return "Heavy Core";
    }

    @Override
    public double getHardness() {
        return 10f;
    }

    @Override
    public double getResistance() {
        return 30;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public WaterloggingType getWaterloggingType() {
        return WaterloggingType.WHEN_PLACED_IN_WATER;
    }
}
