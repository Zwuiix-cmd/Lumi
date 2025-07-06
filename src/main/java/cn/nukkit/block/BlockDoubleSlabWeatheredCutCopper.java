package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBlock;
import org.jetbrains.annotations.NotNull;

public class BlockDoubleSlabWeatheredCutCopper extends BlockDoubleSlabCutCopperBase {

    public BlockDoubleSlabWeatheredCutCopper() {
        this(0);
    }

    public BlockDoubleSlabWeatheredCutCopper(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return WEATHERED_DOUBLE_CUT_COPPER_SLAB;
    }

    @Override
    public String getName() {
        return "Double Weathered Cut Copper Slab";
    }

    @Override
    public Item toItem() {
        return new ItemBlock(Block.get(WEATHERED_CUT_COPPER_SLAB));
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{
                new ItemBlock(Block.get(WEATHERED_CUT_COPPER_SLAB), 0, 2)
        };
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.WEATHERED;
    }
}
