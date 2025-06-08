package cn.nukkit.block;

public class BlockStoneBrickWall extends BlockWall {

    public BlockStoneBrickWall() {
        this(0);
    }

    public BlockStoneBrickWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return STONE_BRICK_WALL;
    }

    @Override
    public String getName() {
        return "Stone Brick Wall";
    }
}
