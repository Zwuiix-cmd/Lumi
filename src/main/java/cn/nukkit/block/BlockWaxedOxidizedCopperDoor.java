package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedOxidizedCopperDoor extends BlockCopperDoorBase {

    public BlockWaxedOxidizedCopperDoor() {
        this(0);
    }

    public BlockWaxedOxidizedCopperDoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Waxed Oxidized Copper Door";
    }

    @Override
    public int getId() {
        return WAXED_OXIDIZED_COPPER_DOOR;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.OXIDIZED;
    }

    @Override
    public boolean isWaxed() {
        return true;
    }
}
