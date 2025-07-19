package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockExposedChiseledCopper extends BlockChiseledCopperBase {
    @Override
    public String getName() {
        return "Exposed Chiseled Copper";
    }

    @Override
    public int getId() {
        return EXPOSED_CHISELED_COPPER;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.EXPOSED;
    }
}
