package cn.nukkit.block;

public class BlockHeadPlayer extends BlockSkull {

    public BlockHeadPlayer() {
        this(0);
    }

    public BlockHeadPlayer(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return PLAYER_HEAD;
    }

    @Override
    public String getName() {
        return "Player Head";
    }

    @Override
    public SkullType getSkullType() {
        return SkullType.PLAYER;
    }
}