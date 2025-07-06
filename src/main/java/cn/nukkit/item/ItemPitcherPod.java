package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.network.protocol.ProtocolInfo;

public class ItemPitcherPod extends StringItemBase {

    public ItemPitcherPod() {
        super(PITCHER_POD, "Pitcher Pod");
        //block = Block.get(PITCHER_CROP); TODO: uncomment when implemented
    }

    @Override
    public boolean isSupportedOn(int protocolId) {
        return protocolId >= ProtocolInfo.v1_20_0;
    }
}