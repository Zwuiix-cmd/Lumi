package cn.nukkit.settings.initializer;

import cn.nukkit.settings.transformer.DifficultyTransformer;
import cn.nukkit.settings.transformer.ServerAuthoritativeMovementTransformer;
import cn.nukkit.settings.transformer.SpaceNameModeTransformer;
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
        config.withSerdesPack(registry -> {
            registry.register(new DifficultyTransformer());
            registry.register(new ServerAuthoritativeMovementTransformer());
            registry.register(new SpaceNameModeTransformer());
        });
        config.withRemoveOrphans(true);
        config.saveDefaults();
        config.load(true);
    }
}
