package cn.nukkit.block;

import cn.nukkit.item.Item;

public class BlockHeadZombie extends BlockSkull {

    public BlockHeadZombie() {
        this(0);
    }

    public BlockHeadZombie(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return ZOMBIE_HEAD;
    }

    @Override
    public String getName() {
        return "Zombie Head";
    }

    @Override
    public Item toItem() {
        return Item.get(Item.SKULL, 2);
    }

    @Override
    public SkullType getSkullType() {
        return SkullType.ZOMBIE;
    }
}