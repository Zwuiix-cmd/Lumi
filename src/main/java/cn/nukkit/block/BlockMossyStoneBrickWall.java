package cn.nukkit.block;

public class BlockMossyStoneBrickWall extends BlockWall {

    public BlockMossyStoneBrickWall() {
        this(0);
    }

    public BlockMossyStoneBrickWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return MOSSY_STONE_BRICK_WALL;
    }

    @Override
    public String getName() {
        return "Mossy Stone Brick Wall";
    }
}