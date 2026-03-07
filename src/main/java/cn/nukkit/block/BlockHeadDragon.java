package cn.nukkit.block;

public class BlockHeadDragon extends BlockSkull {

    public BlockHeadDragon() {
        this(0);
    }

    public BlockHeadDragon(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return DRAGON_HEAD;
    }

    @Override
    public String getName() {
        return "Dragon Head";
    }

    @Override
    public SkullType getSkullType() {
        return SkullType.DRAGON;
    }
}