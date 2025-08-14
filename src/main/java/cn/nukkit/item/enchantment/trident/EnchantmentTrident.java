package cn.nukkit.item.enchantment.trident;

import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.item.enchantment.EnchantmentType;
import cn.nukkit.item.enchantment.EnchantmentRarity;

public abstract class EnchantmentTrident extends Enchantment {

    protected EnchantmentTrident(int id, String name, EnchantmentRarity rarity) {
        super(id, name, rarity, EnchantmentType.TRIDENT);
    }
}
