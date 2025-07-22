package cn.nukkit.settings.initializer;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.OkaeriConfigInitializer;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import lombok.AllArgsConstructor;

import java.nio.file.Path;

@AllArgsConstructor
public class ServerSettingsConfigInitializer implements OkaeriConfigInitializer {

    private final Path path;

    @Override
    public void apply(OkaeriConfig config) throws Exception {
        config.withConfigurer(new YamlSnakeYamlConfigurer());
        config.withBindFile(path);
        config.withRemoveOrphans(true);
        config.saveDefaults();
        config.load(true);
    }
}
