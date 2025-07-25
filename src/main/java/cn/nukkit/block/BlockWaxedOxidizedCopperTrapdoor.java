package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedOxidizedCopperTrapdoor extends BlockCopperTrapdoorBase {

    protected BlockWaxedOxidizedCopperTrapdoor() {
        super(0);
    }

    @Override
    public String getName() {
        return "Waxed Oxidized Copper Trapdoor";
    }

    @Override
    public int getId() {
        return WAXED_OXIDIZED_COPPER_TRAPDOOR;
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
