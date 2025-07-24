package cn.nukkit.block;

public class BlockPolishedTuffWall extends BlockWall {

    public BlockPolishedTuffWall() {
        this(0);
    }

    public BlockPolishedTuffWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return POLISHED_TUFF_WALL;
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
        return "Polished Tuff Wall";
    }
}