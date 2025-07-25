package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedExposedCopperDoor extends BlockCopperDoorBase {

    protected BlockWaxedExposedCopperDoor() {
        super(0);
    }

    @Override
    public String getName() {
        return "Waxed Exposed Copper Door";
    }

    @Override
    public int getId() {
        return WAXED_EXPOSED_COPPER_DOOR;
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
