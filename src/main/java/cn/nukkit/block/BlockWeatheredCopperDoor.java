package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWeatheredCopperDoor extends BlockCopperDoorBase {

    public BlockWeatheredCopperDoor() {
        this(0);
    }

    public BlockWeatheredCopperDoor(int meta) {
        super(meta);
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
