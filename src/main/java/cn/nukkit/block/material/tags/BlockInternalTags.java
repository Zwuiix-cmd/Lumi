package cn.nukkit.block.material.tags;

import cn.nukkit.block.material.BlockType;
import cn.nukkit.block.material.BlockTypes;
import cn.nukkit.block.material.tags.impl.SimpleBlockTag;
import cn.nukkit.command.selector.args.impl.L;
import cn.nukkit.item.material.ItemTypes;
import cn.nukkit.item.material.tags.ItemTag;
import cn.nukkit.item.material.tags.ItemTags;
import cn.nukkit.item.material.tags.impl.SimpleItemTag;

public interface BlockInternalTags {
    BlockTag WOOL = BlockTags.register("lumi:wool", new SimpleBlockTag(
            BlockTypes.WHITE_WOOL,
            BlockTypes.BLACK_WOOL,
            BlockTypes.BLUE_WOOL,
            BlockTypes.BROWN_WOOL,
            BlockTypes.CYAN_WOOL,
            BlockTypes.GRAY_WOOL,
            BlockTypes.GREEN_WOOL,
            BlockTypes.LIGHT_BLUE_WOOL,
            BlockTypes.LIGHT_GRAY_WOOL,
            BlockTypes.LIME_WOOL,
            BlockTypes.MAGENTA_WOOL,
            BlockTypes.ORANGE_WOOL,
            BlockTypes.PINK_WOOL,
            BlockTypes.PURPLE_WOOL,
            BlockTypes.RED_WOOL,
            BlockTypes.YELLOW_WOOL
    ));

    BlockTag CARPET = BlockTags.register("lumi:carpet", new SimpleBlockTag(
            BlockTypes.CARPET,
            BlockTypes.WHITE_CARPET,
            BlockTypes.BLACK_CARPET,
            BlockTypes.BLUE_CARPET,
            BlockTypes.BROWN_CARPET,
            BlockTypes.CYAN_CARPET,
            BlockTypes.GRAY_CARPET,
            BlockTypes.GREEN_CARPET,
            BlockTypes.LIGHT_BLUE_CARPET,
            BlockTypes.LIGHT_GRAY_CARPET,
            BlockTypes.LIME_CARPET,
            BlockTypes.MAGENTA_CARPET,
            BlockTypes.ORANGE_CARPET,
            BlockTypes.PINK_CARPET,
            BlockTypes.PURPLE_CARPET,
            BlockTypes.RED_CARPET,
            BlockTypes.YELLOW_CARPET
    ));

    BlockTag VIBRATION_DAMPER = BlockTags.register("lumi:vibration_damper",
            WOOL.copyWith(CARPET.getBlockTypes().toArray(new BlockType[0]))
    );

    BlockTag JUNGLE = BlockTags.register("lumi:jungle", new SimpleBlockTag(
            BlockTypes.JUNGLE_WOOD,
            BlockTypes.JUNGLE_LOG,
            BlockTypes.STRIPPED_JUNGLE_WOOD,
            BlockTypes.STRIPPED_JUNGLE_LOG
    ));

    BlockTag POTTABLE = BlockTags.register("lumi:pottable", new SimpleBlockTag(
            BlockTypes.DANDELION,
            BlockTypes.POPPY,
            BlockTypes.BLUE_ORCHID,
            BlockTypes.ALLIUM,
            BlockTypes.AZURE_BLUET,
            BlockTypes.RED_TULIP,
            BlockTypes.ORANGE_TULIP,
            BlockTypes.WHITE_TULIP,
            BlockTypes.PINK_TULIP,
            BlockTypes.OXEYE_DAISY,
            BlockTypes.CORNFLOWER,
            BlockTypes.LILY_OF_THE_VALLEY,
            BlockTypes.WITHER_ROSE,
            BlockTypes.TORCHFLOWER,
            BlockTypes.OAK_SAPLING,
            BlockTypes.SPRUCE_SAPLING,
            BlockTypes.BIRCH_SAPLING,
            BlockTypes.JUNGLE_SAPLING,
            BlockTypes.ACACIA_SAPLING,
            BlockTypes.DARK_OAK_SAPLING,
            BlockTypes.CHERRY_SAPLING,
            BlockTypes.RED_MUSHROOM,
            BlockTypes.BROWN_MUSHROOM,
            BlockTypes.FERN,
            BlockTypes.DEADBUSH,
            BlockTypes.CACTUS,
            BlockTypes.BAMBOO,
            BlockTypes.AZALEA,
            BlockTypes.FLOWERING_AZALEA,
            BlockTypes.CRIMSON_FUNGUS,
            BlockTypes.WARPED_FUNGUS,
            BlockTypes.WARPED_ROOTS,
            BlockTypes.CRIMSON_ROOTS,
            BlockTypes.MANGROVE_PROPAGULE,
            BlockTypes.PALE_OAK_SAPLING,
            BlockTypes.OPEN_EYEBLOSSOM,
            BlockTypes.CLOSED_EYEBLOSSOM
    ));

    BlockTag DYED_SHULKER_BOX = BlockTags.register("lumi:dyed_shulker_box", new SimpleBlockTag(
            BlockTypes.WHITE_SHULKER_BOX,
            BlockTypes.LIGHT_GRAY_SHULKER_BOX,
            BlockTypes.GRAY_SHULKER_BOX,
            BlockTypes.BLACK_SHULKER_BOX,
            BlockTypes.BROWN_SHULKER_BOX,
            BlockTypes.RED_SHULKER_BOX,
            BlockTypes.ORANGE_SHULKER_BOX,
            BlockTypes.YELLOW_SHULKER_BOX,
            BlockTypes.LIME_SHULKER_BOX,
            BlockTypes.GREEN_SHULKER_BOX,
            BlockTypes.CYAN_SHULKER_BOX,
            BlockTypes.LIGHT_BLUE_SHULKER_BOX,
            BlockTypes.BLUE_SHULKER_BOX,
            BlockTypes.PURPLE_SHULKER_BOX,
            BlockTypes.MAGENTA_SHULKER_BOX,
            BlockTypes.PINK_SHULKER_BOX
    ));

    BlockTag SHULKER_BOX = BlockTags.register("lumi:shulker_box",
            DYED_SHULKER_BOX.copyWith(BlockTypes.UNDYED_SHULKER_BOX)
    );

    BlockTag WOODEN_DOOR = BlockTags.register("lumi:wooden_door", new SimpleBlockTag(
            BlockTypes.ACACIA_DOOR,
            BlockTypes.WOODEN_DOOR,
            BlockTypes.BIRCH_DOOR,
            BlockTypes.CRIMSON_DOOR,
            BlockTypes.DARK_OAK_DOOR,
            BlockTypes.JUNGLE_DOOR,
            BlockTypes.SPRUCE_DOOR,
            BlockTypes.WARPED_DOOR,
            BlockTypes.MANGROVE_DOOR,
            BlockTypes.CHERRY_DOOR,
            BlockTypes.PALE_OAK_DOOR
    ));

    BlockTag SAPLING = BlockTags.register("lumi:sapling", new SimpleBlockTag(
            BlockTypes.ACACIA_SAPLING,
            BlockTypes.OAK_SAPLING,
            BlockTypes.BIRCH_SAPLING,
            BlockTypes.DARK_OAK_SAPLING,
            BlockTypes.JUNGLE_SAPLING,
            BlockTypes.SPRUCE_SAPLING,
            BlockTypes.MANGROVE_PROPAGULE,
            BlockTypes.CHERRY_SAPLING,
            BlockTypes.PALE_OAK_SAPLING
    ));
}
