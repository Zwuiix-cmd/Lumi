package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockSlabExposedCutCopper extends BlockSlabCutCopperBase {
    public BlockSlabExposedCutCopper() {
        this(0);
    }

    public BlockSlabExposedCutCopper(int meta) {
        super(meta, EXPOSED_DOUBLE_CUT_COPPER_SLAB);
    }

    public BlockSlabExposedCutCopper(int meta, int doubleSlab) {
        super(meta, doubleSlab);
    }

    @Override
    public int getId() {
        return EXPOSED_CUT_COPPER_SLAB;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.EXPOSED;
    }
}
