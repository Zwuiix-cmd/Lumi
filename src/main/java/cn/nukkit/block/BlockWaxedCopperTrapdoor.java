package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockWaxedCopperTrapdoor extends BlockCopperTrapdoorBase {

    public BlockWaxedCopperTrapdoor() {
        super(0);
    }

    public BlockWaxedCopperTrapdoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Waxed Copper Trapdoor";
    }

    @Override
    public int getId() {
        return WAXED_COPPER_TRAPDOOR;
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
