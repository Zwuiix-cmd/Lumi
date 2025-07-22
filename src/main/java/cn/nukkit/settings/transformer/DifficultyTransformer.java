package cn.nukkit.settings.transformer;

import cn.nukkit.Difficulty;
import eu.okaeri.configs.schema.GenericsPair;
import eu.okaeri.configs.serdes.BidirectionalTransformer;
import eu.okaeri.configs.serdes.SerdesContext;
import org.jetbrains.annotations.NotNull;

public class DifficultyTransformer extends BidirectionalTransformer<String, Difficulty> {

    @Override
    public GenericsPair<String, Difficulty> getPair() {
        return this.genericsPair(String.class, Difficulty.class);
    }

    @Override
    public Difficulty leftToRight(@NotNull String data, @NotNull SerdesContext serdesContext) {
        return Difficulty.byName(data);
    }

    @Override
    public String rightToLeft(@NotNull Difficulty data, @NotNull SerdesContext serdesContext) {
        return data.getLowerName();
    }
}

