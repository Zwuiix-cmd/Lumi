package cn.nukkit.block;

public class BlockPrismarineWall extends BlockWall {

    public BlockPrismarineWall() {
        this(0);
    }

    public BlockPrismarineWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return PRISMARINE_WALL;
    }

    @Override
    public String getName() {
        return "Prismarine Wall";
    }
}
