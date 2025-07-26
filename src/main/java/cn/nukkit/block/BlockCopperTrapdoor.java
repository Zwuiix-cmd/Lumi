package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockCopperTrapdoor extends BlockCopperTrapdoorBase {

    public BlockCopperTrapdoor() {
        super(0);
    }

    public BlockCopperTrapdoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Copper Trapdoor";
    }

    @Override
    public int getId() {
        return COPPER_TRAPDOOR;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.UNAFFECTED;
    }
}
