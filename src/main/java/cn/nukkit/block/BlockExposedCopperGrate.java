package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockExposedCopperGrate extends BlockChiseledCopperBase {
    @Override
    public String getName() {
        return "Exposed Copper Grate";
    }

    @Override
    public int getId() {
        return EXPOSED_COPPER_GRATE;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.EXPOSED;
    }
}
