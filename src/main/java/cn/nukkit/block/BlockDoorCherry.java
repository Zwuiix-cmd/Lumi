package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemNamespaceId;
import cn.nukkit.utils.BlockColor;

public class BlockDoorCherry extends BlockDoorWood {

    public BlockDoorCherry() {
        this(0);
    }

    public BlockDoorCherry(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Cherry Door Block";
    }

    @Override
    public int getId() {
        return CHERRY_DOOR;
    }

    @Override
    public Item toItem() {
        return Item.fromString(ItemNamespaceId.CHERRY_DOOR);
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.CHERRY_BLOCK_COLOR;
    }
}