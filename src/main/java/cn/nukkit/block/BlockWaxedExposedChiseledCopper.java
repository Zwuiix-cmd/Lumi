package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedExposedChiseledCopper extends BlockChiseledCopperBase {
    @Override
    public String getName() {
        return "Waxed Exposed Chiseled Copper";
    }

    @Override
    public int getId() {
        return WAXED_EXPOSED_CHISELED_COPPER;
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
