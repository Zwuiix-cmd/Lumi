package cn.nukkit.item.enchantment.mace;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemMace;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.item.enchantment.EnchantmentRarity;
import cn.nukkit.item.enchantment.EnchantmentType;

public abstract class EnchantmentMace extends Enchantment {

    protected EnchantmentMace(int id, String identifier, EnchantmentRarity rarity) {
        super(id, identifier, rarity, EnchantmentType.MACE);
    }

    @Override
    public boolean canEnchant(Item item) {
        return item instanceof ItemMace;
    }
}