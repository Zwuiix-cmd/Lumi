package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBlock;
import cn.nukkit.math.BlockFace;

public abstract class BlockWoodStripped extends BlockLog {

    public BlockWoodStripped() {
        this(0);
    }
    
    public BlockWoodStripped(int meta) {
        super(meta);
    }
    
    @Override
    public abstract int getId();
    
    @Override
    public abstract String getName();
    
    @Override
    public boolean canBeActivated() {
        return false;
    }

    @Override
    public int getStrippedId() {
        throw new UnsupportedOperationException("getStrippedId can't be used with BlockWoodStripped");
    }

    @Override
    public boolean onActivate(Item item, Player player) {
        return false;
    }
}
