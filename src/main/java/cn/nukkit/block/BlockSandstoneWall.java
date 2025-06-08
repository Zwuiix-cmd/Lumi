package cn.nukkit.block;

public class BlockSandstoneWall extends BlockWall {

    public BlockSandstoneWall() {
        this(0);
    }

    public BlockSandstoneWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return SANDSTONE_WALL;
    }

    @Override
    public String getName() {
        return "Sandstone Wall";
    }
}