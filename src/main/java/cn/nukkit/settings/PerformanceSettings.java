package cn.nukkit.settings;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerformanceSettings extends OkaeriConfig {

    @CustomKey("async-workers")
    private String asyncWorkers = "auto";

    @CustomKey("auto-tick-rate")
    private boolean autoTickRate = true;

    @CustomKey("auto-tick-rate-limit")
    private int autoTickRateLimit = 20;

    @CustomKey("base-tick-rate")
    private int baseTickRate = 1;

    @CustomKey("always-tick-players")
    private boolean alwaysTickPlayers = false;

    @CustomKey("thread-watchdog")
    private boolean threadWatchdog = true;

    @CustomKey("thread-watchdog-tick")
    private int threadWatchdogTick = 60000;
}

