package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWeatheredCopperTrapdoor extends BlockCopperTrapdoorBase {

    protected BlockWeatheredCopperTrapdoor() {
        super(0);
    }

    @Override
    public String getName() {
        return "Weathered Copper Trapdoor";
    }

    @Override
    public int getId() {
        return WEATHERED_COPPER_TRAPDOOR;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.WEATHERED;
    }
}
