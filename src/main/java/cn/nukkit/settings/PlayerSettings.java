package cn.nukkit.settings;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class PlayerSettings extends OkaeriConfig {

    @CustomKey("default-gamemode")
    private int defaultGamemode = 0;

    @CustomKey("force-gamemode")
    private boolean forceGamemode = true;

    private boolean achievements = false;

    @CustomKey("announce-player-achievements")
    private boolean announcePlayerAchievements = false;

    private boolean whitelist = false;

    @CustomKey("whitelist-reason")
    private String whitelistReason = "§cServer is white-listed";

    @CustomKey("bed-spawnpoints")
    private boolean bedSpawnpoints = true;

    @CustomKey("save-player-data")
    private boolean savePlayerData = true;

    @CustomKey("save-player-data-by-uuid")
    private boolean savePlayerDataByUuid = true;

    @CustomKey("skin-change-cooldown")
    private int skinChangeCooldown = 15;

    @CustomKey("do-not-limit-skin-geometry")
    private boolean doNotLimitSkinGeometry = true;

    @CustomKey("do-not-limit-interactions")
    private boolean doNotLimitInteractions = false;

    @CustomKey("persona-skins")
    private boolean personaSkins = true;

    @CustomKey("check-op-movement")
    private boolean checkOpMovement = false;

    @CustomKey("allow-flight")
    private boolean allowFlight = false;

    @CustomKey("stop-in-game")
    private boolean stopInGame = false;

    @CustomKey("op-in-game")
    private boolean opInGame = true;

    @CustomKey("spawn-eggs")
    private boolean spawnEggs = true;

    @CustomKey("spawn-mobs-from-blocks")
    private boolean spawnMobsFromBlocks;

    @CustomKey("anvils-enabled")
    private boolean anvilsEnabled = true;

    @CustomKey("forced-safety-enchant")
    private boolean forcedSafetyEnchant = true;

    @CustomKey("xp-bottles-on-creative")
    private boolean xpBottlesOnCreative = true;

    @CustomKey("space-name-mode")
    private String spaceNameMode = "ignore";

    @CustomKey("use-client-spectator")
    private boolean useClientSpectator = true;
}
