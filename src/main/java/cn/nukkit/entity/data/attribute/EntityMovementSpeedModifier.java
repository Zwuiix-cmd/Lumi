package cn.nukkit.entity.data.attribute;

import lombok.Getter;
import lombok.ToString;

@ToString
public class EntityMovementSpeedModifier {
    @Getter private final String identifier;
    @Getter private final float value;
    @Getter private final Operation operation;
    @Getter private final boolean send;

    public EntityMovementSpeedModifier(String identifier, float value, Operation operation) {
        this(identifier, value, operation, true);
    }

    public EntityMovementSpeedModifier(String identifier, float value, Operation operation, boolean send) {
        this.identifier = identifier;
        this.value = value;
        this.operation = operation;
        this.send = send;
    }

    public enum Operation {
        ADD,
        MULTIPLY
    }
}
