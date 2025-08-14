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

import static cn.nukkit.utils.Utils.dynamic;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public abstract class Enchantment implements Cloneable {

    public static final Enchantment[] EMPTY_ARRAY = new Enchantment[0];

    public static final int CUSTOM_ENCHANTMENT_ID = dynamic(256);

    public static final int ID_PROTECTION_ALL = 0;
    public static final String NAME_PROTECTION_ALL = "protection";

    public static final int ID_PROTECTION_FIRE = 1;
    public static final String NAME_PROTECTION_FIRE = "fire_protection";

    public static final int ID_PROTECTION_FALL = 2;
    public static final String NAME_PROTECTION_FALL = "feather_falling";

    public static final int ID_PROTECTION_EXPLOSION = 3;
    public static final String NAME_PROTECTION_EXPLOSION = "blast_protection";

    public static final int ID_PROTECTION_PROJECTILE = 4;
    public static final String NAME_PROTECTION_PROJECTILE = "projectile_protection";

    public static final int ID_THORNS = 5;
    public static final String NAME_THORNS = "thorns";

    public static final int ID_WATER_BREATHING = 6;
    public static final String NAME_WATER_BREATHING = "respiration";

    public static final int ID_WATER_WALKER = 7;
    public static final String NAME_WATER_WALKER = "depth_strider";

    public static final int ID_WATER_WORKER = 8;
    public static final String NAME_WATER_WORKER = "aqua_affinity";

    public static final int ID_DAMAGE_ALL = 9;
    public static final String NAME_DAMAGE_ALL = "sharpness";

    public static final int ID_DAMAGE_SMITE = 10;
    public static final String NAME_DAMAGE_SMITE = "smite";

    public static final int ID_DAMAGE_ARTHROPODS = 11;
    public static final String NAME_DAMAGE_ARTHROPODS = "bane_of_arthropods";

    public static final int ID_KNOCKBACK = 12;
    public static final String NAME_KNOCKBACK = "knockback";

    public static final int ID_FIRE_ASPECT = 13;
    public static final String NAME_FIRE_ASPECT = "fire_aspect";

    public static final int ID_LOOTING = 14;
    public static final String NAME_LOOTING = "looting";

    public static final int ID_EFFICIENCY = 15;
    public static final String NAME_EFFICIENCY = "efficiency";

    public static final int ID_SILK_TOUCH = 16;
    public static final String NAME_SILK_TOUCH = "silk_touch";

    public static final int ID_DURABILITY = 17;
    public static final String NAME_DURABILITY = "unbreaking";

    public static final int ID_FORTUNE_DIGGING = 18;
    public static final String NAME_FORTUNE_DIGGING = "fortune";

    public static final int ID_BOW_POWER = 19;
    public static final String NAME_BOW_POWER = "power";

    public static final int ID_BOW_KNOCKBACK = 20;
    public static final String NAME_BOW_KNOCKBACK = "punch";

    public static final int ID_BOW_FLAME = 21;
    public static final String NAME_BOW_FLAME = "flame";

    public static final int ID_BOW_INFINITY = 22;
    public static final String NAME_BOW_INFINITY = "infinity";

    public static final int ID_FORTUNE_FISHING = 23;
    public static final String NAME_FORTUNE_FISHING = "luck_of_the_sea";

    public static final int ID_LURE = 24;
    public static final String NAME_LURE = "lure";

    public static final int ID_FROST_WALKER = 25;
    public static final String NAME_FROST_WALKER = "frost_walker";

    public static final int ID_MENDING = 26;
    public static final String NAME_MENDING = "mending";

    public static final int ID_BINDING_CURSE = 27;
    public static final String NAME_BINDING_CURSE = "binding";

    public static final int ID_VANISHING_CURSE = 28;
    public static final String NAME_VANISHING_CURSE = "vanishing";

    public static final int ID_TRIDENT_IMPALING = 29;
    public static final String NAME_TRIDENT_IMPALING = "impaling";

    public static final int ID_TRIDENT_RIPTIDE = 30;
    public static final String NAME_TRIDENT_RIPTIDE = "riptide";

    public static final int ID_TRIDENT_LOYALTY = 31;
    public static final String NAME_TRIDENT_LOYALTY = "loyalty";

    public static final int ID_TRIDENT_CHANNELING = 32;
    public static final String NAME_TRIDENT_CHANNELING = "channeling";

    public static final int ID_CROSSBOW_MULTISHOT = 33;
    public static final String NAME_CROSSBOW_MULTISHOT = "multishot";

    public static final int ID_CROSSBOW_PIERCING = 34;
    public static final String NAME_CROSSBOW_PIERCING = "piercing";

    public static final int ID_CROSSBOW_QUICK_CHARGE = 35;
    public static final String NAME_CROSSBOW_QUICK_CHARGE = "quick_charge";

    public static final int ID_SOUL_SPEED = 36;
    public static final String NAME_SOUL_SPEED = "soul_speed";

    public static final int ID_SWIFT_SNEAK = 37;
    public static final String NAME_SWIFT_SNEAK = "swift_sneak";

    public static final int ID_WIND_BURST = 38;

    public static final String NAME_WIND_BURST = "wind_burst";

    public static final int ID_DENSITY = 39;

    public static final String NAME_DENSITY = "density";

    public static final int ID_BREACH = 40;

    public static final String NAME_BREACH = "breach";

    private final int id;
    @Nullable
    protected final Identifier identifier;
    protected final String name;

    protected final Rarity rarity;
    protected EnchantmentType type;
    protected int level = 1;

    protected Enchantment(int id, String name, Rarity rarity, EnchantmentType type) {
        this.id = id;
        this.identifier = null;
        this.name = name;
        this.rarity = rarity;
        this.type = type;
    }

    protected Enchantment(@NotNull Identifier identifier, String name, Rarity rarity, @NotNull EnchantmentType type) {
        this.id = CUSTOM_ENCHANTMENT_ID;
        this.identifier = identifier;
        this.name = name;
        this.rarity = rarity;
        this.type = type;
    }

    @Deprecated
    public static Enchantment get(int id) {
        Enchantment enchantment = Registries.ENCHANTMENT.get(id);
        if (enchantment == null) {
            return new UnknownEnchantment(id);
        }
        return enchantment;
    }

    @Deprecated
    public static Enchantment getEnchantment(int id) {
        return get(id).clone();
    }

    @Deprecated
    public static Enchantment getEnchantment(String name) {
        if (Identifier.isValid(name)) {
            return Registries.ENCHANTMENT.get(Identifier.tryParse(name));
        } else {
            return Registries.ENCHANTMENT.get(new Identifier(Identifier.DEFAULT_NAMESPACE, name));
        }
    }

    @Deprecated
    public static Enchantment getEnchantment(@NotNull Identifier id) {
        Enchantment enchantment = Registries.ENCHANTMENT.get(id);
        if (enchantment == null) {
            return new UnknownEnchantment(id);
        }
        return enchantment;
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

    @Nullable
    public Identifier getIdentifier() {
        return identifier;
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

    public int getId() {
        return id;
    }

    public Rarity getRarity() {
        return this.rarity;
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

    public String getName() {
        if (this.identifier == null) {
            return "%enchantment." + this.name;
        } else {
            return this.name;
        }
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

    private static class UnknownEnchantment extends Enchantment {

        protected UnknownEnchantment(int id) {
            super(id, "unknown", Rarity.VERY_RARE, EnchantmentType.ALL);
        }

        protected UnknownEnchantment(Identifier identifier) {
            super(identifier, "unknown", Rarity.VERY_RARE, EnchantmentType.ALL);
        }
    }

    public enum Rarity {
        COMMON(10),
        UNCOMMON(5),
        RARE(2),
        VERY_RARE(1);

        private final int weight;

        Rarity(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return this.weight;
        }

        public static Rarity fromWeight(int weight) {
            if (weight < 2) {
                return VERY_RARE;
            } else if (weight < 5) {
                return RARE;
            } else if (weight < 10) {
                return UNCOMMON;
            }
            return COMMON;
        }
    }
}
