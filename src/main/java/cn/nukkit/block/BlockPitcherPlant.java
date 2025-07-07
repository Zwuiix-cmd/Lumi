package cn.nukkit.block;

public class BlockPitcherPlant extends BlockTransparentMeta {
    public BlockPitcherPlant(int meta) {
        super(meta);
    }

    public BlockPitcherPlant() {
        this(0);
    }


    @Override
    public String getName() {
        return "Pitcher Plant";
    }

    @Override
    public int getId() {
        return PITCHER_PLANT;
    }
}
