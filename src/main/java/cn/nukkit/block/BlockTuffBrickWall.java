package cn.nukkit.block;

public class BlockTuffBrickWall extends BlockWall {

    public BlockTuffBrickWall() {
        this(0);
    }

    public BlockTuffBrickWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return TUFF_BRICK_WALL;
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public double getResistance() {
        return 6;
    }
    @Override
    public String getName() {
        return "Tuff Brick Wall";
    }
}