package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedOxidizedChiseledCopper extends BlockChiseledCopperBase {
    @Override
    public String getName() {
        return "Waxed Oxidized Chiseled Copper";
    }

    @Override
    public int getId() {
        return WAXED_OXIDIZED_CHISELED_COPPER;
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
