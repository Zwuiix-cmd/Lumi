package cn.nukkit.block;

public class BlockTuffWall extends BlockWall {

    public BlockTuffWall() {
        this(0);
    }

    public BlockTuffWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return TUFF_WALL;
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
        return "Tuff Wall";
    }
}