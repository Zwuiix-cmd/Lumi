package cn.nukkit.block;

public class BlockPitcherCrop extends BlockTransparentMeta {
    public BlockPitcherCrop(int meta) {
        super(meta);
    }

    public BlockPitcherCrop() {
        this(0);
    }


    @Override
    public String getName() {
        return "Pitcher Crop";
    }

    @Override
    public int getId() {
        return PITCHER_CROP;
    }
}
