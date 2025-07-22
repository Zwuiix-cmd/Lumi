package cn.nukkit.settings.transformer;

import cn.nukkit.settings.PlayerSettings.SpaceNameMode;
import eu.okaeri.configs.schema.GenericsPair;
import eu.okaeri.configs.serdes.BidirectionalTransformer;
import eu.okaeri.configs.serdes.SerdesContext;
import org.jetbrains.annotations.NotNull;

public class SpaceNameModeTransformer extends BidirectionalTransformer<String, SpaceNameMode> {

    @Override
    public GenericsPair<String, SpaceNameMode> getPair() {
        return this.genericsPair(String.class, SpaceNameMode.class);
    }

    @Override
    public SpaceNameMode leftToRight(@NotNull String data, @NotNull SerdesContext serdesContext) {
        return SpaceNameMode.valueOf(data.toUpperCase());
    }

    @Override
    public String rightToLeft(@NotNull SpaceNameMode data, @NotNull SerdesContext serdesContext) {
        return data.name().toLowerCase();
    }
}
