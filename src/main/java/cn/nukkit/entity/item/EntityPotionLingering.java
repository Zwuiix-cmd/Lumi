package cn.nukkit.entity.item;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.effect.Effect;
import cn.nukkit.entity.effect.PotionType;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.DoubleTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;

import java.util.List;

public class EntityPotionLingering extends EntityPotion {

    public static final int NETWORK_ID = 101;

    public EntityPotionLingering(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    public EntityPotionLingering(FullChunk chunk, CompoundTag nbt, Entity shootingEntity) {
        super(chunk, nbt, shootingEntity);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Override
    protected void initEntity() {
        super.initEntity();

        this.setDataFlag(DATA_FLAGS, DATA_FLAG_LINGER, true);
    }

    @Override
    protected void splash(Entity collidedWith) {
        super.splash(collidedWith);
        saveNBT();
        ListTag<?> pos = (ListTag<?>) namedTag.getList("Pos", CompoundTag.class).copy();
        EntityAreaEffectCloud entity = (EntityAreaEffectCloud) Entity.createEntity(EntityAreaEffectCloud.NETWORK_ID, getChunk(),
                new CompoundTag().putList("Pos", pos)
                        .putList("Rotation", new ListTag<>()
                                .add(new FloatTag(0))
                                .add(new FloatTag(0))
                        )
                        .putList("Motion", new ListTag<>()
                                .add(new DoubleTag(0))
                                .add(new DoubleTag(0))
                                .add(new DoubleTag(0))
                        )
                        .putShort("PotionId", potionId)
        );

        List<Effect> effects = PotionType.get(potionId).getEffects(true);
        for (Effect effect : effects) {
            if (effect != null && entity != null) {
                entity.cloudEffects.add(effect.setVisible(false).setAmbient(false));
                entity.spawnToAll();
            }
        }
    }
}
