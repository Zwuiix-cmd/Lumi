package cn.nukkit.item.enchantment.loot;

import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.item.enchantment.EnchantmentType;
import cn.nukkit.item.enchantment.EnchantmentRarity;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class EnchantmentLootDigging extends EnchantmentLoot {

    public EnchantmentLootDigging() {
        super(Enchantment.ID_FORTUNE_DIGGING, "lootBonusDigger", EnchantmentRarity.RARE, EnchantmentType.DIGGER);
    }
}
