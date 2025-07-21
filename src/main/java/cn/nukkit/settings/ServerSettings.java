package cn.nukkit.settings;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.Getter;

@Getter
public class ServerSettings extends OkaeriConfig {

    @CustomKey("general")
    @Comment("General server settings")
    private GeneralSettings generalSettings = new GeneralSettings();

    @CustomKey("network")
    @Comment("Server network settings")
    private NetworkSettings networkSettings = new NetworkSettings();

    @CustomKey("performance")
    @Comment("Server performance settings")
    private PerformanceSettings performanceSettings = new PerformanceSettings();

    @CustomKey("world")
    @Comment("World-related settings")
    private WorldSettings worldSettings = new WorldSettings();

    @CustomKey("player")
    @Comment("Player-related settings")
    private PlayerSettings playerSettings = new PlayerSettings();
}
