package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockSlabWeatheredCutCopperWaxed extends BlockSlabCutCopperBase {
    public BlockSlabWeatheredCutCopperWaxed() {
        this(0);
    }

    public BlockSlabWeatheredCutCopperWaxed(int meta) {
        super(meta, WAXED_WEATHERED_DOUBLE_CUT_COPPER_SLAB);
    }

    public BlockSlabWeatheredCutCopperWaxed(int meta, int doubleSlab) {
        super(meta, doubleSlab);
    }

    @Override
    public int getId() {
        return WAXED_WEATHERED_CUT_COPPER_SLAB;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.WEATHERED;
    }

    @Override
    public boolean isWaxed() {
        return true;
    }
}
