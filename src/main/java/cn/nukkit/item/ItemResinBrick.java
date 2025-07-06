package cn.nukkit.item;

import cn.nukkit.network.protocol.ProtocolInfo;

public class ItemResinBrick extends StringItemBase {
    public ItemResinBrick() {
        super(RESIN_BRICK, "Resin Brick");
    }

    @Override
    public boolean isSupportedOn(int protocolId) {
        return protocolId >= ProtocolInfo.v1_21_50;
    }
}
