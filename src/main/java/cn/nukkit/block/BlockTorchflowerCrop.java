package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.math.BlockFace;

public class BlockTorchflowerCrop extends BlockTransparentMeta {

    public BlockTorchflowerCrop(int meta) {
        super(meta);
    }

    public BlockTorchflowerCrop() {
        this(0);
    }

    @Override
    public String getName() {
        return "Torchflower Crop";
    }

    @Override
    public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player) {
        if (block.down().getId() == FARMLAND) {
            this.getLevel().setBlock(block, this, true, true);
            return true;
        }
        return false;
    }

    @Override
    public int getId() {
        return TORCHFLOWER_CROP;
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
