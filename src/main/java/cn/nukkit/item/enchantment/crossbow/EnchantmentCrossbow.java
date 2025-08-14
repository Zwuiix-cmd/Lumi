package cn.nukkit.item.enchantment.crossbow;

import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.item.enchantment.EnchantmentType;
import cn.nukkit.item.enchantment.EnchantmentRarity;

public abstract class EnchantmentCrossbow extends Enchantment {

    protected EnchantmentCrossbow(int id, String name, EnchantmentRarity rarity) {
        super(id, name, rarity, EnchantmentType.CROSSBOW);
    }
}
