package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.math.NukkitMath;
import cn.nukkit.math.Vector3;
import cn.nukkit.network.protocol.LevelEventPacket;
import cn.nukkit.network.protocol.LevelSoundEventPacket;
import cn.nukkit.network.protocol.ProtocolInfo;

/**
 * @author glorydark
 */
public class ItemMace extends StringItemToolBase {

    public ItemMace() {
        super("minecraft:mace", "Mace");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_BRUSH;
    }

    @Override
    public int getAttackDamage() {
        return 5;
    }

    @Override
    public boolean onAttack(Player player, Entity entity) {
        int height = NukkitMath.floorDouble(player.highestPosition - player.y);
        if (height >= 1.5f) {
            entity.getLevel().addLevelEvent(entity, LevelEventPacket.PARTICLE_SMASH_ATTACK_GROUND_DUST);
            if (entity.isOnGround()) {
                entity.getLevel().addLevelSoundEvent(entity, LevelSoundEventPacket.SOUND_MACE_SMASH_GROUND);
            } else {
                entity.getLevel().addLevelSoundEvent(entity, LevelSoundEventPacket.SOUND_MACE_SMASH_AIR);
            }
            player.resetFallDistance();
            // Adding a small up movement to simulate slowing down on an attack
            player.setMotion(new Vector3(0, 0.05, 0));
        }
        return true;
    }

    @Override
    public int getAttackDamage(Entity entity) {
        int damage = 6;
        int height = NukkitMath.floorDouble(entity.highestPosition - entity.y);

        if (height < 1.5f) {
            return damage;
        }

        for (int i = 0; i <= height; i++) {
            if (i < 3) {
                damage += 4;
            } else if (i < 8) {
                damage += 2;
            } else {
                damage++;
            }
        }
        return damage;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_DIAMOND;
    }

    @Override
    public boolean isMace() {
        return true;
    }

    @Override
    public boolean isSupportedOn(int protocolId) {
        return protocolId >= ProtocolInfo.v1_21_0;
    }
}