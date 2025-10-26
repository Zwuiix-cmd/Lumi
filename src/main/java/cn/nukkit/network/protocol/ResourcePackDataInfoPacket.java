package cn.nukkit.network.protocol;

import cn.nukkit.Player;
import cn.nukkit.math.MathHelper;
import cn.nukkit.resourcepacks.ResourcePack;
import lombok.ToString;

import java.util.UUID;

@ToString(exclude = "sha256")
public class ResourcePackDataInfoPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.RESOURCE_PACK_DATA_INFO_PACKET;

    public static final int TYPE_INVALID = 0;
    public static final int TYPE_ADDON = 1;
    public static final int TYPE_CACHED = 2;
    public static final int TYPE_COPY_PROTECTED = 3;
    public static final int TYPE_BEHAVIOR = 4;
    public static final int TYPE_PERSONA_PIECE = 5;
    public static final int TYPE_RESOURCE = 6;
    public static final int TYPE_SKINS = 7;
    public static final int TYPE_WORLD_TEMPLATE = 8;
    public static final int TYPE_COUNT = 9;

    public UUID packId;
    public int maxChunkSize;
    public int chunkCount;
    public long compressedPackSize;
    public byte[] sha256;
    public boolean premium;
    public int type = TYPE_RESOURCE;

    public static ResourcePackDataInfoPacket create(UUID packId, int maxChunkSize, int chunkCount, long compressedPackSize, byte[] sha256, boolean premium) {
        ResourcePackDataInfoPacket packet = new ResourcePackDataInfoPacket();
        packet.packId = packId;
        packet.maxChunkSize = maxChunkSize;
        packet.chunkCount = chunkCount;
        packet.compressedPackSize = compressedPackSize;
        packet.sha256 = sha256;
        packet.premium = premium;
        return packet;
    }

    public static ResourcePackDataInfoPacket from(ResourcePack resourcePack) {
        return create(
                resourcePack.getPackId(),
                Player.RESOURCE_PACK_CHUNK_SIZE,
                MathHelper.ceil(resourcePack.getPackSize() / (float) Player.RESOURCE_PACK_CHUNK_SIZE),
                resourcePack.getPackSize(),
                resourcePack.getSha256(),
                false
        );
    }

    @Override
    public void decode() {
        this.packId = UUID.fromString(this.getString());
        this.maxChunkSize = this.getLInt();
        this.chunkCount = this.getLInt();
        this.compressedPackSize = this.getLLong();
        this.sha256 = this.getByteArray();
        this.premium = this.getBoolean();
        this.type = this.getByte();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.packId.toString());
        this.putLInt(this.maxChunkSize);
        this.putLInt(this.chunkCount);
        this.putLLong(this.compressedPackSize);
        this.putByteArray(this.sha256);
        this.putBoolean(this.premium);
        this.putByte((byte) this.type);
    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }
}
