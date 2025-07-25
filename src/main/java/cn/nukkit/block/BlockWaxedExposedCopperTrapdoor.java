package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedExposedCopperTrapdoor extends BlockCopperTrapdoorBase {

    protected BlockWaxedExposedCopperTrapdoor() {
        super(0);
    }

    @Override
    public String getName() {
        return "Waxed Exposed Copper Trapdoor";
    }

    @Override
    public int getId() {
        return WAXED_EXPOSED_COPPER_TRAPDOOR;
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
