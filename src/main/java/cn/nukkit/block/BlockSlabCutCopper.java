package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import org.jetbrains.annotations.NotNull;

public class BlockSlabCutCopper extends BlockSlabCutCopperBase {
    public BlockSlabCutCopper() {
        this(0);
    }

    public BlockSlabCutCopper(int meta) {
        super(meta, DOUBLE_CUT_COPPER_SLAB);
    }

    @Override
    public int getId() {
        return CUT_COPPER_SLAB;
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.UNAFFECTED;
    }
}
