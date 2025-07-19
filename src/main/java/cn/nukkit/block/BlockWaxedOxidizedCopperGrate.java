package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedOxidizedCopperGrate extends BlockChiseledCopperBase {
    @Override
    public String getName() {
        return "Waxed Oxidized Copper Grate";
    }

    @Override
    public int getId() {
        return WAXED_OXIDIZED_COPPER_GRATE;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.OXIDIZED;
    }

    @Override
    public boolean isWaxed() {
        return true;
    }
}
