package cn.nukkit.block.material;

import cn.nukkit.block.Block;

public interface BlockType {

    String getIdentifier();

    int getLegacyId();

    default Block createBlock() {
        return Block.get(this.getLegacyId());
    }
}
