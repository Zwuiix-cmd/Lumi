package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockSlabWeatheredCutCopper extends BlockSlabCutCopperBase {
    public BlockSlabWeatheredCutCopper() {
        this(0);
    }

    public BlockSlabWeatheredCutCopper(int meta) {
        super(meta, WEATHERED_DOUBLE_CUT_COPPER_SLAB);
    }

    public BlockSlabWeatheredCutCopper(int meta, int doubleSlab) {
        super(meta, doubleSlab);
    }

    @Override
    public int getId() {
        return WEATHERED_CUT_COPPER_SLAB;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.WEATHERED;
    }
}
