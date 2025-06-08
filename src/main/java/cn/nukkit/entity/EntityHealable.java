package cn.nukkit.entity;

import cn.nukkit.item.Item;

public interface EntityHealable {
    /**
     * 获得可以治疗食物的治疗量
     */
    int getHealingAmount(Item item);
}
