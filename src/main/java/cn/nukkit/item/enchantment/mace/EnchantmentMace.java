package cn.nukkit.item.enchantment.mace;

import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.item.enchantment.EnchantmentType;
import cn.nukkit.item.enchantment.EnchantmentRarity;

public abstract class EnchantmentMace extends Enchantment {

    protected EnchantmentMace(int id, String identifier, EnchantmentRarity rarity) {
        super(id, identifier, rarity, EnchantmentType.MACE);
    }

    @Override
    public boolean canEnchant(Item item) {
        return item.getNamespaceId().equals("minecraft:mace");
    }
}