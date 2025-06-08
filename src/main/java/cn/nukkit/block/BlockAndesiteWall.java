package cn.nukkit.block;

public class BlockAndesiteWall extends BlockWall {

    public BlockAndesiteWall() {
        this(0);
    }

    public BlockAndesiteWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return ANDESITE_WALL;
    }

    @Override
    public String getName() {
        return "Andesite Wall";
    }
}