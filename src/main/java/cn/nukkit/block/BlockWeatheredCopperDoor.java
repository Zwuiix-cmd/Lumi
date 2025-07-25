package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWeatheredCopperDoor extends BlockCopperDoorBase {

    protected BlockWeatheredCopperDoor() {
        super(0);
    }

    @Override
    public String getName() {
        return "Weathered Copper Door";
    }

    @Override
    public int getId() {
        return WEATHERED_COPPER_DOOR;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.WEATHERED;
    }
}
