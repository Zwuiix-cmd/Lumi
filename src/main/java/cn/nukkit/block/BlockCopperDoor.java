package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockCopperDoor extends BlockCopperDoorBase {

    public BlockCopperDoor() {
        this(0);
    }

    public BlockCopperDoor(int meta) {
        super(meta);
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
    public double getResistance() {
        return 15;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.UNAFFECTED;
    }
}
