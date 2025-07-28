package cn.nukkit.plugin;

import cn.nukkit.block.Block;
import cn.nukkit.block.custom.CustomBlockDefinition;
import cn.nukkit.block.custom.container.CustomBlock;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InternalPlugin extends PluginBase {
    public static final InternalPlugin INSTANCE = new InternalPlugin();

    private static class TestBlock extends Block implements CustomBlock {
        @Override
        public String getName() {
            return "test";
        }

        @Override
        public int getId() {
            return 10000;
        }

        @Override
        public int getItemId() {
            return 255 - getId();
        }

        @Override
        public CustomBlockDefinition getDefinition() {
            return CustomBlockDefinition.builder(this, "stone").build();
        }

        @Override
        public String getIdentifier() {
            return "test:test";
        }
    }

    private static class TestBlock2 extends Block implements CustomBlock {
        @Override
        public String getName() {
            return "test2";
        }

        @Override
        public int getId() {
            return 10001;
        }

        @Override
        public int getItemId() {
            return 255 - getId();
        }

        @Override
        public CustomBlockDefinition getDefinition() {
            return CustomBlockDefinition.builder(this, "planks").build();
        }

        @Override
        public String getIdentifier() {
            return "test:goida";
        }
    }

    @Override
    public void onLoad() {
        Block.registerCustomBlock(List.of(TestBlock.class, TestBlock2.class));
    }

    @Override
    public void onDisable() {
        this.getLogger().warning("InternalPlugin is disabled.");
    }
}