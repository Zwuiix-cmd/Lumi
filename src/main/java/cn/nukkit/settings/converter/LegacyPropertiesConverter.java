package cn.nukkit.settings.converter;

import cn.nukkit.settings.ServerSettings;
import cn.nukkit.settings.WorldSettings;
import cn.nukkit.settings.WorldSettings.AntiXraySettings.AntiXrayMode;
import cn.nukkit.utils.Config;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Slf4j
public class LegacyPropertiesConverter {

    private final ServerSettings settings;
    private final File file;
    private Config config;

    public LegacyPropertiesConverter(ServerSettings settings) {
        this.settings = settings;
        this.file = new File("server.properties");
        if (!file.exists()) {
            return;
        }
        this.config = new Config(file, Config.PROPERTIES);
    }

    public void convert() {
        if (config == null) return;

        log.info("Converting the old server.properties configuration to the new format...");

        // General Settings
        var general = settings.getGeneral();
        general.setMotd(this.getPropertyString("motd", general.getMotd()));
        general.setSubMotd(this.getPropertyString("sub-motd", general.getSubMotd()));
        general.setServerPort(this.getPropertyInt("server-port", general.getServerPort()));
        general.setServerIp(this.getPropertyString("server-ip", general.getServerIp()));
        general.setMaxPlayers(this.getPropertyInt("max-players", general.getMaxPlayers()));
        general.setLanguage(this.getPropertyString("language", general.getLanguage()));
        general.setForceLanguage(this.getPropertyBoolean("force-language", general.isForceLanguage()));
        general.setForceResources(this.getPropertyBoolean("force-resources", general.isForceResources()));
        general.setForceResourcesAllowClientPacks(this.getPropertyBoolean("force-resources-allow-client-packs", general.isForceResourcesAllowClientPacks()));
        general.setShutdownMessage(this.getPropertyString("shutdown-message", general.getShutdownMessage()));
        general.setUpdateNotifications(this.getPropertyBoolean("update-notifications", general.isUpdateNotifications()));
        general.setBstatsMetrics(this.getPropertyBoolean("bstats-metrics", general.isBstatsMetrics()));
        general.setAnsiTitle(this.getPropertyBoolean("ansi-title", general.isAnsiTitle()));
        general.setDebugLevel(this.getPropertyInt("debug-level", general.getDebugLevel()));
        general.setDeprecatedVerbose(this.getPropertyBoolean("deprecated-verbose", general.isDeprecatedVerbose()));
        general.setEnableSpark(this.getPropertyBoolean("enable-spark", general.isEnableSpark()));
        general.setUseWaterdog(this.getPropertyBoolean("use-waterdog", general.isUseWaterdog()));
        general.setEnableExperimentMode(this.getPropertyBoolean("enable-experiment-mode", general.isEnableExperimentMode()));
        general.setServerAuthoritativeMovement(this.getPropertyString("server-authoritative-movement", general.getServerAuthoritativeMovement()));
        general.setServerAuthoritativeBlockBreaking(this.getPropertyBoolean("server-authoritative-block-breaking", general.isServerAuthoritativeBlockBreaking()));
        general.setAutomaticBugReport(this.getPropertyBoolean("automatic-bug-report", general.isAutomaticBugReport()));
        general.setHastebinToken(this.getPropertyString("hastebin-token", general.getHastebinToken()));
        general.setCallDataPkSendEvent(this.getPropertyBoolean("call-data-pk-send-event", general.isCallDataPkSendEvent()));
        general.setCallBatchPkSendEvent(this.getPropertyBoolean("call-batch-pk-send-event", general.isCallBatchPkSendEvent()));
        general.setCallEntityMotionEvent(this.getPropertyBoolean("call-entity-motion-event", general.isCallEntityMotionEvent()));

        // Multiversion settings
        general.getMultiversion().setMinProtocol(this.getPropertyInt("multiversion-min-protocol", general.getMultiversion().getMinProtocol()));
        general.getMultiversion().setMaxProtocol(this.getPropertyInt("multiversion-max-protocol", general.getMultiversion().getMaxProtocol()));

        // Network Settings
        var network = settings.getNetwork();
        network.setXboxAuth(this.getPropertyBoolean("xbox-auth", network.isXboxAuth()));
        network.setXboxAuthTempIpBan(this.getPropertyBoolean("temp-ip-ban-failed-xbox-auth", network.isXboxAuthTempIpBan()));
        network.setStrongIpBans(this.getPropertyBoolean("strong-ip-bans", network.isStrongIpBans()));
        network.setEnableRakSendCookie(this.getPropertyBoolean("enable-rak-send-cookie", network.isEnableRakSendCookie()));
        network.setRakPacketLimit(this.getPropertyInt("rak-packet-limit", network.getRakPacketLimit()));
        network.setTimeoutMilliseconds(this.getPropertyInt("timeout-milliseconds", network.getTimeoutMilliseconds()));
        network.setEnableQuery(this.getPropertyBoolean("enable-query", network.isEnableQuery()));
        network.setQueryPlugins(this.getPropertyBoolean("query-plugins", network.isQueryPlugins()));
        network.setEncryption(this.getPropertyBoolean("encryption", network.isEncryption()));

        // RCON Settings
        network.getRcon().setEnable(this.getPropertyBoolean("enable-rcon", network.getRcon().isEnable()));
        network.getRcon().setPassword(this.getPropertyString("rcon.password", network.getRcon().getPassword()));
        network.getRcon().setPort(this.getPropertyInt("rcon.port", network.getRcon().getPort()));

        // Compression Settings
        network.getCompression().setZlibProvider(this.getPropertyInt("zlib-provider", network.getCompression().getZlibProvider()));
        network.getCompression().setCompressionLevel(this.getPropertyInt("compression-level", network.getCompression().getCompressionLevel()));
        network.getCompression().setCompressionThreshold(this.getPropertyInt("compression-threshold", network.getCompression().getCompressionThreshold()));
        network.getCompression().setUseSnappyCompression(this.getPropertyBoolean("use-snappy-compression", network.getCompression().isUseSnappyCompression()));

        // World Settings
        var world = settings.getWorld();
        world.setDefaultWorldName(this.getPropertyString("level-name", world.getDefaultWorldName()));
        world.setDefaultWorldSeed(this.getPropertyString("level-seed", world.getDefaultWorldSeed()));
        world.setDefaultWorldType(this.getPropertyString("level-type", world.getDefaultWorldType()));
        world.setGeneratorSettings(this.getPropertyString("generator-settings", world.getGeneratorSettings()));
        world.setLoadAllWorlds(this.getPropertyBoolean("load-all-worlds", world.isLoadAllWorlds()));
        world.setViewDistance(this.getPropertyInt("view-distance", world.getViewDistance()));
        world.setSpawnProtection(this.getPropertyInt("spawn-protection", world.getSpawnProtection()));
        world.setDifficulty(this.getPropertyString("difficulty", world.getDifficulty()));
        world.setAllowPvp(this.getPropertyBoolean("pvp", world.isAllowPvp()));
        world.setEnableHardcore(this.getPropertyBoolean("hardcore", world.isEnableHardcore()));
        world.setEnableNether(this.getPropertyBoolean("nether", world.isEnableNether()));
        world.setEnableEnd(this.getPropertyBoolean("end", world.isEnableEnd()));
        world.setDropSpawners(this.getPropertyBoolean("drop-spawners", world.isDropSpawners()));
        world.setExplosionBreakBlocks(this.getPropertyBoolean("explosion-break-blocks", world.isExplosionBreakBlocks()));
        world.setPortalTicks(this.getPropertyInt("portal-ticks", world.getPortalTicks()));
        world.setWorldAutoCompaction(this.getPropertyBoolean("level-auto-compaction", world.isWorldAutoCompaction()));
        world.setWorldAutoCompactionTicks(this.getPropertyInt("level-auto-compaction-ticks", world.getWorldAutoCompactionTicks()));
        world.setCacheChunks(this.getPropertyBoolean("cache-chunks", world.isCacheChunks()));
        world.setAsyncChunks(this.getPropertyBoolean("async-chunks", world.isAsyncChunks()));
        world.setLightUpdates(this.getPropertyBoolean("light-updates", world.isLightUpdates()));
        world.setClearChunkTickList(this.getPropertyBoolean("clear-chunk-tick-list", world.isClearChunkTickList()));
        world.setLeveldbCacheMb(this.getPropertyInt("leveldb-cache-mb", world.getLeveldbCacheMb()));
        world.setUseNativeLeveldb(this.getPropertyBoolean("use-native-leveldb", world.isUseNativeLeveldb()));

        // Multi-nether worlds
        String multiNetherWorlds = this.getPropertyString("multi-nether-worlds", "");
        if (!multiNetherWorlds.isEmpty()) {
            world.setMultiNetherWorlds(Arrays.asList(multiNetherWorlds.split(",")));
        }

        // Do not tick worlds
        String doNotTickWorlds = this.getPropertyString("do-not-tick-worlds", "");
        if (!doNotTickWorlds.isEmpty()) {
            world.setDoNotTickWorlds(Arrays.asList(doNotTickWorlds.split(",")));
        }

        world.setDoWorldGc(this.getPropertyBoolean("do-level-gc", world.isDoWorldGc()));

        // Entity Settings
        world.getEntity().setSpawnAnimals(this.getPropertyBoolean("spawn-animals", world.getEntity().isSpawnAnimals()));
        world.getEntity().setSpawnMobs(this.getPropertyBoolean("spawn-mobs", world.getEntity().isSpawnMobs()));
        world.getEntity().setEntityAutoSpawnTask(this.getPropertyBoolean("entity-auto-spawn-task", world.getEntity().isEntityAutoSpawnTask()));
        world.getEntity().setEntityDespawnTask(this.getPropertyBoolean("entity-despawn-task", world.getEntity().isEntityDespawnTask()));
        world.getEntity().setTicksPerEntitySpawns(this.getPropertyInt("ticks-per-entity-spawns", world.getEntity().getTicksPerEntitySpawns()));
        world.getEntity().setTicksPerEntityDespawns(this.getPropertyInt("ticks-per-entity-despawns", world.getEntity().getTicksPerEntityDespawns()));
        world.getEntity().setMobAi(this.getPropertyBoolean("mob-ai", world.getEntity().isMobAi()));
        world.getEntity().setSpawnThreshold(this.getPropertyInt("spawn-threshold", world.getEntity().getSpawnThreshold()));
        world.getEntity().setCallEntityMotionEvent(this.getPropertyBoolean("call-entity-motion-event", world.getEntity().isCallEntityMotionEvent()));
        world.getEntity().setWorldsEntitySpawningDisabled(this.getPropertyString("worlds-entity-spawning-disabled", world.getEntity().getWorldsEntitySpawningDisabled()));

        // Chunk Settings
        world.getChunk().setCompressionLevel(Math.max(Math.min(this.getPropertyInt("chunk-compression-level", 7), 9), 1));
        world.getChunk().setSendingPerTick(this.getPropertyInt("chunk-sending-per-tick", world.getChunk().getSendingPerTick()));
        world.getChunk().setTickingPerTick(this.getPropertyInt("chunk-ticking-per-tick", world.getChunk().getTickingPerTick()));
        world.getChunk().setTickingRadius(this.getPropertyInt("chunk-ticking-radius", world.getChunk().getTickingRadius()));
        world.getChunk().setGenerationQueueSize(this.getPropertyInt("chunk-generation-queue-size", world.getChunk().getGenerationQueueSize()));
        world.getChunk().setGenerationPopulationQueueSize(this.getPropertyInt("chunk-generation-population-queue-size", world.getChunk().getGenerationPopulationQueueSize()));

        // AutoSave Settings
        world.getAutoSave().setEnable(this.getPropertyBoolean("auto-save", world.getAutoSave().isEnable()));
        world.getAutoSave().setPerTicks(this.getPropertyInt("ticks-per-autosave", world.getAutoSave().getPerTicks()));
        String disabledWorlds = this.getPropertyString("worlds-level-auto-save-disabled", "");
        if (!disabledWorlds.isEmpty()) {
            world.getAutoSave().setDisabledWorlds(Arrays.asList(disabledWorlds.split(",")));
        }

        // Anti-Xray Settings
        String antiXrayWorlds = this.getPropertyString("anti-xray-worlds", "");
        if (!antiXrayWorlds.isEmpty()) {
            AntiXrayMode mode = AntiXrayMode.valueOf(this.getPropertyString("anti-xray-mode", "LOW"));
            boolean preDeobfuscate = this.getPropertyBoolean("anti-xray-pre-deobfuscate", false);

            Map<String, WorldSettings.AntiXraySettings> antiXrayMap = new HashMap<>();
            for (String worldName : antiXrayWorlds.split(",")) {
                WorldSettings.AntiXraySettings antiXraySettings = new WorldSettings.AntiXraySettings();
                antiXraySettings.setMode(mode);
                antiXraySettings.setPreDeobfuscate(preDeobfuscate);
                antiXrayMap.put(worldName.trim(), antiXraySettings);
            }
            world.getAntiXray().putAll(antiXrayMap);
        }

        // Features Settings
        world.getFeatures().setVanillaPortals(this.getPropertyBoolean("vanilla-portals", world.getFeatures().isVanillaPortals()));
        world.getFeatures().setVanillaBossbars(this.getPropertyBoolean("vanilla-bossbars", world.getFeatures().isVanillaBossbars()));
        world.getFeatures().setEnableRawOres(this.getPropertyBoolean("enable-raw-ores", world.getFeatures().isEnableRawOres()));
        world.getFeatures().setEnableNewPaintings(this.getPropertyBoolean("enable-new-paintings", world.getFeatures().isEnableNewPaintings()));
        world.getFeatures().setEnableNewChickenEggsLaying(this.getPropertyBoolean("enable-new-chicken-eggs-laying", world.getFeatures().isEnableNewChickenEggsLaying()));

        // Player Settings
        var player = settings.getPlayer();
        player.setDefaultGamemode(this.getPropertyInt("gamemode", player.getDefaultGamemode()));
        player.setForceGamemode(this.getPropertyBoolean("force-gamemode", player.isForceGamemode()));
        player.setAchievements(this.getPropertyBoolean("achievements", player.isAchievements()));
        player.setAnnouncePlayerAchievements(this.getPropertyBoolean("announce-player-achievements", player.isAnnouncePlayerAchievements()));
        player.setWhitelist(this.getPropertyBoolean("white-list", player.isWhitelist()));
        player.setWhitelistReason(this.getPropertyString("whitelist-reason", player.getWhitelistReason()));
        player.setBedSpawnpoints(this.getPropertyBoolean("bed-spawnpoints", player.isBedSpawnpoints()));
        player.setSavePlayerData(this.getPropertyBoolean("save-player-data", player.isSavePlayerData()));
        player.setSavePlayerDataByUuid(this.getPropertyBoolean("save-player-data-by-uuid", player.isSavePlayerDataByUuid()));
        player.setSkinChangeCooldown(this.getPropertyInt("skin-change-cooldown", player.getSkinChangeCooldown()));
        player.setDoNotLimitSkinGeometry(this.getPropertyBoolean("do-not-limit-skin-geometry", player.isDoNotLimitSkinGeometry()));
        player.setDoNotLimitInteractions(this.getPropertyBoolean("do-not-limit-interactions", player.isDoNotLimitInteractions()));
        player.setPersonaSkins(this.getPropertyBoolean("persona-skins", player.isPersonaSkins()));
        player.setCheckOpMovement(this.getPropertyBoolean("check-op-movement", player.isCheckOpMovement()));
        player.setCheckOpMovement(this.getPropertyBoolean("allow-flight", player.isAllowFlight()));
        player.setStopInGame(this.getPropertyBoolean("stop-in-game", player.isStopInGame()));
        player.setOpInGame(this.getPropertyBoolean("op-in-game", player.isOpInGame()));
        player.setSpawnEggs(this.getPropertyBoolean("spawn-eggs", player.isSpawnEggs()));
        player.setSpawnMobsFromBlocks(this.getPropertyBoolean("spawn-mobs-from-blocks", player.isSpawnMobsFromBlocks()));
        player.setAnvilsEnabled(this.getPropertyBoolean("anvils-enabled", player.isAnvilsEnabled()));
        player.setForcedSafetyEnchant(this.getPropertyBoolean("forced-safety-enchant", player.isForcedSafetyEnchant()));
        player.setXpBottlesOnCreative(this.getPropertyBoolean("xp-bottles-on-creative", player.isXpBottlesOnCreative()));
        player.setSpaceNameMode(this.getPropertyString("space-name-mode", player.getSpaceNameMode()));
        player.setUseClientSpectator(this.getPropertyBoolean("use-client-spectator", player.isUseClientSpectator()));

        // Performance Settings
        var performance = settings.getPerformance();
        performance.setAsyncWorkers(this.getPropertyString("async-workers", String.valueOf(performance.getAsyncWorkers())));
        performance.setAutoTickRate(this.getPropertyBoolean("auto-tick-rate", performance.isAutoTickRate()));
        performance.setAutoTickRateLimit(this.getPropertyInt("auto-tick-rate-limit", performance.getAutoTickRateLimit()));
        performance.setBaseTickRate(this.getPropertyInt("base-tick-rate", performance.getBaseTickRate()));
        performance.setAlwaysTickPlayers(this.getPropertyBoolean("always-tick-players", performance.isAlwaysTickPlayers()));
        performance.setThreadWatchdog(this.getPropertyBoolean("thread-watchdog", performance.isThreadWatchdog()));
        performance.setThreadWatchdogTick(this.getPropertyInt("thread-watchdog-tick", performance.getThreadWatchdogTick()));

        settings.save();

        if (file.delete()) {
            log.info("Server configuration successfully converted");
        } else {
            log.warn("Failed to delete the old configuration");
        }
    }

    public String getPropertyString(String key, String defaultValue) {
        return this.config.exists(key) ? this.config.getString(key) : defaultValue;
    }

    public int getPropertyInt(String variable, Integer defaultValue) {
        Object value = this.config.get(variable);
        if (value == null) {
            value = defaultValue;
        }
        if (value instanceof Integer integer) {
            return integer;
        }
        String trimmed = String.valueOf(value).trim();
        if (trimmed.isEmpty()) {
            return defaultValue;
        }
        return Integer.parseInt(trimmed);
    }

    public boolean getPropertyBoolean(String variable, boolean defaultValue) {
        Object value = this.config.exists(variable) ? this.config.get(variable) : defaultValue;
        if (value instanceof Boolean bool) {
            return bool;
        }
        return switch (String.valueOf(value).trim().toLowerCase(Locale.ROOT)) {
            case "on", "true", "1", "yes" -> true;
            default -> false;
        };
    }
}

