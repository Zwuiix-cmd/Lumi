package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.entity.effect.Effect;
import cn.nukkit.entity.effect.EffectType;
import cn.nukkit.math.Vector3;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class ItemAppleGold extends ItemFood {

    public ItemAppleGold() {
        this(0, 1);
    }

    public ItemAppleGold(Integer meta) {
        this(meta, 1);
    }

    public ItemAppleGold(Integer meta, int count) {
        super(GOLDEN_APPLE, meta, count, "Golden Apple");
    }

    @Override
    public boolean onClickAir(Player player, Vector3 directionVector) {
        return true;
    }

    @Override
    public int getFoodRestore() {
        return 4;
    }

    @Override
    public float getSaturationRestore() {
        return 9.6F;
    }

    @Override
    public boolean onEaten(Player player) {
        player.addEffect(Effect.get(EffectType.REGENERATION).setAmplifier(1).setDuration(5 * 20));
        player.addEffect(Effect.get(EffectType.ABSORPTION).setAmplifier(0).setDuration(120 * 20));
        return true;
    }

}
