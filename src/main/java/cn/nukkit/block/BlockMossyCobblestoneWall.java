package cn.nukkit.block;

public class BlockMossyCobblestoneWall extends BlockWall {

    public BlockMossyCobblestoneWall() {
        this(0);
    }

    public BlockMossyCobblestoneWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return MOSSY_COBBLESTONE_WALL;
    }

    @Override
    public String getName() {
        return "Mossy Cobblestone Wall";
    }
}