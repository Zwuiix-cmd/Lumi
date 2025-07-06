package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockSlabOxidizedCutCopperWaxed extends BlockSlabCutCopperBase {
    public BlockSlabOxidizedCutCopperWaxed() {
        this(0);
    }

    public BlockSlabOxidizedCutCopperWaxed(int meta) {
        super(meta, WAXED_OXIDIZED_DOUBLE_CUT_COPPER_SLAB);
    }

    public BlockSlabOxidizedCutCopperWaxed(int meta, int doubleSlab) {
        super(meta, doubleSlab);
    }

    @Override
    public int getId() {
        return WAXED_OXIDIZED_CUT_COPPER_SLAB;
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
