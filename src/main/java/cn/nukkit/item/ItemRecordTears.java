package cn.nukkit.item;

import cn.nukkit.network.protocol.ProtocolInfo;

public class ItemRecordTears extends ItemRecord implements StringItem {
    public ItemRecordTears() {
        super(STRING_IDENTIFIED_ITEM, 0, 1);
    }

    @Override
    public String getSoundId() {
        return "record.tears";
    }

    @Override
    public String getNamespaceId() {
        return MUSIC_DISC_TEARS;
    }

    @Override
    public String getNamespaceId(int protocolId) {
        return MUSIC_DISC_TEARS;
    }

    @Override
    public boolean isSupportedOn(int protocolId) {
        return protocolId >= ProtocolInfo.v1_21_90;
    }
}