package cn.nukkit.entity.ai.controller;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityIntelligent;
import cn.nukkit.entity.EntityPhysical;
import cn.nukkit.entity.data.ByteEntityData;
import cn.nukkit.entity.mob.EntitySlime;
import cn.nukkit.entity.passive.EntityRabbit;
import cn.nukkit.level.Sound;
import cn.nukkit.math.Vector3;

public class HoppingController extends WalkController {

    protected int moveCooldown = 0;

    protected int currentJumpCoolDown = 0;

    public HoppingController(int moveCooldown) {
        this.moveCooldown = moveCooldown;
    }

    @Override
    public boolean control(EntityIntelligent entity) {
        currentJumpCoolDown++;
        if (entity.hasMoveDirection() && !entity.isShouldUpdateMoveDirection() && currentJumpCoolDown > moveCooldown) {
            //clone防止异步导致的NPE
            Vector3 direction = entity.getMoveDirectionEnd().clone();
            var speed = entity.getMovementSpeed();
            if (entity.motionX * entity.motionX + entity.motionZ * entity.motionZ > speed * speed * 0.4756) {
                entity.setDataFlag(Entity.DATA_FLAGS, Entity.DATA_FLAG_MOVING, false);
                return false;
            }
            var relativeVector = direction.clone().setComponents(direction.x - entity.x,
                    direction.y - entity.y, direction.z - entity.z);
            var xzLengthSquared = relativeVector.x * relativeVector.x + relativeVector.z * relativeVector.z;
            if (Math.abs(xzLengthSquared) < EntityPhysical.PRECISION) {
                entity.setDataFlag(Entity.DATA_FLAGS, Entity.DATA_FLAG_MOVING, false);
                return false;
            }
            var xzLength = Math.sqrt(relativeVector.x * relativeVector.x + relativeVector.z * relativeVector.z);
            var k = speed / xzLength * 0.33;
            var dx = relativeVector.x * k;
            var dz = relativeVector.z * k;
            var dy = 0.0d;
            if (entity.isOnGround()) {
                double diffY = entity.getScale();
                dy += entity.getJumpingMotion(diffY);
                Sound jumpSound = entity instanceof EntityRabbit ? Sound.MOB_RABBIT_HOP : entity instanceof EntitySlime ? Sound.JUMP_SLIME : null;
                if(jumpSound != null) entity.getLevel().addSound(entity, jumpSound);
                entity.setDataProperty(new ByteEntityData(Entity.DATA_CLIENT_EVENT,2)); //Why this needs to be here? Idk, cuz this was stolen from PNX
                currentJumpCoolDown = 0;
            }
            entity.addTmpMoveMotion(new Vector3(dx, dy, dz));
            entity.setDataFlag(Entity.DATA_FLAGS, Entity.DATA_FLAG_MOVING, true);
            if (xzLength < speed) {
                needNewDirection(entity);
                return false;
            }
            return true;
        } else {
            entity.setDataFlag(Entity.DATA_FLAGS, Entity.DATA_FLAG_MOVING, false);
            return false;
        }
    }


}