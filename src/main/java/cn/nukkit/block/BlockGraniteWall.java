package cn.nukkit.block;

public class BlockGraniteWall extends BlockWall {

    public BlockGraniteWall() {
        this(0);
    }

    public BlockGraniteWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return GRANITE_WALL;
    }

    @Override
    public String getName() {
        return "Granite Wall";
    }
}