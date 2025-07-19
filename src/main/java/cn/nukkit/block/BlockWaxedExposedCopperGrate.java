package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedExposedCopperGrate extends BlockChiseledCopperBase {
    @Override
    public String getName() {
        return "Waxed Exposed Copper Grate";
    }

    @Override
    public int getId() {
        return WAXED_EXPOSED_COPPER_GRATE;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.EXPOSED;
    }

    @Override
    public boolean isWaxed() {
        return true;
    }
}
