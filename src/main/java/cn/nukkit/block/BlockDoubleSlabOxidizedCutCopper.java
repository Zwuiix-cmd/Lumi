package cn.nukkit.block;

import cn.nukkit.block.properties.enums.OxidizationLevel;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBlock;
import org.jetbrains.annotations.NotNull;

public class BlockDoubleSlabOxidizedCutCopper extends BlockDoubleSlabCutCopperBase {

    public BlockDoubleSlabOxidizedCutCopper() {
        this(0);
    }

    public BlockDoubleSlabOxidizedCutCopper(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return OXIDIZED_DOUBLE_CUT_COPPER_SLAB;
    }

    @Override
    public String getName() {
        return "Double Oxidized Cut Copper Slab";
    }

    @Override
    public Item toItem() {
        return new ItemBlock(Block.get(OXIDIZED_CUT_COPPER_SLAB));
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{
                new ItemBlock(Block.get(OXIDIZED_CUT_COPPER_SLAB), 0, 2)
        };
    }

    @Override
    public @NotNull OxidizationLevel getOxidizationLevel() {
        return OxidizationLevel.OXIDIZED;
    }
}
