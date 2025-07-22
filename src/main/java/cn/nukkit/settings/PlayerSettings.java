package cn.nukkit.settings;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
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

    private boolean whitelist = false;

    @CustomKey("whitelist-reason")
    private String whitelistReason = "§cServer is white-listed";

    @CustomKey("save-player-data")
    private boolean savePlayerData = true;

    @CustomKey("save-player-data-by-uuid")
    private boolean savePlayerDataByUuid = true;

    @CustomKey("skin-change-cooldown")
    private int skinChangeCooldown = 15;

    @CustomKey("do-not-limit-skin-geometry")
    @Comment("Do not limit the geometry of the player's skin")
    private boolean doNotLimitSkinGeometry = true;

    @CustomKey("do-not-limit-interactions")
    @Comment("Do not limit the number of player interactions")
    private boolean doNotLimitInteractions = false;

    @CustomKey("persona-skins")
    private boolean personaSkins = true;

    @CustomKey("check-op-movement")
    private boolean checkOpMovement = false;

    @CustomKey("allow-flight")
    @Comment("Allow players to fly in survival mode with cheats")
    private boolean allowFlight = false;

    @CustomKey("stop-in-game")
    @Comment("Allows to use /stop command in game")
    private boolean stopInGame = false;

    @Comment("Allows to use /op command in game")
    @CustomKey("op-in-game")
    private boolean opInGame = true;

    @CustomKey("forced-safety-enchant")
    @Comment("Forcing server to set enchantment levels to value calculated by server")
    private boolean forcedSafetyEnchant = true;

    @CustomKey("space-name-mode")
    @Comment("Handling player names with space. It can be DISABLED, IGNORE and REPLACING")
    private SpaceNameMode spaceNameMode = SpaceNameMode.IGNORE;

    public enum SpaceNameMode {
        DISABLED,
        REPLACING,
        IGNORE
    }
}
