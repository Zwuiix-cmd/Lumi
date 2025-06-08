package cn.nukkit.block;

public class BlockEndstoneBrickWall extends BlockWall {

    public BlockEndstoneBrickWall() {
        this(0);
    }

    public BlockEndstoneBrickWall(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return ENDSTONE_BRICK_WALL;
    }

    @Override
    public String getName() {
        return "Endstone Brick Wall";
    }
}