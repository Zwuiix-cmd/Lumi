package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.ScoreEntry;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class SetScorePacket extends DataPacket {

    public Action action;
    public List<ScoreEntry> entries = new ArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.SET_SCORE_PACKET;
    }

    @Override
    public void decode() {
        //only server -> client
    }

    @Override
    public void encode() {

        this.reset();

        this.putByte((byte) this.action.ordinal());
        this.putUnsignedVarInt(this.entries.size());

        for (ScoreEntry entry : this.entries) {

            this.putVarLong(entry.scoreboardId);
            this.putString(entry.objectiveId);
            this.putLInt(entry.score);

            if (this.action == Action.SET) {

                this.putByte((byte) entry.type.ordinal());

                switch (entry.type) {

                    case ENTITY, PLAYER -> this.putVarLong(entry.entityId);
                    case FAKE -> this.putString(entry.name);
                    default -> throw new IllegalArgumentException("Invalid score info received");
                }
            }
        }
    }

    public enum Action {
        SET,
        REMOVE
    }
}
