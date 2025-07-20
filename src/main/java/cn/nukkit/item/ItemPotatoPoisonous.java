package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.entity.effect.Effect;
import cn.nukkit.entity.effect.EffectType;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package cn.nukkit.item in project nukkit.
 */
public class ItemPotatoPoisonous extends ItemPotato {

    public ItemPotatoPoisonous() {
        this(0, 1);
    }

    public ItemPotatoPoisonous(Integer meta) {
        this(meta, 1);
    }

    public ItemPotatoPoisonous(Integer meta, int count) {
        super(POISONOUS_POTATO, meta, count, "Poisonous Potato");
    }

    @Override
    public boolean onEaten(Player player) {
        if (0.6F >= Math.random()) {
            player.addEffect(Effect.get(EffectType.POISON).setDuration(80));
        }
        return true;
    }

    @Override
    public int getFoodRestore() {
        return 2;
    }

    @Override
    public float getSaturationRestore() {
        return 1.2F;
    }
}
