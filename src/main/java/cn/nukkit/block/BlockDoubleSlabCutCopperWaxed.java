package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBlock;
import org.jetbrains.annotations.NotNull;

public class BlockDoubleSlabCutCopperWaxed extends BlockDoubleSlabCutCopperBase {

    public BlockDoubleSlabCutCopperWaxed() {
        this(0);
    }

    public BlockDoubleSlabCutCopperWaxed(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return WAXED_DOUBLE_CUT_COPPER_SLAB;
    }

    @Override
    public String getName() {
        return "Double Waxed Cut Copper Slab";
    }

    @Override
    public Item toItem() {
        return new ItemBlock(Block.get(WAXED_CUT_COPPER_SLAB));
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{
                new ItemBlock(Block.get(WAXED_CUT_COPPER_SLAB), 0, 2)
        };
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
