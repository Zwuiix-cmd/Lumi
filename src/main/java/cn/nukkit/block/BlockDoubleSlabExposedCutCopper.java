package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBlock;
import org.jetbrains.annotations.NotNull;

public class BlockDoubleSlabExposedCutCopper extends BlockDoubleSlabCutCopperBase {

    public BlockDoubleSlabExposedCutCopper() {
        this(0);
    }

    public BlockDoubleSlabExposedCutCopper(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return EXPOSED_DOUBLE_CUT_COPPER_SLAB;
    }

    @Override
    public String getName() {
        return "Double Exposed Cut Copper Slab";
    }

    @Override
    public Item toItem() {
        return new ItemBlock(Block.get(EXPOSED_CUT_COPPER_SLAB));
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{
                new ItemBlock(Block.get(EXPOSED_CUT_COPPER_SLAB), 0, 2)
        };
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.EXPOSED;
    }
}
