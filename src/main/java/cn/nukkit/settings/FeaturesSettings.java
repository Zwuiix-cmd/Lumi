package cn.nukkit.settings;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class FeaturesSettings extends OkaeriConfig {

    @CustomKey("enable-experiment-mode")
    private boolean enableExperimentMode = true;

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
