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
public class PerformanceSettings extends OkaeriConfig {

    @CustomKey("async-workers")
    @Comment("Number of asynchronous workers recommended \"auto\"")
    private Object asyncWorkers = "auto";

    @CustomKey("auto-tick-rate")
    @Comment("Automatic tick rate and limit")
    private boolean autoTickRate = true;

    @CustomKey("auto-tick-rate-limit")
    private int autoTickRateLimit = 20;

    @CustomKey("base-tick-rate")
    private int baseTickRate = 1;

    @CustomKey("always-tick-players")
    private boolean alwaysTickPlayers = false;

    @CustomKey("thread-watchdog")
    @Comment("Enable watchdog")
    private boolean threadWatchdog = true;

    @CustomKey("thread-watchdog-tick")
    @Comment("Number of ticks to trigger watchdog")
    private int threadWatchdogTick = 60000;
}
