package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.network.protocol.ProtocolInfo;

public class ItemDoorBamboo extends StringItemBase {

    public ItemDoorBamboo() {
        super(ItemNamespaceId.BAMBOO_DOOR, "Mangrove Door");
        block = Block.get(BlockID.BAMBOO_DOOR);
    }

    @Override
    public boolean isSupportedOn(int protocolId) {
        return protocolId >= ProtocolInfo.v1_20_0;
    }
}
