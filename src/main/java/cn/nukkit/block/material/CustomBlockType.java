package cn.nukkit.block.material;

import cn.nukkit.block.customblock.CustomBlock;
import lombok.Data;

@Data
public final class CustomBlockType implements BlockType {
    private final String identifier;
    private final int legacyId;

    public CustomBlockType(CustomBlock customBlock) {
        this.identifier = customBlock.getIdentifier();
        this.legacyId = customBlock.getId();
    }
}
