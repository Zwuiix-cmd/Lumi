package cn.nukkit.block;

public class BlockNetherBrickWall extends BlockWall {

    public BlockNetherBrickWall() {
        this(0);
    }

    public BlockNetherBrickWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return NETHER_BRICK_WALL;
    }

    @Override
    public String getName() {
        return "Nether Brick Wall";
    }
}