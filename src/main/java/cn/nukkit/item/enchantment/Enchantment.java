package cn.nukkit.item.enchantment;

import cn.nukkit.Server;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.item.Item;
import cn.nukkit.registry.Registries;
import cn.nukkit.utils.Identifier;
import cn.nukkit.utils.OK;
import cn.nukkit.utils.TextFormat;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public abstract class Enchantment implements Cloneable, EnchantmentID {

    public static final Enchantment[] EMPTY_ARRAY = new Enchantment[0];

    private final int id;

    @Nullable
    protected final Identifier identifier;
    protected final String name;

    protected final EnchantmentRarity rarity;
    protected EnchantmentType type;
    protected int level = 1;

    protected Enchantment(int id, String name, EnchantmentRarity rarity, EnchantmentType type) {
        this.id = id;
        this.identifier = null;
        this.name = name;
        this.rarity = rarity;
        this.type = type;
    }

    protected Enchantment(@NotNull Identifier identifier, String name, EnchantmentRarity rarity, @NotNull EnchantmentType type) {
        this.id = CUSTOM_ENCHANTMENT_ID;
        this.identifier = identifier;
        this.name = name;
        this.rarity = rarity;
        this.type = type;
    }

    public static Enchantment get(int id) {
        return Registries.ENCHANTMENT.get(id);
    }

    public static Enchantment get(String name) {
        if (Identifier.isValid(name)) {
            return Registries.ENCHANTMENT.get(Identifier.tryParse(name));
        } else {
            return Registries.ENCHANTMENT.get(new Identifier(Identifier.DEFAULT_NAMESPACE, name));
        }
    }

    @Nullable
    public Identifier getIdentifier() {
        return identifier;
    }

    public String getName() {
        if (this.identifier == null) {
            return "%enchantment." + this.name;
        } else {
            return this.name;
        }
    }

    public int getId() {
        return id;
    }

    public EnchantmentRarity getRarity() {
        return this.rarity;
    }

    public String getLore() {
        return TextFormat.GRAY + this.getName() + " " + Enchantment.getLevelString(this.getLevel());
    }

    public int getLevel() {
        return level;
    }

    public Enchantment setLevel(int level) {
        return this.setLevel(level, true);
    }

    public Enchantment setLevel(int level, boolean safe) {
        if (!safe && !Server.getInstance().getSettings().player().forcedSafetyEnchant()) {
            this.level = level;
            return this;
        }

        if (level > this.getMaxLevel()) {
            this.level = this.getMaxLevel();
        } else {
            this.level = Math.max(level, this.getMinLevel());
        }

        return this;
    }

    public int getWeight() {
        return this.rarity.getWeight();
    }

    public int getMinLevel() {
        return 1;
    }

    public int getMaxLevel() {
        return 1;
    }

    public int getMaxEnchantableLevel() {
        return getMaxLevel();
    }

    public int getMinEnchantAbility(int level) {
        return 1 + level * 10;
    }

    public int getMaxEnchantAbility(int level) {
        return this.getMinEnchantAbility(level) + 5;
    }

    public float getProtectionFactor(EntityDamageEvent event) {
        return 0;
    }

    public double getDamageBonus(Entity entity, Entity attacker) {
        return 0;
    }

    public void doPostAttack(Entity attacker, Entity entity) {

    }

    public void doAttack(Entity attacker, Entity entity) {

    }

    public void doPostHurt(Entity attacker, Entity entity) {

    }

    public final boolean isCompatibleWith(Enchantment enchantment) {
        return this.checkCompatibility(enchantment) && enchantment.checkCompatibility(this);
    }

    protected boolean checkCompatibility(Enchantment enchantment) {
        return this != enchantment;
    }

    public String getOriginalName() {
        return this.name;
    }

    public boolean canEnchant(Item item) {
        return this.type.canEnchantItem(item);
    }

    public boolean isMajor() {
        return false;
    }

    public boolean isTreasure() {
        return false;
    }

    @Deprecated
    public static Enchantment getEnchantment(int id) {
        return get(id).clone();
    }

    @Deprecated
    public static Enchantment getEnchantment(@NotNull Identifier id) {
        return Registries.ENCHANTMENT.get(id);
    }

    @Deprecated
    public static OK<?> register(Enchantment enchantment, boolean registerItem) {
        Registries.ENCHANTMENT.registerCustom(enchantment, registerItem);
        return OK.TRUE;
    }

    @Deprecated
    public static Enchantment[] getEnchantments() {
        return Registries.ENCHANTMENT.getIdentifierToEnchantment().values().toArray(EMPTY_ARRAY);
    }

    @Deprecated
    public static Collection<Enchantment> getRegisteredEnchantments() {
        return Registries.ENCHANTMENT.getIdentifierToEnchantment().values();
    }

    @Deprecated
    public static Map<String, Integer> getEnchantmentName2IDMap() {
        return Registries.ENCHANTMENT.getIdentifierToEnchantment().entrySet().stream().collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().getId()));
    }

    @Override
    protected Enchantment clone() {
        try {
            return (Enchantment) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public static String getLevelString(int level) {
        return switch (level) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            default -> "∞";
        };
    }
}
