package cn.nukkit.settings;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @CustomKey("update-notifications")
    private boolean updateNotifications = false;

    @CustomKey("bstats-metrics")
    private boolean bstatsMetrics = true;

    @CustomKey("ansi-title")
    private boolean ansiTitle = false;

    @CustomKey("debug-level")
    private int debugLevel = 1;

    @CustomKey("deprecated-verbose")
    private boolean deprecatedVerbose = true;

    @CustomKey("enable-spark")
    private boolean enableSpark = false;

    @CustomKey("use-waterdog")
    private boolean useWaterdog = false;

    @CustomKey("enable-experiment-mode")
    private boolean enableExperimentMode = true;

    @CustomKey("server-authoritative-movement")
    private String serverAuthoritativeMovement = "server-auth";

    @CustomKey("server-authoritative-block-breaking")
    private boolean serverAuthoritativeBlockBreaking = true;

    @CustomKey("automatic-bug-report")
    private boolean automaticBugReport = true;

    @CustomKey("hastebin-token")
    private String hastebinToken = "";

    @CustomKey("call-data-pk-send-event")
    private boolean callDataPkSendEvent = true;

    @CustomKey("call-batch-pk-send-event")
    private boolean callBatchPkSendEvent = true;

    @CustomKey("call-entity-motion-event")
    private boolean callEntityMotionEvent = true;

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
