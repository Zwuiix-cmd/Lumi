package cn.nukkit.block;

public class BlockDioriteWall extends BlockWall {

    public BlockDioriteWall() {
        this(0);
    }

    public BlockDioriteWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return DIORITE_WALL;
    }

    @Override
    public String getName() {
        return "Diorite Wall";
    }
}