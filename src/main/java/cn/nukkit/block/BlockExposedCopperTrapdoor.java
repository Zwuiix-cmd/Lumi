package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockExposedCopperTrapdoor extends BlockCopperTrapdoorBase {

    public BlockExposedCopperTrapdoor() {
        super(0);
    }

    public BlockExposedCopperTrapdoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Exposed Copper Trapdoor";
    }

    @Override
    public int getId() {
        return EXPOSED_COPPER_TRAPDOOR;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.EXPOSED;
    }
}
