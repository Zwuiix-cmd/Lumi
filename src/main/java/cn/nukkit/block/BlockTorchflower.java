package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.item.Item;

public class BlockTorchflower extends BlockFlower {
    public BlockTorchflower() {
    }

    @Override
    public boolean onActivate(Item item, Player player) {
        return false;
    }

    public int getId() {
        return TORCHFLOWER;
    }

    public String getName() {
        return "Torchflower";
    }
}