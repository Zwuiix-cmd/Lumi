package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockOxidizedCopperGrate extends BlockCopperGrateBase {
    @Override
    public String getName() {
        return "Oxidized Copper Grate";
    }

    @Override
    public int getId() {
        return OXIDIZED_COPPER_GRATE;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.OXIDIZED;
    }
}
