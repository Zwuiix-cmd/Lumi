package cn.nukkit.item.enchantment.loot;

import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.item.enchantment.EnchantmentType;
import cn.nukkit.item.enchantment.EnchantmentRarity;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class EnchantmentLootFishing extends EnchantmentLoot {

    public EnchantmentLootFishing() {
        super(Enchantment.ID_FORTUNE_FISHING, "lootBonusFishing", EnchantmentRarity.RARE, EnchantmentType.FISHING_ROD);
    }
}
