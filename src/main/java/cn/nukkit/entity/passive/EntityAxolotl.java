package cn.nukkit.entity.passive;

import cn.nukkit.Player;
import cn.nukkit.block.BlockWater;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityIntelligent;
import cn.nukkit.entity.EntitySwimmable;
import cn.nukkit.entity.EntityVariant;
import cn.nukkit.entity.ai.behavior.Behavior;
import cn.nukkit.entity.ai.behaviorgroup.BehaviorGroup;
import cn.nukkit.entity.ai.behaviorgroup.IBehaviorGroup;
import cn.nukkit.entity.ai.controller.*;
import cn.nukkit.entity.ai.evaluator.*;
import cn.nukkit.entity.ai.executor.*;
import cn.nukkit.entity.ai.memory.CoreMemoryTypes;
import cn.nukkit.entity.ai.route.finder.impl.ConditionalAStarRouteFinder;
import cn.nukkit.entity.ai.route.finder.impl.SimpleFlatAStarRouteFinder;
import cn.nukkit.entity.ai.route.finder.impl.SimpleSpaceAStarRouteFinder;
import cn.nukkit.entity.ai.route.posevaluator.SwimmingPosEvaluator;
import cn.nukkit.entity.ai.route.posevaluator.WalkingPosEvaluator;
import cn.nukkit.entity.ai.sensor.BlockSensor;
import cn.nukkit.entity.ai.sensor.NearestFeedingPlayerSensor;
import cn.nukkit.entity.ai.sensor.NearestPlayerSensor;
import cn.nukkit.entity.ai.sensor.NearestTargetEntitySensor;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBucket;
import cn.nukkit.level.Sound;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.potion.Effect;
import cn.nukkit.utils.Utils;
import it.unimi.dsi.fastutil.Pair;

import java.util.List;
import java.util.Set;

public class EntityAxolotl extends EntityAnimal implements EntitySwimmable, EntityVariant {
    public static final int NETWORK_ID = 130;

    private final static int[] VARIANTS = new int[] {0, 1, 2, 3, 4};

    private final static float[] DIFF_DAMAGE = new float[] {2, 2, 2};

    public EntityAxolotl(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Override
    public IBehaviorGroup requireBehaviorGroup() {
        return new BehaviorGroup(
                this.tickSpread,
                Set.of(
                        //用于刷新InLove状态的核心行为
                        new Behavior(
                                new InLoveExecutor(400),
                                all(
                                        new PassByTimeEvaluator(CoreMemoryTypes.LAST_BE_FEED_TIME, 0, 400),
                                        new PassByTimeEvaluator(CoreMemoryTypes.LAST_IN_LOVE_TIME, 6000, Integer.MAX_VALUE)
                                ),
                                1, 1, 1, false
                        ),
                        new Behavior(entity -> {
                            setMoveTarget(getMemoryStorage().get(CoreMemoryTypes.NEAREST_BLOCK));
                            return true;
                        }, all(
                                new MemoryCheckNotEmptyEvaluator(CoreMemoryTypes.NEAREST_BLOCK),
                                entity -> !isInsideOfWater(),
                                not(new DistanceEvaluator(CoreMemoryTypes.NEAREST_BLOCK, 9))
                        ), 1, 1)
                ),
                Set.of(
                        new Behavior(new PlaySoundExecutor(Sound.MOB_AXOLOTL_SPLASH), all(
                                entity -> getAirTicks() == 399
                        ), 7, 1),
                        new Behavior(new PlaySoundExecutor(Sound.MOB_AXOLOTL_IDLE_WATER), all(new RandomSoundEvaluator(), entity -> isInsideOfWater()), 7, 1),
                        new Behavior(new PlaySoundExecutor(Sound.MOB_AXOLOTL_IDLE), all(new RandomSoundEvaluator(), entity -> !isInsideOfWater()), 6, 1),
                        new Behavior(new MeleeAttackExecutor(CoreMemoryTypes.NEAREST_SUITABLE_ATTACK_TARGET, 0.3f, 17, true, 30), new EntityCheckEvaluator(CoreMemoryTypes.NEAREST_SUITABLE_ATTACK_TARGET), 5, 1),
                        new Behavior(new FlatRandomRoamExecutor(0.4f, 12, 40, true, 100, true, 10), new PassByTimeEvaluator(CoreMemoryTypes.LAST_BE_ATTACKED_TIME, 0, 100), 4, 1),
                        new Behavior(new EntityBreedingExecutor<>(EntityAxolotl.class, 16, 100, 0.5f), entity -> entity.getMemoryStorage().get(CoreMemoryTypes.IS_IN_LOVE), 3, 1),
                        new Behavior(new MoveToTargetExecutor(CoreMemoryTypes.NEAREST_FEEDING_PLAYER, 0.4f, true), new MemoryCheckNotEmptyEvaluator(CoreMemoryTypes.NEAREST_FEEDING_PLAYER), 2, 1),
                        new Behavior(new LookAtTargetExecutor(CoreMemoryTypes.NEAREST_PLAYER, 100), new ProbabilityEvaluator(4, 10), 1, 1, 100),
                        new Behavior(new FlatRandomRoamExecutor(0.2f, 12, 100, false, -1, false, 10), entity -> !entity.isInsideOfWater(), 1, 1),
                        new Behavior(new SpaceRandomRoamExecutor(0.36f, 12, 1, 80, false, -1, false, 10), Entity::isInsideOfWater, 1, 1)
                ),
                Set.of(
                        new NearestFeedingPlayerSensor(8, 0),
                        new NearestPlayerSensor(8, 0, 20),
                        new NearestTargetEntitySensor<>(0, 16, 20,
                                List.of(CoreMemoryTypes.NEAREST_SUITABLE_ATTACK_TARGET), this::attackTarget),
                        new BlockSensor(BlockWater.class, CoreMemoryTypes.NEAREST_BLOCK, 16, 5, 10),
                        entity -> {
                            if(getLevel().getCurrentTick() % 20 == 0) {
                                Entity lastAttack = getMemoryStorage().get(CoreMemoryTypes.LAST_ATTACK_ENTITY);
                                if(lastAttack != null) {
                                    if(!lastAttack.isAlive()) {
                                        if(lastAttack instanceof EntityIntelligent intelligent) {
                                            if(intelligent.getLastDamageCause() instanceof EntityDamageByEntityEvent event) {
                                                if(event.getDamager() instanceof Player player) {
                                                    player.removeEffect(Effect.MINING_FATIGUE);
                                                    player.addEffect(Effect.getEffect(Effect.REGENERATION).setDuration((player.hasEffect(Effect.REGENERATION) ? player.getEffect(Effect.REGENERATION).getDuration() : 0) + 100));
                                                }
                                            }
                                        }
                                        getMemoryStorage().clear(CoreMemoryTypes.LAST_ATTACK_ENTITY);
                                    }
                                }
                            }
                        }
                ),
                Set.of(new LookController(true, true),
                        new ConditionalController(Pair.of(Entity::isInsideOfWater, new DiveController()), Pair.of(Entity::isInsideOfWater, new SpaceMoveController()), Pair.of(entity -> !entity.isInsideOfWater(), new WalkController()), Pair.of(entity -> !entity.isInsideOfWater(), new FluctuateController()))),
                new ConditionalAStarRouteFinder(this,
                        Pair.of(ent -> !ent.isInsideOfWater(), new SimpleFlatAStarRouteFinder(new WalkingPosEvaluator(), this)),
                        Pair.of(Entity::isInsideOfWater, new SimpleSpaceAStarRouteFinder(new SwimmingPosEvaluator(), this))),
                this
        );
    }

    @Override
    public float getHeight() {
        return 0.42f;
    }

    @Override
    public float getWidth() {
        return 0.75f;
    }

    @Override
    public boolean attack(EntityDamageEvent source) {
        if(source.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION && getLevelBlock().canPassThrough()) {
            if(getAirTicks() > -5600 || getLevel().isRaining() || getLevel().isThundering()) return false;
        }
        return super.attack(source);
    }

    @Override
    protected void initEntity() {
        this.setMaxHealth(14);
        super.initEntity();
        if(!hasVariant()) {
            setVariant(randomVariant());
        }
    }

    @Override
    public String getOriginalName() {
        return "Axolotl";
    }

    @Override
    public boolean isBreedingItem(Item item) {
        return item.getId() == Item.BUCKET && item.getDamage() == ItemBucket.TROPICAL_FISH_BUCKET;
    }

    @Override
    protected boolean useBreedingItem(Player player, Item item) {
        getMemoryStorage().put(CoreMemoryTypes.LAST_FEED_PLAYER, player);
        getMemoryStorage().put(CoreMemoryTypes.LAST_BE_FEED_TIME, (int) getLevel().getCurrentTick());
        sendBreedingAnimation(item);
        return player.getInventory().setItemInHand(Item.get(Item.BUCKET, ItemBucket.WATER_BUCKET));
    }

    @Override
    public int[] getAllVariant() {
        return VARIANTS;
    }

    @Override
    public int randomVariant() {
        if(Utils.rand(0, 1200) == 0) return VARIANTS[VARIANTS.length-1];
        return VARIANTS[Utils.rand(0, VARIANTS.length-2)];
    }

    public boolean attackTarget(Entity entity) {
        return switch (entity.getNetworkId()) {
            case EntityCod.NETWORK_ID -> true;
            default -> false;
        };
    }
}