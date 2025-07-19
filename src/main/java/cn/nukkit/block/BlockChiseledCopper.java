package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockChiseledCopper extends BlockChiseledCopperBase {
    @Override
    public String getName() {
        return "Chiseled Copper";
    }

    @Override
    public int getId() {
        return CHISELED_COPPER;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.UNAFFECTED;
    }
}
