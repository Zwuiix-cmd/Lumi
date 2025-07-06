package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.network.protocol.ProtocolInfo;

public class ItemDoorCherry extends StringItemBase {

    public ItemDoorCherry() {
        super(ItemNamespaceId.CHERRY_DOOR, "Mangrove Door");
        block = Block.get(BlockID.CHERRY_DOOR);
    }

    @Override
    public boolean isSupportedOn(int protocolId) {
        return protocolId >= ProtocolInfo.v1_20_0;
    }
}
