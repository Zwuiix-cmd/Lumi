package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedWeatheredChiseledCopper extends BlockChiseledCopperBase {
    @Override
    public String getName() {
        return "Waxed Weathered Chiseled Copper";
    }

    @Override
    public int getId() {
        return WAXED_WEATHERED_CHISELED_COPPER;
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
