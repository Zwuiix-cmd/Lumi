package cn.nukkit.plugin;

import cn.nukkit.block.custom.CustomBlockDefinition;
import cn.nukkit.block.custom.CustomBlockManager;
import cn.nukkit.block.custom.container.CustomBlock;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InternalPlugin extends PluginBase {
    public static final InternalPlugin INSTANCE = new InternalPlugin();

    @Override
    public void onLoad() {
        final CustomBlock block = new CustomBlock("swp:ruby_block", CustomBlockManager.LOWEST_CUSTOM_BLOCK_ID);
        CustomBlockManager.get().registerCustomBlock("swp:ruby_block", CustomBlockManager.LOWEST_CUSTOM_BLOCK_ID,
                CustomBlockDefinition.builder(block)
                        .name("Я ебал эту хуйню")
                        .breakTime(0.1)
                        .texture("stone")
                        .build(), () -> {
                    return block;
                });

        final CustomBlock block1 = new CustomBlock("swp:test", CustomBlockManager.LOWEST_CUSTOM_BLOCK_ID + 1);
        CustomBlockManager.get().registerCustomBlock("swp:test", CustomBlockManager.LOWEST_CUSTOM_BLOCK_ID + 1,
                CustomBlockDefinition.builder(block1)
                        .name("Я ебал эту хуйню 2 ")
                        .breakTime(0.1)
                        .texture("dirt")
                        .build(), () -> {
                    return block1;
                });
    }

    @Override
    public void onDisable() {
        this.getLogger().warning("InternalPlugin is disabled.");
    }
}
