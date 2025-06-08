package cn.nukkit.block;

public class BlockRedSandstoneBlock extends BlockWall {

    public BlockRedSandstoneBlock() {
        this(0);
    }

    public BlockRedSandstoneBlock(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return RED_SANDSTONE_WALL;
    }

    @Override
    public String getName() {
        return "Red Sandstone Wall";
    }
}