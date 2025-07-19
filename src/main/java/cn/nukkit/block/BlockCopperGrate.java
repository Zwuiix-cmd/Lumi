package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockCopperGrate extends BlockCopperGrateBase {
    @Override
    public String getName() {
        return "Copper Grate";
    }

    @Override
    public int getId() {
        return COPPER_GRATE;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.UNAFFECTED;
    }
}
