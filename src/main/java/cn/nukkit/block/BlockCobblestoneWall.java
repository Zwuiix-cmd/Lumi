package cn.nukkit.block;

public class BlockCobblestoneWall extends BlockWall {

    public BlockCobblestoneWall() {
        this(0);
    }

    public BlockCobblestoneWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return COBBLESTONE_WALL;
    }

    @Override
    public String getName() {
        return "Cobblestone Wall";
    }
}
