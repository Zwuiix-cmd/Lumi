package cn.nukkit.entity.effect;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class PotionRegistry {
    private static final Object2ObjectOpenHashMap<String, PotionType> REGISTRY = new Object2ObjectOpenHashMap<>();
    private static final Object2ObjectOpenHashMap<Integer, PotionType> ID_2_POTION = new Object2ObjectOpenHashMap<>();
    private static final AtomicBoolean isLoad = new AtomicBoolean(false);

    public static void init() {
        if (isLoad.getAndSet(true)) return;
        register(PotionType.WATER);
        register(PotionType.MUNDANE);
        register(PotionType.MUNDANE_LONG);
        register(PotionType.THICK);
        register(PotionType.AWKWARD);
        register(PotionType.NIGHT_VISION);
        register(PotionType.NIGHT_VISION_LONG);
        register(PotionType.INVISIBILITY);
        register(PotionType.INVISIBILITY_LONG);
        register(PotionType.LEAPING);
        register(PotionType.LEAPING_LONG);
        register(PotionType.LEAPING_STRONG);
        register(PotionType.FIRE_RESISTANCE);
        register(PotionType.FIRE_RESISTANCE_LONG);
        register(PotionType.SWIFTNESS);
        register(PotionType.SWIFTNESS_LONG);
        register(PotionType.SWIFTNESS_STRONG);
        register(PotionType.SLOWNESS);
        register(PotionType.SLOWNESS_LONG);
        register(PotionType.WATER_BREATHING);
        register(PotionType.WATER_BREATHING_LONG);
        register(PotionType.HEALING);
        register(PotionType.HEALING_STRONG);
        register(PotionType.HARMING);
        register(PotionType.HARMING_STRONG);
        register(PotionType.POISON);
        register(PotionType.POISON_LONG);
        register(PotionType.POISON_STRONG);
        register(PotionType.REGENERATION);
        register(PotionType.REGENERATION_LONG);
        register(PotionType.REGENERATION_STRONG);
        register(PotionType.STRENGTH);
        register(PotionType.STRENGTH_LONG);
        register(PotionType.STRENGTH_STRONG);
        register(PotionType.WEAKNESS);
        register(PotionType.WEAKNESS_LONG);
        register(PotionType.WITHER);
        register(PotionType.TURTLE_MASTER);
        register(PotionType.TURTLE_MASTER_LONG);
        register(PotionType.TURTLE_MASTER_STRONG);
        register(PotionType.SLOW_FALLING);
        register(PotionType.SLOW_FALLING_LONG);
        register(PotionType.SLOWNESS_STRONG);
        register(PotionType.WIND_CHARGED);
        register(PotionType.WEAVING);
        register(PotionType.OOZING);
        register(PotionType.INFESTED);
    }

    public static PotionType get(String key) {
        return REGISTRY.get(key);
    }

    public static PotionType get(int id) {
        return ID_2_POTION.get(id);
    }

    public static Map<String, PotionType> getPotions() {
        return Collections.unmodifiableMap(REGISTRY);
    }

    public static Map<Integer, PotionType> getPotionId2TypeMap() {
        return Collections.unmodifiableMap(ID_2_POTION);
    }

    public static void register(String key, PotionType value) {
        if (REGISTRY.putIfAbsent(key, value) == null) {
            ID_2_POTION.put(value.id(), value);
        } else {
            throw new RuntimeException("This potion has already been registered with the identifier: " + key);
        }
    }

    private static void register(PotionType value) {
        register(value.stringId(), value);
    }
}
