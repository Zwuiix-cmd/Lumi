package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBlock;
import org.jetbrains.annotations.NotNull;

public class BlockDoubleSlabWeatheredCutCopperWaxed extends BlockDoubleSlabCutCopperBase {

    public BlockDoubleSlabWeatheredCutCopperWaxed() {
        this(0);
    }

    public BlockDoubleSlabWeatheredCutCopperWaxed(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return WAXED_WEATHERED_DOUBLE_CUT_COPPER_SLAB;
    }

    @Override
    public String getName() {
        return "Double Waxed Weathered Cut Copper Slab";
    }

    @Override
    public Item toItem() {
        return new ItemBlock(Block.get(WAXED_WEATHERED_CUT_COPPER_SLAB));
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{
                new ItemBlock(Block.get(WAXED_WEATHERED_CUT_COPPER_SLAB), 0, 2)
        };
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
