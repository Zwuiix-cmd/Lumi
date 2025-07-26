package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedWeatheredCopperDoor extends BlockCopperDoorBase {

    public BlockWaxedWeatheredCopperDoor() {
        this(0);
    }

    public BlockWaxedWeatheredCopperDoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Waxed Weathered Copper Door";
    }

    @Override
    public int getId() {
        return WAXED_WEATHERED_COPPER_DOOR;
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
