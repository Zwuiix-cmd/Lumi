package cn.nukkit.registry;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Registries {
    public static final EffectRegistry EFFECT = new EffectRegistry();
    public static final FuelRegistry FUEL = new FuelRegistry();
    public static final PotionRegistry POTION = new PotionRegistry();
    public static final DispenseBehaviorRegistry DISPENSE_BEHAVIOR = new DispenseBehaviorRegistry();
    public static final BlockEntityRegistry BLOCK_ENTITY = new BlockEntityRegistry();
    public static final EntityRegistry ENTITY = new EntityRegistry();
}
