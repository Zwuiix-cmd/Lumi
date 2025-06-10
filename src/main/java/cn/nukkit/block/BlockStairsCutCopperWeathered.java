package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2015/11/25 by xtypr.
 * Package cn.nukkit.block in project Nukkit .
 */
public class BlockStairsCutCopperWeathered extends BlockStairsCutCopperBase {

    public BlockStairsCutCopperWeathered() {
        this(0);
    }

    public BlockStairsCutCopperWeathered(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return WEATHERED_CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Weathered Cut Copper Stairs";
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.WEATHERED;
    }
}
