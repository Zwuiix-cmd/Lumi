package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedWeatheredCopperGrate extends BlockChiseledCopperBase {
    @Override
    public String getName() {
        return "Waxed Weathered Copper Grate";
    }

    @Override
    public int getId() {
        return WAXED_WEATHERED_COPPER_GRATE;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.WEATHERED;
    }

    @Override
    public boolean isWaxed() {
        return true;
    }
}
