package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedCopperDoor extends BlockCopperDoorBase {

    public BlockWaxedCopperDoor() {
        this(0);
    }

    public BlockWaxedCopperDoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Waxed Copper Door";
    }

    @Override
    public int getId() {
        return WAXED_COPPER_DOOR;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.UNAFFECTED;
    }

    @Override
    public boolean isWaxed() {
        return true;
    }
}
