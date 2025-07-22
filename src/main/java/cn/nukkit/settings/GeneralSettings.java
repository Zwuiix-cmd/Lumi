package cn.nukkit.settings;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class GeneralSettings extends OkaeriConfig {

    private String motd = "An Lumi server";

    @CustomKey("sub-motd")
    private String subMotd = "Powered by Lumi";

    @CustomKey("server-port")
    private int serverPort = 19132;

    @CustomKey("server-ip")
    private String serverIp = "0.0.0.0";

    @CustomKey("max-players")
    private int maxPlayers = 50;

    private String language = "eng";

    @CustomKey("force-language")
    private boolean forceLanguage = false;

    @CustomKey("force-resources")
    private boolean forceResources = false;

    @CustomKey("force-resources-allow-client-packs")
    private boolean forceResourcesAllowClientPacks = false;

    @CustomKey("shutdown-message")
    private String shutdownMessage = "Server closed";

    @CustomKey("bstats-metrics")
    private boolean bstatsMetrics = true;

    @CustomKey("debug-level")
    private int debugLevel = 1;

    @CustomKey("deprecated-verbose")
    private boolean deprecatedVerbose = true;

    @CustomKey("enable-spark")
    private boolean enableSpark = false;

    @CustomKey("use-waterdog")
    private boolean useWaterdog = false;

    @CustomKey("server-authoritative-movement")
    private String serverAuthoritativeMovement = "server-auth";

    @CustomKey("server-authoritative-block-breaking")
    private boolean serverAuthoritativeBlockBreaking = true;

    @Setter(value = AccessLevel.NONE)
    private MultiversionSettings multiversion = new MultiversionSettings();

    @Getter
    @Setter
    public static class MultiversionSettings extends OkaeriConfig {

        @CustomKey("min-protocol")
        private int minProtocol = 0;

        @CustomKey("max-protocol")
        private int maxProtocol = -1;
    }
}
