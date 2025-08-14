package cn.nukkit.item.enchantment;

import cn.nukkit.item.Item;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class EnchantmentSilkTouch extends Enchantment {

    public EnchantmentSilkTouch() {
        super(ID_SILK_TOUCH, "untouching", EnchantmentRarity.VERY_RARE, EnchantmentType.DIGGER);
    }

    @Override
    public int getMinEnchantAbility(int level) {
        return 15;
    }

    @Override
    public int getMaxEnchantAbility(int level) {
        return super.getMinEnchantAbility(level) + 50;
    }

    @Override
    public boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && enchantment.getId() != ID_FORTUNE_DIGGING;
    }

    @Override
    public boolean canEnchant(Item item) {
        return item.isShears() || super.canEnchant(item);
    }
}
