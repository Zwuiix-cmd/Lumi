package cn.nukkit.registry;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Registries {
    public static final EffectRegistry EFFECT = new EffectRegistry();
    public static final FuelRegistry FUEL = new FuelRegistry();
    public static final PotionRegistry POTION = new PotionRegistry();
}
