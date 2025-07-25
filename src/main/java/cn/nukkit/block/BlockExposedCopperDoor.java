package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockExposedCopperDoor extends BlockCopperDoorBase {

    protected BlockExposedCopperDoor() {
        super(0);
    }

    @Override
    public String getName() {
        return "Exposed Copper Door";
    }

    @Override
    public int getId() {
        return EXPOSED_COPPER_DOOR;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.EXPOSED;
    }
}
