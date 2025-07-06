package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockSlabExposedCutCopperWaxed extends BlockSlabCutCopperBase {
    public BlockSlabExposedCutCopperWaxed() {
        this(0);
    }

    public BlockSlabExposedCutCopperWaxed(int meta) {
        super(meta, WAXED_EXPOSED_DOUBLE_CUT_COPPER_SLAB);
    }

    public BlockSlabExposedCutCopperWaxed(int meta, int doubleSlab) {
        super(meta, doubleSlab);
    }

    @Override
    public int getId() {
        return WAXED_EXPOSED_CUT_COPPER_SLAB;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.EXPOSED;
    }

    @Override
    public boolean isWaxed() {
        return true;
    }
}
