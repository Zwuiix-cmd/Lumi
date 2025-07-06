package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockSlabOxidizedCutCopper extends BlockSlabCutCopperBase {
    public BlockSlabOxidizedCutCopper() {
        this(0);
    }

    public BlockSlabOxidizedCutCopper(int meta) {
        super(meta, OXIDIZED_DOUBLE_CUT_COPPER_SLAB);
    }

    public BlockSlabOxidizedCutCopper(int meta, int doubleSlab) {
        super(meta, doubleSlab);
    }

    @Override
    public int getId() {
        return OXIDIZED_CUT_COPPER_SLAB;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.OXIDIZED;
    }
}
