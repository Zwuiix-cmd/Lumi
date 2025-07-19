package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.entity.effect.Effect;
import cn.nukkit.entity.effect.EffectType;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package cn.nukkit.item in project nukkit.
 */
public class ItemSpiderEye extends ItemFood {

    public ItemSpiderEye() {
        this(0, 1);
    }

    public ItemSpiderEye(Integer meta) {
        this(meta, 1);
    }

    public ItemSpiderEye(Integer meta, int count) {
        super(SPIDER_EYE, meta, count, "Spider Eye");
    }

    @Override
    public int getFoodRestore() {
        return 2;
    }

    @Override
    public float getSaturationRestore() {
        return 3.2F;
    }

    @Override
    public boolean onEaten(Player player) {
        player.addEffect(Effect.get(EffectType.POISON).setDuration(5 * 20));

        return true;
    }
}
