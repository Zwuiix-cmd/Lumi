
package cn.nukkit.level.util;

import cn.nukkit.block.Block;
import cn.nukkit.level.DimensionData;
import cn.nukkit.level.Level;
import java.util.concurrent.ConcurrentHashMap;

public final class SimpleTickCachedBlockStore implements TickCachedBlockStore {
    private volatile ConcurrentHashMap<Integer, Block> tickCachedBlockStore;
    private final DimensionData dimensionData;

    public SimpleTickCachedBlockStore(Level level) {
        this.tickCachedBlockStore = new ConcurrentHashMap<>(32, 0.75f);
        this.dimensionData = level.getDimensionData();
    }

    @Override
    public void clearCachedStore() {
        //Replacing map with new instance instead of clearing for better performance
        tickCachedBlockStore = new ConcurrentHashMap<>(32, 0.75f);
    }

    @Override
    public void saveIntoCachedStore(Block block, int x, int y, int z, int layer) {
        int hash = Level.localBlockHash(x, y, z, layer, dimensionData);
        tickCachedBlockStore.put(hash, block);
    }

    @Override
    public Block getFromCachedStore(int x, int y, int z, int layer) {
        return tickCachedBlockStore.get(Level.localBlockHash(x, y, z, layer, dimensionData));
    }

    @Override
    public Block computeFromCachedStore(int x, int y, int z, int layer,
                                        CachedBlockComputer computer) {
        int hash = Level.localBlockHash(x, y, z, layer, dimensionData);
        return tickCachedBlockStore.computeIfAbsent(hash, k -> computer.compute());
    }
}