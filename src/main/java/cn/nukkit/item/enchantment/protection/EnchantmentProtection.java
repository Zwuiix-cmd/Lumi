package cn.nukkit.item.enchantment.protection;

import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.item.enchantment.EnchantmentType;
import cn.nukkit.item.enchantment.EnchantmentRarity;
import lombok.Getter;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
@Getter
public abstract class EnchantmentProtection extends Enchantment {

    protected final Type protectionType;

    protected EnchantmentProtection(int id, String name, EnchantmentRarity rarity, Type type) {
        super(id, name, rarity, EnchantmentType.ARMOR);
        this.protectionType = type;
        if (protectionType == Type.FALL) {
            this.type = EnchantmentType.ARMOR_FEET;
        }
    }

    @Override
    public String getName() {
        return "%enchantment.protect." + this.name;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    public double getTypeModifier() {
        return 0;
    }

    @Override
    public boolean isMajor() {
        return true;
    }

    @Override
    public boolean checkCompatibility(Enchantment enchantment) {
        if (enchantment instanceof EnchantmentProtection protection) {
            if (protection.protectionType == this.protectionType) {
                return false;
            }
            return protection.protectionType == Type.FALL || this.protectionType == Type.FALL;
        }
        return super.checkCompatibility(enchantment);
    }

    public enum Type {
        ALL,
        FIRE,
        FALL,
        EXPLOSION,
        PROJECTILE
    }
}
