package cn.nukkit.settings;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class WorldSettings extends OkaeriConfig {

    @CustomKey("default-world-name")
    private String defaultWorldName = "world";

    @CustomKey("default-world-seed")
    private String defaultWorldSeed = "";

    @CustomKey("default-world-type")
    private String defaultWorldType = "default";

    @CustomKey("generator-settings")
    private String generatorSettings = "";

    @CustomKey("load-all-worlds")
    private boolean loadAllWorlds;

    @CustomKey("view-distance")
    private int viewDistance = 8;

    @CustomKey("spawn-protection")
    private int spawnProtection = 10;

    private String difficulty = "2";

    @CustomKey("allow-pvp")
    private boolean allowPvp = true;

    @CustomKey("enable-hardcore")
    private boolean enableHardcore = false;

    @CustomKey("enable-nether")
    private boolean enableNether = true;

    @CustomKey("enable-end")
    private boolean enableEnd = true;

    @CustomKey("drop-spawners")
    private boolean dropSpawners = true;

    @CustomKey("explosion-break-blocks")
    private boolean explosionBreakBlocks;

    @CustomKey("multi-nether-worlds")
    private List<String> multiNetherWorlds = new ArrayList<>();

    @CustomKey("portal-ticks")
    private int portalTicks = 80;

    @CustomKey("do-not-tick-worlds")
    private List<String> doNotTickWorlds = new ArrayList<>();

    @CustomKey("do-world-gc")
    private boolean doWorldGc = true;

    @CustomKey("world-auto-compaction")
    private boolean worldAutoCompaction = true;

    @CustomKey("world-auto-compaction-ticks")
    private int worldAutoCompactionTicks = 36000;

    @CustomKey("cache-chunks")
    private boolean cacheChunks = false;

    @CustomKey("async-chunks")
    private boolean asyncChunks = true;

    @CustomKey("light-updates")
    private boolean lightUpdates = false;

    @CustomKey("clear-chunk-tick-list")
    private boolean clearChunkTickList = true;

    @CustomKey("leveldb-cache-mb")
    private int leveldbCacheMb = 80;

    @CustomKey("use-native-leveldb")
    private boolean useNativeLeveldb = false;

    @Setter(value = AccessLevel.NONE)
    @CustomKey("entity")
    private EntitySettings entity = new EntitySettings();

    @Setter(value = AccessLevel.NONE)
    @CustomKey("chunk")
    private ChunkSettings chunk = new ChunkSettings();

    @Setter(value = AccessLevel.NONE)
    @CustomKey("auto-save")
    private AutoSaveSettings autoSave = new AutoSaveSettings();

    @CustomKey("anti-xray")
    @Comment("AntiXray settings")
    @Comment("Example:")
    @Comment("anti-xray:")
    @Comment("  world:")
    @Comment("      mode: LOW")
    @Comment("      pre-deobfuscate: false")
    @Setter(value = AccessLevel.NONE)
    private Map<String, AntiXraySettings> antiXray = new HashMap<>();

    @CustomKey("features")
    private FeaturesSettings features = new FeaturesSettings();

    @Getter
    @Setter
    public static class EntitySettings extends OkaeriConfig {

        @CustomKey("spawn-animals")
        private boolean spawnAnimals = true;

        @CustomKey("spawn-mobs")
        private boolean spawnMobs = true;

        @CustomKey("entity-auto-spawn-task")
        private boolean entityAutoSpawnTask = true;

        @CustomKey("entity-despawn-task")
        private boolean entityDespawnTask = true;

        @CustomKey("ticks-per-entity-spawns")
        private int ticksPerEntitySpawns = 200;

        @CustomKey("ticks-per-entity-despawns")
        private int ticksPerEntityDespawns = 12000;

        @CustomKey("mob-ai")
        private boolean mobAi = true;

        @CustomKey("spawn-threshold")
        private int spawnThreshold = 56;

        @CustomKey("call-entity-motion-event")
        private boolean callEntityMotionEvent = true;

        @CustomKey("worlds-entity-spawning-disabled")
        private String worldsEntitySpawningDisabled = "";
    }

    @Getter
    @Setter
    public static class ChunkSettings extends OkaeriConfig {

        @CustomKey("compression-level")
        private int compressionLevel;

        @CustomKey("sending-per-tick")
        private int sendingPerTick = 4;

        @CustomKey("ticking-per-tick")
        private int tickingPerTick = 40;

        @CustomKey("ticking-radius")
        private int tickingRadius = 3;

        @CustomKey("generation-queue-size")
        private int generationQueueSize = 8;

        @CustomKey("generation-population-queue-size")
        private int generationPopulationQueueSize = 8;
    }

    @Getter
    @Setter
    public static class AutoSaveSettings extends OkaeriConfig {

        @CustomKey("enable")
        private boolean enable = true;

        @CustomKey("per-ticks")
        private int perTicks = 6000;

        @CustomKey("disabled-worlds")
        private List<String> disabledWorlds = new ArrayList<>();
    }

    @Getter
    @Setter
    public static class AntiXraySettings extends OkaeriConfig {

        private AntiXrayMode mode = AntiXrayMode.LOW;

        @CustomKey("pre-deobfuscate")
        private boolean preDeobfuscate;

        public enum AntiXrayMode {
            LOW,
            MEDIUM,
            HIGH
        }
    }

    @Getter
    @Setter
    public static class FeaturesSettings extends OkaeriConfig {

        @CustomKey("vanilla-portals")
        private boolean vanillaPortals = true;

        @CustomKey("vanilla-bossbars")
        private boolean vanillaBossbars = true;

        @CustomKey("enable-raw-ores")
        private boolean enableRawOres = true;

        @CustomKey("enable-new-paintings")
        private boolean enableNewPaintings = true;

        @CustomKey("enable-new-chicken-eggs-laying")
        private boolean enableNewChickenEggsLaying = true;
    }
}
