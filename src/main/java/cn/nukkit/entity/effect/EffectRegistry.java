package cn.nukkit.entity.effect;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import me.sunlan.fastreflection.FastConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EffectRegistry {
    private static final Object2ObjectOpenHashMap<EffectType, FastConstructor<? extends Effect>> CACHE_CONSTRUCTORS = new Object2ObjectOpenHashMap<>();
    private static final Object2ObjectOpenHashMap<String, EffectType> STRING_ID_2_TYPE = new Object2ObjectOpenHashMap<>();
    private static final Object2ObjectOpenHashMap<Integer, EffectType> INT_ID_2_TYPE = new Object2ObjectOpenHashMap<>();
    private static final AtomicBoolean isLoad = new AtomicBoolean(false);

    public static Effect get(EffectType key) {
        try {
            FastConstructor<? extends Effect> fastConstructor = CACHE_CONSTRUCTORS.get(key);
            if (fastConstructor == null) return null;
            return (Effect) fastConstructor.invoke();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void init() {
        if (isLoad.getAndSet(true)) return;
        register(EffectType.SPEED, EffectSpeed.class);
        register(EffectType.SLOWNESS, EffectSlowness.class);
        register(EffectType.HASTE, EffectHaste.class);
        register(EffectType.MINING_FATIGUE, EffectMiningFatigue.class);
        register(EffectType.STRENGTH, EffectStrength.class);
        register(EffectType.INSTANT_HEALTH, EffectInstantHealth.class);
        register(EffectType.INSTANT_DAMAGE, EffectInstantDamage.class);
        register(EffectType.JUMP_BOOST, EffectJumpBoost.class);
        register(EffectType.NAUSEA, EffectNausea.class);
        register(EffectType.REGENERATION, EffectRegeneration.class);
        register(EffectType.RESISTANCE, EffectResistance.class);
        register(EffectType.FIRE_RESISTANCE, EffectFireResistance.class);
        register(EffectType.WATER_BREATHING, EffectWaterBreathing.class);
        register(EffectType.INVISIBILITY, EffectInvisibility.class);
        register(EffectType.BLINDNESS, EffectBlindness.class);
        register(EffectType.NIGHT_VISION, EffectNightVision.class);
        register(EffectType.HUNGER, EffectHunger.class);
        register(EffectType.WEAKNESS, EffectWeakness.class);
        register(EffectType.POISON, EffectPoison.class);
        register(EffectType.WITHER, EffectWither.class);
        register(EffectType.HEALTH_BOOST, EffectHealthBoost.class);
        register(EffectType.ABSORPTION, EffectAbsorption.class);
        register(EffectType.SATURATION, EffectSaturation.class);
        register(EffectType.LEVITATION, EffectLevitation.class);
        register(EffectType.FATAL_POISON, EffectFatalPoison.class);
        register(EffectType.SLOW_FALLING, EffectSlowFalling.class);
        register(EffectType.CONDUIT_POWER, EffectConduitPower.class);
        register(EffectType.BAD_OMEN, EffectBadOmen.class);
        register(EffectType.VILLAGE_HERO, EffectVillageHero.class);
        register(EffectType.DARKNESS, EffectDarkness.class);
    }

    public static EffectType getType(String stringId) {
        return STRING_ID_2_TYPE.get(stringId);
    }

    public static EffectType getType(Integer id) {
        return INT_ID_2_TYPE.get(id);
    }

    public static Map<String, EffectType> getEffectStringId2TypeMap() {
        return Collections.unmodifiableMap(STRING_ID_2_TYPE);
    }

    public static Map<Integer, EffectType> getEffectId2TypeMap() {
        return Collections.unmodifiableMap(INT_ID_2_TYPE);
    }

    public static void register(EffectType type, Class<? extends Effect> effect) {
        try {
            FastConstructor<? extends Effect> c = FastConstructor.create(effect.getConstructor());
            if (CACHE_CONSTRUCTORS.putIfAbsent(type, c) == null) {
                STRING_ID_2_TYPE.put(type.stringId(), type);
                if (type.id() != null) {
                    INT_ID_2_TYPE.put(type.id(), type);
                }
            } else {
                throw new RuntimeException("This effect has already been registered with the identifier: " + type);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
