package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBlock;
import org.jetbrains.annotations.NotNull;

public class BlockDoubleSlabExposedCutCopperWaxed extends BlockDoubleSlabCutCopperBase {

    public BlockDoubleSlabExposedCutCopperWaxed() {
        this(0);
    }

    public BlockDoubleSlabExposedCutCopperWaxed(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return WAXED_EXPOSED_DOUBLE_CUT_COPPER_SLAB;
    }

    @Override
    public String getName() {
        return "Double Waxed Exposed Cut Copper Slab";
    }

    @Override
    public Item toItem() {
        return new ItemBlock(Block.get(WAXED_EXPOSED_CUT_COPPER_SLAB));
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{
                new ItemBlock(Block.get(WAXED_EXPOSED_CUT_COPPER_SLAB), 0, 2)
        };
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
