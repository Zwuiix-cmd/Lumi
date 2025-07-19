package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.entity.effect.Effect;
import cn.nukkit.entity.effect.EffectType;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemChickenRaw extends ItemFood {

    public ItemChickenRaw() {
        this(0, 1);
    }

    public ItemChickenRaw(Integer meta) {
        this(meta, 1);
    }

    public ItemChickenRaw(Integer meta, int count) {
        super(RAW_CHICKEN, meta, count, "Raw Chicken");
    }

    @Override
    public int getFoodRestore() {
        return 2;
    }

    @Override
    public float getSaturationRestore() {
        return 1.2F;
    }

    @Override
    public boolean onEaten(Player player) {
        if(0.3F >= Math.random()) {
            player.addEffect(Effect.get(EffectType.HUNGER).setDuration(30 * 20));
        }

        return true;
    }

}
