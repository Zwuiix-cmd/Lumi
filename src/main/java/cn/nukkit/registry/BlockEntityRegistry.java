package cn.nukkit.registry;

import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.blockentity.BlockEntityID;
import cn.nukkit.blockentity.impl.*;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BlockEntityRegistry implements IRegistry<String, Class<? extends BlockEntity>, Class<? extends BlockEntity>> {

    private static final BiMap<String, Class<? extends BlockEntity>> knownBlockEntities = HashBiMap.create(30);

    @Override
    public void init() {
        register(BlockEntityID.FURNACE, BlockEntityFurnace.class);
        register(BlockEntityID.BLAST_FURNACE, BlockEntityBlastFurnace.class);
        register(BlockEntityID.SMOKER, BlockEntitySmoker.class);
        register(BlockEntityID.CHEST, BlockEntityChest.class);
        register(BlockEntityID.SIGN, BlockEntitySign.class);
        register(BlockEntityID.ENCHANT_TABLE, BlockEntityEnchantTable.class);
        register(BlockEntityID.SKULL, BlockEntitySkull.class);
        register(BlockEntityID.FLOWER_POT, BlockEntityFlowerPot.class);
        register(BlockEntityID.BREWING_STAND, BlockEntityBrewingStand.class);
        register(BlockEntityID.ITEM_FRAME, BlockEntityItemFrame.class);
        register(BlockEntityID.GLOW_ITEM_FRAME, BlockEntityItemFrameGlow.class);
        register(BlockEntityID.CAULDRON, BlockEntityCauldron.class);
        register(BlockEntityID.ENDER_CHEST, BlockEntityEnderChest.class);
        register(BlockEntityID.BEACON, BlockEntityBeacon.class);
        register(BlockEntityID.PISTON_ARM, BlockEntityPistonArm.class);
        register(BlockEntityID.COMPARATOR, BlockEntityComparator.class);
        register(BlockEntityID.HOPPER, BlockEntityHopper.class);
        register(BlockEntityID.BED, BlockEntityBed.class);
        register(BlockEntityID.JUKEBOX, BlockEntityJukebox.class);
        register(BlockEntityID.SHULKER_BOX, BlockEntityShulkerBox.class);
        register(BlockEntityID.BANNER, BlockEntityBanner.class);
        register(BlockEntityID.DROPPER, BlockEntityDropper.class);
        register(BlockEntityID.DISPENSER, BlockEntityDispenser.class);
        register(BlockEntityID.MOB_SPAWNER, BlockEntitySpawner.class);
        register(BlockEntityID.MUSIC, BlockEntityMusic.class);
        register(BlockEntityID.LECTERN, BlockEntityLectern.class);
        register(BlockEntityID.BEEHIVE, BlockEntityBeehive.class);
        register(BlockEntityID.CAMPFIRE, BlockEntityCampfire.class);
        register(BlockEntityID.BELL, BlockEntityBell.class);
        register(BlockEntityID.BARREL, BlockEntityBarrel.class);
        register(BlockEntityID.MOVING_BLOCK, BlockEntityMovingBlock.class);
        register(BlockEntityID.END_GATEWAY, BlockEntityEndGateway.class);
        register(BlockEntityID.DECORATED_POT, BlockEntityDecoratedPot.class);
        register(BlockEntityID.TARGET, BlockEntityTarget.class);
        register(BlockEntityID.BRUSHABLE_BLOCK, BlockEntityBrushableBlock.class);
        register(BlockEntityID.CONDUIT, BlockEntityConduit.class);
        register(BlockEntityID.CHISELED_BOOKSHELF, BlockEntityChiseledBookshelf.class);
        register(BlockEntityID.HANGING_SIGN, BlockEntityHangingSign.class);
        register(BlockEntityID.SCULK_SENSOR, BlockEntitySculkSensor.class);

        // Persistent container, not on vanilla
        register(BlockEntityID.PERSISTENT_CONTAINER, PersistentDataContainerBlockEntity.class);
    }

    @Override
    public void register(String key, Class<? extends BlockEntity> value) {
        if (value == null) {
            throw new RegisterException("Tried to register null as BlockEntity with identifier:  " + key);
        }

        knownBlockEntities.put(key, value);
    }

    @Override
    public Class<? extends BlockEntity> get(String key) {
        return knownBlockEntities.get(key);
    }

    public String getSaveId(Class<? extends BlockEntity> blockEntity) {
        return knownBlockEntities.inverse().get(blockEntity);
    }

    public boolean isRegistered(String key) {
        return knownBlockEntities.containsKey(key);
    }

    @Override
    public void trim() {}

    @Override
    public void reload() {
        knownBlockEntities.clear();
        init();
    }
}
