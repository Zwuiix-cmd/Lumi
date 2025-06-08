package cn.nukkit.block;

public class BlockBrickWall extends BlockWall {

    public BlockBrickWall() {
        this(0);
    }

    public BlockBrickWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return BRICK_WALL;
    }

    @Override
    public String getName() {
        return "Brick Wall";
    }
}