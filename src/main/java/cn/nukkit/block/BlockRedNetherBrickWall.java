package cn.nukkit.block;

public class BlockRedNetherBrickWall extends BlockWall {

    public BlockRedNetherBrickWall() {
        this(0);
    }

    public BlockRedNetherBrickWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return RED_NETHER_BRICK_WALL;
    }

    @Override
    public String getName() {
        return "Red Nether Brick Wall";
    }
}