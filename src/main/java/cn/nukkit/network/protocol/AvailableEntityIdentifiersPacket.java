package cn.nukkit.network.protocol;

import cn.nukkit.Nukkit;
import cn.nukkit.Server;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.EntityManager;
import com.google.common.io.ByteStreams;

import java.io.InputStream;

public class AvailableEntityIdentifiersPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.AVAILABLE_ENTITY_IDENTIFIERS_PACKET;

    public static final byte[] NBT419;
    public static final byte[] NBT440;
    public static final byte[] NBT527;
    public static final byte[] NBT544;
    public static final byte[] TAG; //582

    static {
        NBT419 = loadEntityIdentifiers(419);
        NBT440 = loadEntityIdentifiers(440);
        NBT527 = loadEntityIdentifiers(527);
        NBT544 = loadEntityIdentifiers(544);
        TAG = loadEntityIdentifiers(582);
    }

    private static byte[] loadEntityIdentifiers(int protocol) {
        try (InputStream stream = Nukkit.class.getClassLoader().getResourceAsStream("entity_identifiers_" + protocol + ".dat")) {
            return ByteStreams.toByteArray(stream);
        } catch (Exception e) {
            throw new AssertionError("Error whilst loading entity identifiers " + protocol, e);
        }
    }

    public byte[] identifiers;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
    }

    @Override
    public void encode() {
        this.reset();
        if (Server.getInstance().getSettings().general().enableExperimentMode()) { //自定义实体
            if (this.protocol <= ProtocolInfo.v1_16_0) {
                this.put(EntityManager.get().getNetworkTagCachedOld());
            } else {
                this.put(EntityManager.get().getNetworkTagCached());
            }
        }else {
            if (this.identifiers == null) {
                this.identifiers = Entity.getEntityIdentifiersCache(this.protocol);
            }
            this.put(this.identifiers);
        }
    }
}
