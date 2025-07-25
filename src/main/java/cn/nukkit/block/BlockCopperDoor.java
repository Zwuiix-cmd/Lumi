package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockCopperDoor extends BlockCopperDoorBase {

    protected BlockCopperDoor() {
        super(0);
    }

    @Override
    public String getName() {
        return "Copper Door";
    }

    @Override
    public int getId() {
        return COPPER_DOOR;
    }

    @Override
    public double getHardness() {
        return 3.0;
    }

    @Override
    public double getResistance() {
        return 15;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.UNAFFECTED;
    }
}
