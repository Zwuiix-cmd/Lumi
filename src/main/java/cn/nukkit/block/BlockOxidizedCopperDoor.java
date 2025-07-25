package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockOxidizedCopperDoor extends BlockCopperDoorBase {

    protected BlockOxidizedCopperDoor() {
        super(0);
    }

    @Override
    public String getName() {
        return "Oxidized Copper Door";
    }

    @Override
    public int getId() {
        return OXIDIZED_COPPER_DOOR;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.OXIDIZED;
    }
}
