package cn.nukkit.block.material;

import cn.nukkit.item.material.ItemTypes;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Data;

/**
 * This class is generated automatically, do not change it manually.
 */
public final class BlockTypes {
    private static final Int2ObjectMap<BlockType> LEGACY_TO_TYPE = new Int2ObjectOpenHashMap<>();

    private static final Object2ObjectMap<String, BlockType> ID_TO_TYPE = new Object2ObjectOpenHashMap<>();

    public static final BlockType ACACIA_BUTTON = register("minecraft:acacia_button", -140);

    public static final BlockType ACACIA_DOOR = register("minecraft:acacia_door", 430);

    public static final BlockType ACACIA_FENCE_GATE = register("minecraft:acacia_fence_gate", 187);

    public static final BlockType ACACIA_HANGING_SIGN = register("minecraft:acacia_hanging_sign", -504);

    public static final BlockType ACACIA_PRESSURE_PLATE = register("minecraft:acacia_pressure_plate", -150);

    public static final BlockType ACACIA_STAIRS = register("minecraft:acacia_stairs", 163);

    public static final BlockType ACACIA_STANDING_SIGN = register("minecraft:acacia_standing_sign", -190);

    public static final BlockType ACACIA_TRAPDOOR = register("minecraft:acacia_trapdoor", -145);

    public static final BlockType ACACIA_WALL_SIGN = register("minecraft:acacia_wall_sign", -191);

    public static final BlockType ACTIVATOR_RAIL = register("minecraft:activator_rail", 126);

    public static final BlockType AIR = register("minecraft:air", -158);

    public static final BlockType ALLOW = register("minecraft:allow", 210);

    public static final BlockType AMETHYST_BLOCK = register("minecraft:amethyst_block", -327);

    public static final BlockType AMETHYST_CLUSTER = register("minecraft:amethyst_cluster", -329);

    public static final BlockType ANCIENT_DEBRIS = register("minecraft:ancient_debris", -271);

    public static final BlockType ANDESITE_STAIRS = register("minecraft:andesite_stairs", -171);

    public static final BlockType ANDESITE_WALL = register("minecraft:andesite_wall", -974);

    public static final BlockType ANVIL = register("minecraft:anvil", 145);

    public static final BlockType AZALEA = register("minecraft:azalea", -337);

    public static final BlockType AZALEA_LEAVES = register("minecraft:azalea_leaves", -324);

    public static final BlockType AZALEA_LEAVES_FLOWERED = register("minecraft:azalea_leaves_flowered", -325);

    public static final BlockType BAMBOO = register("minecraft:bamboo", -163);

    public static final BlockType BAMBOO_BLOCK = register("minecraft:bamboo_block", -527);

    public static final BlockType BAMBOO_BUTTON = register("minecraft:bamboo_button", -511);

    public static final BlockType BAMBOO_DOUBLE_SLAB = register("minecraft:bamboo_double_slab", -521);

    public static final BlockType BAMBOO_FENCE = register("minecraft:bamboo_fence", -515);

    public static final BlockType BAMBOO_FENCE_GATE = register("minecraft:bamboo_fence_gate", -516);

    public static final BlockType BAMBOO_HANGING_SIGN = register("minecraft:bamboo_hanging_sign", -522);

    public static final BlockType BAMBOO_MOSAIC = register("minecraft:bamboo_mosaic", -509);

    public static final BlockType BAMBOO_MOSAIC_DOUBLE_SLAB = register("minecraft:bamboo_mosaic_double_slab", -525);

    public static final BlockType BAMBOO_MOSAIC_SLAB = register("minecraft:bamboo_mosaic_slab", -524);

    public static final BlockType BAMBOO_MOSAIC_STAIRS = register("minecraft:bamboo_mosaic_stairs", -523);

    public static final BlockType BAMBOO_PLANKS = register("minecraft:bamboo_planks", -510);

    public static final BlockType BAMBOO_PRESSURE_PLATE = register("minecraft:bamboo_pressure_plate", -514);

    public static final BlockType BAMBOO_SAPLING = register("minecraft:bamboo_sapling", -164);

    public static final BlockType BAMBOO_SLAB = register("minecraft:bamboo_slab", -513);

    public static final BlockType BAMBOO_STAIRS = register("minecraft:bamboo_stairs", -512);

    public static final BlockType BAMBOO_STANDING_SIGN = register("minecraft:bamboo_standing_sign", -518);

    public static final BlockType BAMBOO_TRAPDOOR = register("minecraft:bamboo_trapdoor", -520);

    public static final BlockType BAMBOO_WALL_SIGN = register("minecraft:bamboo_wall_sign", -519);

    public static final BlockType BARREL = register("minecraft:barrel", -203);

    public static final BlockType BARRIER = register("minecraft:barrier", -161);

    public static final BlockType BASALT = register("minecraft:basalt", -234);

    public static final BlockType BEACON = register("minecraft:beacon", 138);

    public static final BlockType BED = register("minecraft:bed", 355);

    public static final BlockType BEDROCK = register("minecraft:bedrock", 7);

    public static final BlockType BEE_NEST = register("minecraft:bee_nest", -218);

    public static final BlockType BEEHIVE = register("minecraft:beehive", -219);

    public static final BlockType BEETROOT = register("minecraft:beetroot", 457);

    public static final BlockType BELL = register("minecraft:bell", -206);

    public static final BlockType BIG_DRIPLEAF = register("minecraft:big_dripleaf", -323);

    public static final BlockType BIRCH_BUTTON = register("minecraft:birch_button", -141);

    public static final BlockType BIRCH_DOOR = register("minecraft:birch_door", 428);

    public static final BlockType BIRCH_FENCE_GATE = register("minecraft:birch_fence_gate", 184);

    public static final BlockType BIRCH_HANGING_SIGN = register("minecraft:birch_hanging_sign", -502);

    public static final BlockType BIRCH_PRESSURE_PLATE = register("minecraft:birch_pressure_plate", -151);

    public static final BlockType BIRCH_STAIRS = register("minecraft:birch_stairs", 135);

    public static final BlockType BIRCH_STANDING_SIGN = register("minecraft:birch_standing_sign", -186);

    public static final BlockType BIRCH_TRAPDOOR = register("minecraft:birch_trapdoor", -146);

    public static final BlockType BIRCH_WALL_SIGN = register("minecraft:birch_wall_sign", -187);

    public static final BlockType BLACK_CANDLE = register("minecraft:black_candle", -428);

    public static final BlockType BLACK_CANDLE_CAKE = register("minecraft:black_candle_cake", -445);

    public static final BlockType BLACK_GLAZED_TERRACOTTA = register("minecraft:black_glazed_terracotta", 235);

    public static final BlockType BLACKSTONE = register("minecraft:blackstone", -273);

    public static final BlockType BLACKSTONE_DOUBLE_SLAB = register("minecraft:blackstone_double_slab", -283);

    public static final BlockType BLACKSTONE_SLAB = register("minecraft:blackstone_slab", -282);

    public static final BlockType BLACKSTONE_STAIRS = register("minecraft:blackstone_stairs", -276);

    public static final BlockType BLACKSTONE_WALL = register("minecraft:blackstone_wall", -277);

    public static final BlockType BLAST_FURNACE = register("minecraft:blast_furnace", -196);

    public static final BlockType BLUE_CANDLE = register("minecraft:blue_candle", -424);

    public static final BlockType BLUE_CANDLE_CAKE = register("minecraft:blue_candle_cake", -441);

    public static final BlockType BLUE_GLAZED_TERRACOTTA = register("minecraft:blue_glazed_terracotta", 231);

    public static final BlockType BLUE_ICE = register("minecraft:blue_ice", -11);

    public static final BlockType BONE_BLOCK = register("minecraft:bone_block", 216);

    public static final BlockType BOOKSHELF = register("minecraft:bookshelf", 47);

    public static final BlockType BORDER_BLOCK = register("minecraft:border_block", 212);

    public static final BlockType BREWING_STAND = register("minecraft:brewing_stand", 379);

    public static final BlockType BRICK_BLOCK = register("minecraft:brick_block", 45);

    public static final BlockType BRICK_STAIRS = register("minecraft:brick_stairs", 108);

    public static final BlockType BRICK_WALL = register("minecraft:brick_wall", -976);

    public static final BlockType BROWN_CANDLE = register("minecraft:brown_candle", -425);

    public static final BlockType BROWN_CANDLE_CAKE = register("minecraft:brown_candle_cake", -442);

    public static final BlockType BROWN_GLAZED_TERRACOTTA = register("minecraft:brown_glazed_terracotta", 232);

    public static final BlockType BROWN_MUSHROOM = register("minecraft:brown_mushroom", 39);

    public static final BlockType BROWN_MUSHROOM_BLOCK = register("minecraft:brown_mushroom_block", 99);

    public static final BlockType BUBBLE_COLUMN = register("minecraft:bubble_column", -160);

    public static final BlockType BUDDING_AMETHYST = register("minecraft:budding_amethyst", -328);

    public static final BlockType CACTUS = register("minecraft:cactus", 81);

    public static final BlockType CAKE = register("minecraft:cake", 354);

    public static final BlockType CALCITE = register("minecraft:calcite", -326);

    public static final BlockType CALIBRATED_SCULK_SENSOR = register("minecraft:calibrated_sculk_sensor", -580);

    public static final BlockType CAMERA = register("minecraft:camera", 498);

    public static final BlockType CAMPFIRE = register("minecraft:campfire", 720);

    public static final BlockType CANDLE = register("minecraft:candle", -412);

    public static final BlockType CANDLE_CAKE = register("minecraft:candle_cake", -429);

    public static final BlockType CARROTS = register("minecraft:carrots", 141);

    public static final BlockType CARTOGRAPHY_TABLE = register("minecraft:cartography_table", -200);

    public static final BlockType CARVED_PUMPKIN = register("minecraft:carved_pumpkin", -155);

    public static final BlockType CAULDRON = register("minecraft:cauldron", 380);

    public static final BlockType CAVE_VINES = register("minecraft:cave_vines", -322);

    public static final BlockType CAVE_VINES_BODY_WITH_BERRIES = register("minecraft:cave_vines_body_with_berries", -375);

    public static final BlockType CAVE_VINES_HEAD_WITH_BERRIES = register("minecraft:cave_vines_head_with_berries", -376);

    public static final BlockType CHAIN = register("minecraft:chain", 758);

    public static final BlockType CHAIN_COMMAND_BLOCK = register("minecraft:chain_command_block", 189);

    public static final BlockType CHEMICAL_HEAT = register("minecraft:chemical_heat", 192);

    public static final BlockType CHERRY_BUTTON = register("minecraft:cherry_button", -530);

    public static final BlockType CHERRY_DOUBLE_SLAB = register("minecraft:cherry_double_slab", -540);

    public static final BlockType CHERRY_FENCE = register("minecraft:cherry_fence", -532);

    public static final BlockType CHERRY_FENCE_GATE = register("minecraft:cherry_fence_gate", -533);

    public static final BlockType CHERRY_HANGING_SIGN = register("minecraft:cherry_hanging_sign", -534);

    public static final BlockType CHERRY_LEAVES = register("minecraft:cherry_leaves", -548);

    public static final BlockType CHERRY_LOG = register("minecraft:cherry_log", -536);

    public static final BlockType CHERRY_PLANKS = register("minecraft:cherry_planks", -537);

    public static final BlockType CHERRY_PRESSURE_PLATE = register("minecraft:cherry_pressure_plate", -538);

    public static final BlockType CHERRY_SAPLING = register("minecraft:cherry_sapling", -547);

    public static final BlockType CHERRY_SLAB = register("minecraft:cherry_slab", -539);

    public static final BlockType CHERRY_STAIRS = register("minecraft:cherry_stairs", -541);

    public static final BlockType CHERRY_TRAPDOOR = register("minecraft:cherry_trapdoor", -543);

    public static final BlockType CHERRY_WOOD = register("minecraft:cherry_wood", -546);

    public static final BlockType CHEST = register("minecraft:chest", 54);

    public static final BlockType CHISELED_BOOKSHELF = register("minecraft:chiseled_bookshelf", -526);

    public static final BlockType CHISELED_COPPER = register("minecraft:chiseled_copper", -760);

    public static final BlockType CHISELED_DEEPSLATE = register("minecraft:chiseled_deepslate", -395);

    public static final BlockType CHISELED_NETHER_BRICKS = register("minecraft:chiseled_nether_bricks", -302);

    public static final BlockType CHISELED_POLISHED_BLACKSTONE = register("minecraft:chiseled_polished_blackstone", -279);

    public static final BlockType CHISELED_TUFF = register("minecraft:chiseled_tuff", -753);

    public static final BlockType CHISELED_TUFF_BRICKS = register("minecraft:chiseled_tuff_bricks", -759);

    public static final BlockType CHORUS_FLOWER = register("minecraft:chorus_flower", 200);

    public static final BlockType CHORUS_PLANT = register("minecraft:chorus_plant", 240);

    public static final BlockType CLAY = register("minecraft:clay", 82);

    public static final BlockType CLIENT_REQUEST_PLACEHOLDER_BLOCK = register("minecraft:client_request_placeholder_block", -465);

    public static final BlockType COAL_BLOCK = register("minecraft:coal_block", 173);

    public static final BlockType COAL_ORE = register("minecraft:coal_ore", 16);

    public static final BlockType COBBLED_DEEPSLATE = register("minecraft:cobbled_deepslate", -379);

    public static final BlockType COBBLED_DEEPSLATE_DOUBLE_SLAB = register("minecraft:cobbled_deepslate_double_slab", -396);

    public static final BlockType COBBLED_DEEPSLATE_SLAB = register("minecraft:cobbled_deepslate_slab", -380);

    public static final BlockType COBBLED_DEEPSLATE_STAIRS = register("minecraft:cobbled_deepslate_stairs", -381);

    public static final BlockType COBBLED_DEEPSLATE_WALL = register("minecraft:cobbled_deepslate_wall", -382);

    public static final BlockType COBBLESTONE = register("minecraft:cobblestone", 4);

    public static final BlockType COBBLESTONE_WALL = register("minecraft:cobblestone_wall", 139);

    public static final BlockType COCOA = register("minecraft:cocoa", 127);

    public static final BlockType COMMAND_BLOCK = register("minecraft:command_block", 137);

    public static final BlockType COMPOSTER = register("minecraft:composter", -213);

    public static final BlockType CONDUIT = register("minecraft:conduit", -157);

    public static final BlockType COPPER_BLOCK = register("minecraft:copper_block", -340);

    public static final BlockType COPPER_BULB = register("minecraft:copper_bulb", -776);

    public static final BlockType COPPER_DOOR = register("minecraft:copper_door", -784);

    public static final BlockType COPPER_GRATE = register("minecraft:copper_grate", -768);

    public static final BlockType COPPER_ORE = register("minecraft:copper_ore", -311);

    public static final BlockType COPPER_TRAPDOOR = register("minecraft:copper_trapdoor", -792);

    public static final BlockType CRACKED_DEEPSLATE_BRICKS = register("minecraft:cracked_deepslate_bricks", -410);

    public static final BlockType CRACKED_DEEPSLATE_TILES = register("minecraft:cracked_deepslate_tiles", -409);

    public static final BlockType CRACKED_NETHER_BRICKS = register("minecraft:cracked_nether_bricks", -303);

    public static final BlockType CRACKED_POLISHED_BLACKSTONE_BRICKS = register("minecraft:cracked_polished_blackstone_bricks", -280);

    public static final BlockType CRAFTING_TABLE = register("minecraft:crafting_table", 58);

    public static final BlockType CRIMSON_BUTTON = register("minecraft:crimson_button", -260);

    public static final BlockType CRIMSON_DOOR = register("minecraft:crimson_door", 755);

    public static final BlockType CRIMSON_DOUBLE_SLAB = register("minecraft:crimson_double_slab", -266);

    public static final BlockType CRIMSON_FENCE = register("minecraft:crimson_fence", -256);

    public static final BlockType CRIMSON_FENCE_GATE = register("minecraft:crimson_fence_gate", -258);

    public static final BlockType CRIMSON_FUNGUS = register("minecraft:crimson_fungus", -228);

    public static final BlockType CRIMSON_HANGING_SIGN = register("minecraft:crimson_hanging_sign", -506);

    public static final BlockType CRIMSON_HYPHAE = register("minecraft:crimson_hyphae", -299);

    public static final BlockType CRIMSON_NYLIUM = register("minecraft:crimson_nylium", -232);

    public static final BlockType CRIMSON_PLANKS = register("minecraft:crimson_planks", -242);

    public static final BlockType CRIMSON_PRESSURE_PLATE = register("minecraft:crimson_pressure_plate", -262);

    public static final BlockType CRIMSON_ROOTS = register("minecraft:crimson_roots", -223);

    public static final BlockType CRIMSON_SLAB = register("minecraft:crimson_slab", -264);

    public static final BlockType CRIMSON_STAIRS = register("minecraft:crimson_stairs", -254);

    public static final BlockType CRIMSON_STANDING_SIGN = register("minecraft:crimson_standing_sign", -250);

    public static final BlockType CRIMSON_STEM = register("minecraft:crimson_stem", -225);

    public static final BlockType CRIMSON_TRAPDOOR = register("minecraft:crimson_trapdoor", -246);

    public static final BlockType CRIMSON_WALL_SIGN = register("minecraft:crimson_wall_sign", -252);

    public static final BlockType CRYING_OBSIDIAN = register("minecraft:crying_obsidian", -289);

    public static final BlockType CUT_COPPER = register("minecraft:cut_copper", -347);

    public static final BlockType CUT_COPPER_SLAB = register("minecraft:cut_copper_slab", -361);

    public static final BlockType CUT_COPPER_STAIRS = register("minecraft:cut_copper_stairs", -354);

    public static final BlockType CYAN_CANDLE = register("minecraft:cyan_candle", -422);

    public static final BlockType CYAN_CANDLE_CAKE = register("minecraft:cyan_candle_cake", -439);

    public static final BlockType CYAN_GLAZED_TERRACOTTA = register("minecraft:cyan_glazed_terracotta", 229);

    public static final BlockType DARK_OAK_BUTTON = register("minecraft:dark_oak_button", -142);

    public static final BlockType DARK_OAK_DOOR = register("minecraft:dark_oak_door", 431);

    public static final BlockType DARK_OAK_FENCE_GATE = register("minecraft:dark_oak_fence_gate", 186);

    public static final BlockType DARK_OAK_HANGING_SIGN = register("minecraft:dark_oak_hanging_sign", -505);

    public static final BlockType DARK_OAK_PRESSURE_PLATE = register("minecraft:dark_oak_pressure_plate", -152);

    public static final BlockType DARK_OAK_STAIRS = register("minecraft:dark_oak_stairs", 164);

    public static final BlockType DARK_OAK_TRAPDOOR = register("minecraft:dark_oak_trapdoor", -147);

    public static final BlockType DARK_PRISMARINE_STAIRS = register("minecraft:dark_prismarine_stairs", -3);

    public static final BlockType DARKOAK_STANDING_SIGN = register("minecraft:darkoak_standing_sign", -192);

    public static final BlockType DARKOAK_WALL_SIGN = register("minecraft:darkoak_wall_sign", -193);

    public static final BlockType DAYLIGHT_DETECTOR = register("minecraft:daylight_detector", 151);

    public static final BlockType DAYLIGHT_DETECTOR_INVERTED = register("minecraft:daylight_detector_inverted", 178);

    public static final BlockType DEADBUSH = register("minecraft:deadbush", 32);

    public static final BlockType DECORATED_POT = register("minecraft:decorated_pot", -551);

    public static final BlockType DEEPSLATE = register("minecraft:deepslate", -378);

    public static final BlockType DEEPSLATE_BRICK_DOUBLE_SLAB = register("minecraft:deepslate_brick_double_slab", -399);

    public static final BlockType DEEPSLATE_BRICK_SLAB = register("minecraft:deepslate_brick_slab", -392);

    public static final BlockType DEEPSLATE_BRICK_STAIRS = register("minecraft:deepslate_brick_stairs", -393);

    public static final BlockType DEEPSLATE_BRICK_WALL = register("minecraft:deepslate_brick_wall", -394);

    public static final BlockType DEEPSLATE_BRICKS = register("minecraft:deepslate_bricks", -391);

    public static final BlockType DEEPSLATE_COAL_ORE = register("minecraft:deepslate_coal_ore", -406);

    public static final BlockType DEEPSLATE_COPPER_ORE = register("minecraft:deepslate_copper_ore", -408);

    public static final BlockType DEEPSLATE_DIAMOND_ORE = register("minecraft:deepslate_diamond_ore", -405);

    public static final BlockType DEEPSLATE_EMERALD_ORE = register("minecraft:deepslate_emerald_ore", -407);

    public static final BlockType DEEPSLATE_GOLD_ORE = register("minecraft:deepslate_gold_ore", -402);

    public static final BlockType DEEPSLATE_IRON_ORE = register("minecraft:deepslate_iron_ore", -401);

    public static final BlockType DEEPSLATE_LAPIS_ORE = register("minecraft:deepslate_lapis_ore", -400);

    public static final BlockType DEEPSLATE_REDSTONE_ORE = register("minecraft:deepslate_redstone_ore", -403);

    public static final BlockType DEEPSLATE_TILE_DOUBLE_SLAB = register("minecraft:deepslate_tile_double_slab", -398);

    public static final BlockType DEEPSLATE_TILE_SLAB = register("minecraft:deepslate_tile_slab", -388);

    public static final BlockType DEEPSLATE_TILE_STAIRS = register("minecraft:deepslate_tile_stairs", -389);

    public static final BlockType DEEPSLATE_TILE_WALL = register("minecraft:deepslate_tile_wall", -390);

    public static final BlockType DEEPSLATE_TILES = register("minecraft:deepslate_tiles", -387);

    public static final BlockType DENY = register("minecraft:deny", 211);

    public static final BlockType DETECTOR_RAIL = register("minecraft:detector_rail", 28);

    public static final BlockType DIAMOND_BLOCK = register("minecraft:diamond_block", 57);

    public static final BlockType DIAMOND_ORE = register("minecraft:diamond_ore", 56);

    public static final BlockType DIORITE_STAIRS = register("minecraft:diorite_stairs", -170);

    public static final BlockType DIORITE_WALL = register("minecraft:diorite_wall", -973);

    public static final BlockType DIRT = register("minecraft:dirt", 3);

    public static final BlockType DIRT_WITH_ROOTS = register("minecraft:dirt_with_roots", -318);

    public static final BlockType DISPENSER = register("minecraft:dispenser", 23);

    public static final BlockType DOUBLE_CUT_COPPER_SLAB = register("minecraft:double_cut_copper_slab", -368);

    public static final BlockType DRAGON_EGG = register("minecraft:dragon_egg", 122);

    public static final BlockType DRIED_KELP_BLOCK = register("minecraft:dried_kelp_block", -139);

    public static final BlockType DRIPSTONE_BLOCK = register("minecraft:dripstone_block", -317);

    public static final BlockType DROPPER = register("minecraft:dropper", 125);

    public static final BlockType ELEMENT_0 = register("minecraft:element_0", 36);

    public static final BlockType ELEMENT_1 = register("minecraft:element_1", -12);

    public static final BlockType ELEMENT_10 = register("minecraft:element_10", -21);

    public static final BlockType ELEMENT_100 = register("minecraft:element_100", -111);

    public static final BlockType ELEMENT_101 = register("minecraft:element_101", -112);

    public static final BlockType ELEMENT_102 = register("minecraft:element_102", -113);

    public static final BlockType ELEMENT_103 = register("minecraft:element_103", -114);

    public static final BlockType ELEMENT_104 = register("minecraft:element_104", -115);

    public static final BlockType ELEMENT_105 = register("minecraft:element_105", -116);

    public static final BlockType ELEMENT_106 = register("minecraft:element_106", -117);

    public static final BlockType ELEMENT_107 = register("minecraft:element_107", -118);

    public static final BlockType ELEMENT_108 = register("minecraft:element_108", -119);

    public static final BlockType ELEMENT_109 = register("minecraft:element_109", -120);

    public static final BlockType ELEMENT_11 = register("minecraft:element_11", -22);

    public static final BlockType ELEMENT_110 = register("minecraft:element_110", -121);

    public static final BlockType ELEMENT_111 = register("minecraft:element_111", -122);

    public static final BlockType ELEMENT_112 = register("minecraft:element_112", -123);

    public static final BlockType ELEMENT_113 = register("minecraft:element_113", -124);

    public static final BlockType ELEMENT_114 = register("minecraft:element_114", -125);

    public static final BlockType ELEMENT_115 = register("minecraft:element_115", -126);

    public static final BlockType ELEMENT_116 = register("minecraft:element_116", -127);

    public static final BlockType ELEMENT_117 = register("minecraft:element_117", -128);

    public static final BlockType ELEMENT_118 = register("minecraft:element_118", -129);

    public static final BlockType ELEMENT_12 = register("minecraft:element_12", -23);

    public static final BlockType ELEMENT_13 = register("minecraft:element_13", -24);

    public static final BlockType ELEMENT_14 = register("minecraft:element_14", -25);

    public static final BlockType ELEMENT_15 = register("minecraft:element_15", -26);

    public static final BlockType ELEMENT_16 = register("minecraft:element_16", -27);

    public static final BlockType ELEMENT_17 = register("minecraft:element_17", -28);

    public static final BlockType ELEMENT_18 = register("minecraft:element_18", -29);

    public static final BlockType ELEMENT_19 = register("minecraft:element_19", -30);

    public static final BlockType ELEMENT_2 = register("minecraft:element_2", -13);

    public static final BlockType ELEMENT_20 = register("minecraft:element_20", -31);

    public static final BlockType ELEMENT_21 = register("minecraft:element_21", -32);

    public static final BlockType ELEMENT_22 = register("minecraft:element_22", -33);

    public static final BlockType ELEMENT_23 = register("minecraft:element_23", -34);

    public static final BlockType ELEMENT_24 = register("minecraft:element_24", -35);

    public static final BlockType ELEMENT_25 = register("minecraft:element_25", -36);

    public static final BlockType ELEMENT_26 = register("minecraft:element_26", -37);

    public static final BlockType ELEMENT_27 = register("minecraft:element_27", -38);

    public static final BlockType ELEMENT_28 = register("minecraft:element_28", -39);

    public static final BlockType ELEMENT_29 = register("minecraft:element_29", -40);

    public static final BlockType ELEMENT_3 = register("minecraft:element_3", -14);

    public static final BlockType ELEMENT_30 = register("minecraft:element_30", -41);

    public static final BlockType ELEMENT_31 = register("minecraft:element_31", -42);

    public static final BlockType ELEMENT_32 = register("minecraft:element_32", -43);

    public static final BlockType ELEMENT_33 = register("minecraft:element_33", -44);

    public static final BlockType ELEMENT_34 = register("minecraft:element_34", -45);

    public static final BlockType ELEMENT_35 = register("minecraft:element_35", -46);

    public static final BlockType ELEMENT_36 = register("minecraft:element_36", -47);

    public static final BlockType ELEMENT_37 = register("minecraft:element_37", -48);

    public static final BlockType ELEMENT_38 = register("minecraft:element_38", -49);

    public static final BlockType ELEMENT_39 = register("minecraft:element_39", -50);

    public static final BlockType ELEMENT_4 = register("minecraft:element_4", -15);

    public static final BlockType ELEMENT_40 = register("minecraft:element_40", -51);

    public static final BlockType ELEMENT_41 = register("minecraft:element_41", -52);

    public static final BlockType ELEMENT_42 = register("minecraft:element_42", -53);

    public static final BlockType ELEMENT_43 = register("minecraft:element_43", -54);

    public static final BlockType ELEMENT_44 = register("minecraft:element_44", -55);

    public static final BlockType ELEMENT_45 = register("minecraft:element_45", -56);

    public static final BlockType ELEMENT_46 = register("minecraft:element_46", -57);

    public static final BlockType ELEMENT_47 = register("minecraft:element_47", -58);

    public static final BlockType ELEMENT_48 = register("minecraft:element_48", -59);

    public static final BlockType ELEMENT_49 = register("minecraft:element_49", -60);

    public static final BlockType ELEMENT_5 = register("minecraft:element_5", -16);

    public static final BlockType ELEMENT_50 = register("minecraft:element_50", -61);

    public static final BlockType ELEMENT_51 = register("minecraft:element_51", -62);

    public static final BlockType ELEMENT_52 = register("minecraft:element_52", -63);

    public static final BlockType ELEMENT_53 = register("minecraft:element_53", -64);

    public static final BlockType ELEMENT_54 = register("minecraft:element_54", -65);

    public static final BlockType ELEMENT_55 = register("minecraft:element_55", -66);

    public static final BlockType ELEMENT_56 = register("minecraft:element_56", -67);

    public static final BlockType ELEMENT_57 = register("minecraft:element_57", -68);

    public static final BlockType ELEMENT_58 = register("minecraft:element_58", -69);

    public static final BlockType ELEMENT_59 = register("minecraft:element_59", -70);

    public static final BlockType ELEMENT_6 = register("minecraft:element_6", -17);

    public static final BlockType ELEMENT_60 = register("minecraft:element_60", -71);

    public static final BlockType ELEMENT_61 = register("minecraft:element_61", -72);

    public static final BlockType ELEMENT_62 = register("minecraft:element_62", -73);

    public static final BlockType ELEMENT_63 = register("minecraft:element_63", -74);

    public static final BlockType ELEMENT_64 = register("minecraft:element_64", -75);

    public static final BlockType ELEMENT_65 = register("minecraft:element_65", -76);

    public static final BlockType ELEMENT_66 = register("minecraft:element_66", -77);

    public static final BlockType ELEMENT_67 = register("minecraft:element_67", -78);

    public static final BlockType ELEMENT_68 = register("minecraft:element_68", -79);

    public static final BlockType ELEMENT_69 = register("minecraft:element_69", -80);

    public static final BlockType ELEMENT_7 = register("minecraft:element_7", -18);

    public static final BlockType ELEMENT_70 = register("minecraft:element_70", -81);

    public static final BlockType ELEMENT_71 = register("minecraft:element_71", -82);

    public static final BlockType ELEMENT_72 = register("minecraft:element_72", -83);

    public static final BlockType ELEMENT_73 = register("minecraft:element_73", -84);

    public static final BlockType ELEMENT_74 = register("minecraft:element_74", -85);

    public static final BlockType ELEMENT_75 = register("minecraft:element_75", -86);

    public static final BlockType ELEMENT_76 = register("minecraft:element_76", -87);

    public static final BlockType ELEMENT_77 = register("minecraft:element_77", -88);

    public static final BlockType ELEMENT_78 = register("minecraft:element_78", -89);

    public static final BlockType ELEMENT_79 = register("minecraft:element_79", -90);

    public static final BlockType ELEMENT_8 = register("minecraft:element_8", -19);

    public static final BlockType ELEMENT_80 = register("minecraft:element_80", -91);

    public static final BlockType ELEMENT_81 = register("minecraft:element_81", -92);

    public static final BlockType ELEMENT_82 = register("minecraft:element_82", -93);

    public static final BlockType ELEMENT_83 = register("minecraft:element_83", -94);

    public static final BlockType ELEMENT_84 = register("minecraft:element_84", -95);

    public static final BlockType ELEMENT_85 = register("minecraft:element_85", -96);

    public static final BlockType ELEMENT_86 = register("minecraft:element_86", -97);

    public static final BlockType ELEMENT_87 = register("minecraft:element_87", -98);

    public static final BlockType ELEMENT_88 = register("minecraft:element_88", -99);

    public static final BlockType ELEMENT_89 = register("minecraft:element_89", -100);

    public static final BlockType ELEMENT_9 = register("minecraft:element_9", -20);

    public static final BlockType ELEMENT_90 = register("minecraft:element_90", -101);

    public static final BlockType ELEMENT_91 = register("minecraft:element_91", -102);

    public static final BlockType ELEMENT_92 = register("minecraft:element_92", -103);

    public static final BlockType ELEMENT_93 = register("minecraft:element_93", -104);

    public static final BlockType ELEMENT_94 = register("minecraft:element_94", -105);

    public static final BlockType ELEMENT_95 = register("minecraft:element_95", -106);

    public static final BlockType ELEMENT_96 = register("minecraft:element_96", -107);

    public static final BlockType ELEMENT_97 = register("minecraft:element_97", -108);

    public static final BlockType ELEMENT_98 = register("minecraft:element_98", -109);

    public static final BlockType ELEMENT_99 = register("minecraft:element_99", -110);

    public static final BlockType EMERALD_BLOCK = register("minecraft:emerald_block", 133);

    public static final BlockType EMERALD_ORE = register("minecraft:emerald_ore", 129);

    public static final BlockType ENCHANTING_TABLE = register("minecraft:enchanting_table", 116);

    public static final BlockType END_BRICK_STAIRS = register("minecraft:end_brick_stairs", -178);

    public static final BlockType END_BRICKS = register("minecraft:end_bricks", 206);

    public static final BlockType END_GATEWAY = register("minecraft:end_gateway", 209);

    public static final BlockType END_PORTAL = register("minecraft:end_portal", 119);

    public static final BlockType END_PORTAL_FRAME = register("minecraft:end_portal_frame", 120);

    public static final BlockType END_ROD = register("minecraft:end_rod", 208);

    public static final BlockType END_STONE = register("minecraft:end_stone", 121);

    public static final BlockType END_STONE_BRICK_WALL = register("minecraft:end_stone_brick_wall", -980);

    public static final BlockType ENDER_CHEST = register("minecraft:ender_chest", 130);

    public static final BlockType EXPOSED_CHISELED_COPPER = register("minecraft:exposed_chiseled_copper", -761);

    public static final BlockType EXPOSED_COPPER = register("minecraft:exposed_copper", -341);

    public static final BlockType EXPOSED_COPPER_BULB = register("minecraft:exposed_copper_bulb", -777);

    public static final BlockType EXPOSED_COPPER_DOOR = register("minecraft:exposed_copper_door", -785);

    public static final BlockType EXPOSED_COPPER_GRATE = register("minecraft:exposed_copper_grate", -769);

    public static final BlockType EXPOSED_COPPER_TRAPDOOR = register("minecraft:exposed_copper_trapdoor", -793);

    public static final BlockType EXPOSED_CUT_COPPER = register("minecraft:exposed_cut_copper", -348);

    public static final BlockType EXPOSED_CUT_COPPER_SLAB = register("minecraft:exposed_cut_copper_slab", -362);

    public static final BlockType EXPOSED_CUT_COPPER_STAIRS = register("minecraft:exposed_cut_copper_stairs", -355);

    public static final BlockType EXPOSED_DOUBLE_CUT_COPPER_SLAB = register("minecraft:exposed_double_cut_copper_slab", -369);

    public static final BlockType FARMLAND = register("minecraft:farmland", 60);

    public static final BlockType FENCE_GATE = register("minecraft:fence_gate", 107);

    public static final BlockType FIRE = register("minecraft:fire", 51);

    public static final BlockType FLETCHING_TABLE = register("minecraft:fletching_table", -201);

    public static final BlockType FLOWER_POT = register("minecraft:flower_pot", 390);

    public static final BlockType FLOWERING_AZALEA = register("minecraft:flowering_azalea", -338);

    public static final BlockType FLOWING_LAVA = register("minecraft:flowing_lava", 10);

    public static final BlockType FLOWING_WATER = register("minecraft:flowing_water", 8);

    public static final BlockType FRAME = register("minecraft:frame", 389);

    public static final BlockType FROG_SPAWN = register("minecraft:frog_spawn", -468);

    public static final BlockType FROSTED_ICE = register("minecraft:frosted_ice", 207);

    public static final BlockType FURNACE = register("minecraft:furnace", 61);

    public static final BlockType GILDED_BLACKSTONE = register("minecraft:gilded_blackstone", -281);

    public static final BlockType GLASS = register("minecraft:glass", 20);

    public static final BlockType GLASS_PANE = register("minecraft:glass_pane", 102);

    public static final BlockType GLOW_FRAME = register("minecraft:glow_frame", 850);

    public static final BlockType GLOW_LICHEN = register("minecraft:glow_lichen", -411);

    public static final BlockType GLOWINGOBSIDIAN = register("minecraft:glowingobsidian", 246);

    public static final BlockType GLOWSTONE = register("minecraft:glowstone", 89);

    public static final BlockType GOLD_BLOCK = register("minecraft:gold_block", 41);

    public static final BlockType GOLD_ORE = register("minecraft:gold_ore", 14);

    public static final BlockType GOLDEN_RAIL = register("minecraft:golden_rail", 27);

    public static final BlockType GRANITE_STAIRS = register("minecraft:granite_stairs", -169);

    public static final BlockType GRANITE_WALL = register("minecraft:granite_wall", -972);

    public static final BlockType GRASS_PATH = register("minecraft:grass_path", 198);

    public static final BlockType GRAVEL = register("minecraft:gravel", 13);

    public static final BlockType GRAY_CANDLE = register("minecraft:gray_candle", -420);

    public static final BlockType GRAY_CANDLE_CAKE = register("minecraft:gray_candle_cake", -437);

    public static final BlockType GRAY_GLAZED_TERRACOTTA = register("minecraft:gray_glazed_terracotta", 227);

    public static final BlockType GREEN_CANDLE = register("minecraft:green_candle", -426);

    public static final BlockType GREEN_CANDLE_CAKE = register("minecraft:green_candle_cake", -443);

    public static final BlockType GREEN_GLAZED_TERRACOTTA = register("minecraft:green_glazed_terracotta", 233);

    public static final BlockType GRINDSTONE = register("minecraft:grindstone", -195);

    public static final BlockType HANGING_ROOTS = register("minecraft:hanging_roots", -319);

    public static final BlockType HARD_GLASS = register("minecraft:hard_glass", 253);

    public static final BlockType HARD_GLASS_PANE = register("minecraft:hard_glass_pane", 190);

    public static final BlockType HARDENED_CLAY = register("minecraft:hardened_clay", 172);

    public static final BlockType HAY_BLOCK = register("minecraft:hay_block", 170);

    public static final BlockType HEAVY_CORE = register("minecraft:heavy_core", -316);

    public static final BlockType HEAVY_WEIGHTED_PRESSURE_PLATE = register("minecraft:heavy_weighted_pressure_plate", 148);

    public static final BlockType HONEY_BLOCK = register("minecraft:honey_block", -220);

    public static final BlockType HONEYCOMB_BLOCK = register("minecraft:honeycomb_block", -221);

    public static final BlockType HOPPER = register("minecraft:hopper", 410);

    public static final BlockType ICE = register("minecraft:ice", 79);

    public static final BlockType INFESTED_DEEPSLATE = register("minecraft:infested_deepslate", -454);

    public static final BlockType INFO_UPDATE = register("minecraft:info_update", 248);

    public static final BlockType INFO_UPDATE2 = register("minecraft:info_update2", 249);

    public static final BlockType INVISIBLE_BEDROCK = register("minecraft:invisible_bedrock", 95);

    public static final BlockType IRON_BARS = register("minecraft:iron_bars", 101);

    public static final BlockType IRON_BLOCK = register("minecraft:iron_block", 42);

    public static final BlockType IRON_DOOR = register("minecraft:iron_door", 330);

    public static final BlockType IRON_ORE = register("minecraft:iron_ore", 15);

    public static final BlockType IRON_TRAPDOOR = register("minecraft:iron_trapdoor", 167);

    public static final BlockType JIGSAW = register("minecraft:jigsaw", -211);

    public static final BlockType JUKEBOX = register("minecraft:jukebox", 84);

    public static final BlockType JUNGLE_BUTTON = register("minecraft:jungle_button", -143);

    public static final BlockType JUNGLE_DOOR = register("minecraft:jungle_door", 429);

    public static final BlockType JUNGLE_FENCE_GATE = register("minecraft:jungle_fence_gate", 185);

    public static final BlockType JUNGLE_HANGING_SIGN = register("minecraft:jungle_hanging_sign", -503);

    public static final BlockType JUNGLE_PRESSURE_PLATE = register("minecraft:jungle_pressure_plate", -153);

    public static final BlockType JUNGLE_STAIRS = register("minecraft:jungle_stairs", 136);

    public static final BlockType JUNGLE_STANDING_SIGN = register("minecraft:jungle_standing_sign", -188);

    public static final BlockType JUNGLE_TRAPDOOR = register("minecraft:jungle_trapdoor", -148);

    public static final BlockType JUNGLE_WALL_SIGN = register("minecraft:jungle_wall_sign", -189);

    public static final BlockType KELP = register("minecraft:kelp", 335);

    public static final BlockType LADDER = register("minecraft:ladder", 65);

    public static final BlockType LANTERN = register("minecraft:lantern", -208);

    public static final BlockType LAPIS_BLOCK = register("minecraft:lapis_block", 22);

    public static final BlockType LAPIS_ORE = register("minecraft:lapis_ore", 21);

    public static final BlockType LARGE_AMETHYST_BUD = register("minecraft:large_amethyst_bud", -330);

    public static final BlockType LAVA = register("minecraft:lava", 11);

    public static final BlockType LECTERN = register("minecraft:lectern", -194);

    public static final BlockType LEVER = register("minecraft:lever", 69);

    public static final BlockType LIGHT_BLUE_CANDLE = register("minecraft:light_blue_candle", -416);

    public static final BlockType LIGHT_BLUE_CANDLE_CAKE = register("minecraft:light_blue_candle_cake", -433);

    public static final BlockType LIGHT_BLUE_GLAZED_TERRACOTTA = register("minecraft:light_blue_glazed_terracotta", 223);

    public static final BlockType LIGHT_GRAY_CANDLE = register("minecraft:light_gray_candle", -421);

    public static final BlockType LIGHT_GRAY_CANDLE_CAKE = register("minecraft:light_gray_candle_cake", -438);

    public static final BlockType LIGHT_WEIGHTED_PRESSURE_PLATE = register("minecraft:light_weighted_pressure_plate", 147);

    public static final BlockType LIGHTNING_ROD = register("minecraft:lightning_rod", -312);

    public static final BlockType LIME_CANDLE = register("minecraft:lime_candle", -418);

    public static final BlockType LIME_CANDLE_CAKE = register("minecraft:lime_candle_cake", -435);

    public static final BlockType LIME_GLAZED_TERRACOTTA = register("minecraft:lime_glazed_terracotta", 225);

    public static final BlockType LIT_BLAST_FURNACE = register("minecraft:lit_blast_furnace", -214);

    public static final BlockType LIT_DEEPSLATE_REDSTONE_ORE = register("minecraft:lit_deepslate_redstone_ore", -404);

    public static final BlockType LIT_FURNACE = register("minecraft:lit_furnace", 62);

    public static final BlockType LIT_PUMPKIN = register("minecraft:lit_pumpkin", 91);

    public static final BlockType LIT_REDSTONE_LAMP = register("minecraft:lit_redstone_lamp", 124);

    public static final BlockType LIT_REDSTONE_ORE = register("minecraft:lit_redstone_ore", 74);

    public static final BlockType LIT_SMOKER = register("minecraft:lit_smoker", -199);

    public static final BlockType LODESTONE = register("minecraft:lodestone", -222);

    public static final BlockType LOOM = register("minecraft:loom", -204);

    public static final BlockType MAGENTA_CANDLE = register("minecraft:magenta_candle", -415);

    public static final BlockType MAGENTA_CANDLE_CAKE = register("minecraft:magenta_candle_cake", -432);

    public static final BlockType MAGENTA_GLAZED_TERRACOTTA = register("minecraft:magenta_glazed_terracotta", 222);

    public static final BlockType MAGMA = register("minecraft:magma", 213);

    public static final BlockType MANGROVE_BUTTON = register("minecraft:mangrove_button", -487);

    public static final BlockType MANGROVE_DOOR = register("minecraft:mangrove_door", 1004);

    public static final BlockType MANGROVE_DOUBLE_SLAB = register("minecraft:mangrove_double_slab", -499);

    public static final BlockType MANGROVE_FENCE = register("minecraft:mangrove_fence", -491);

    public static final BlockType MANGROVE_FENCE_GATE = register("minecraft:mangrove_fence_gate", -492);

    public static final BlockType MANGROVE_HANGING_SIGN = register("minecraft:mangrove_hanging_sign", -508);

    public static final BlockType MANGROVE_LEAVES = register("minecraft:mangrove_leaves", -472);

    public static final BlockType MANGROVE_LOG = register("minecraft:mangrove_log", -484);

    public static final BlockType MANGROVE_PLANKS = register("minecraft:mangrove_planks", -486);

    public static final BlockType MANGROVE_PRESSURE_PLATE = register("minecraft:mangrove_pressure_plate", -490);

    public static final BlockType MANGROVE_PROPAGULE = register("minecraft:mangrove_propagule", -474);

    public static final BlockType MANGROVE_ROOTS = register("minecraft:mangrove_roots", -482);

    public static final BlockType MANGROVE_SLAB = register("minecraft:mangrove_slab", -489);

    public static final BlockType MANGROVE_STAIRS = register("minecraft:mangrove_stairs", -488);

    public static final BlockType MANGROVE_STANDING_SIGN = register("minecraft:mangrove_standing_sign", -494);

    public static final BlockType MANGROVE_TRAPDOOR = register("minecraft:mangrove_trapdoor", -496);

    public static final BlockType MANGROVE_WALL_SIGN = register("minecraft:mangrove_wall_sign", -495);

    public static final BlockType MANGROVE_WOOD = register("minecraft:mangrove_wood", -497);

    public static final BlockType MEDIUM_AMETHYST_BUD = register("minecraft:medium_amethyst_bud", -331);

    public static final BlockType MELON_BLOCK = register("minecraft:melon_block", 103);

    public static final BlockType MELON_STEM = register("minecraft:melon_stem", 105);

    public static final BlockType MOB_SPAWNER = register("minecraft:mob_spawner", 52);

    public static final BlockType MOSS_BLOCK = register("minecraft:moss_block", -320);

    public static final BlockType MOSS_CARPET = register("minecraft:moss_carpet", -335);

    public static final BlockType MOSSY_COBBLESTONE = register("minecraft:mossy_cobblestone", 48);

    public static final BlockType MOSSY_COBBLESTONE_STAIRS = register("minecraft:mossy_cobblestone_stairs", -179);

    public static final BlockType MOSSY_COBBLESTONE_WALL = register("minecraft:mossy_cobblestone_wall", -971);

    public static final BlockType MOSSY_STONE_BRICK_STAIRS = register("minecraft:mossy_stone_brick_stairs", -175);

    public static final BlockType MOSSY_STONE_BRICK_WALL = register("minecraft:mossy_stone_brick_wall", -978);

    public static final BlockType MOVING_BLOCK = register("minecraft:moving_block", 250);

    public static final BlockType MUD = register("minecraft:mud", -473);

    public static final BlockType MUD_BRICK_DOUBLE_SLAB = register("minecraft:mud_brick_double_slab", -479);

    public static final BlockType MUD_BRICK_SLAB = register("minecraft:mud_brick_slab", -478);

    public static final BlockType MUD_BRICK_STAIRS = register("minecraft:mud_brick_stairs", -480);

    public static final BlockType MUD_BRICK_WALL = register("minecraft:mud_brick_wall", -481);

    public static final BlockType MUD_BRICKS = register("minecraft:mud_bricks", -475);

    public static final BlockType MUDDY_MANGROVE_ROOTS = register("minecraft:muddy_mangrove_roots", -483);

    public static final BlockType MYCELIUM = register("minecraft:mycelium", 110);

    public static final BlockType NETHER_BRICK = register("minecraft:nether_brick", 112);

    public static final BlockType NETHER_BRICK_FENCE = register("minecraft:nether_brick_fence", 113);

    public static final BlockType NETHER_BRICK_STAIRS = register("minecraft:nether_brick_stairs", 114);

    public static final BlockType NETHER_BRICK_WALL = register("minecraft:nether_brick_wall", -979);

    public static final BlockType NETHER_GOLD_ORE = register("minecraft:nether_gold_ore", -288);

    public static final BlockType NETHER_SPROUTS = register("minecraft:nether_sprouts", 760);

    public static final BlockType NETHER_WART = register("minecraft:nether_wart", 372);

    public static final BlockType NETHER_WART_BLOCK = register("minecraft:nether_wart_block", 214);

    public static final BlockType NETHERITE_BLOCK = register("minecraft:netherite_block", -270);

    public static final BlockType NETHERRACK = register("minecraft:netherrack", 87);

    public static final BlockType NETHERREACTOR = register("minecraft:netherreactor", 247);

    public static final BlockType NORMAL_STONE_STAIRS = register("minecraft:normal_stone_stairs", -180);

    public static final BlockType NOTEBLOCK = register("minecraft:noteblock", 25);

    public static final BlockType OAK_HANGING_SIGN = register("minecraft:oak_hanging_sign", -500);

    public static final BlockType OAK_STAIRS = register("minecraft:oak_stairs", 53);

    public static final BlockType OBSERVER = register("minecraft:observer", 251);

    public static final BlockType OBSIDIAN = register("minecraft:obsidian", 49);

    public static final BlockType OCHRE_FROGLIGHT = register("minecraft:ochre_froglight", -471);

    public static final BlockType ORANGE_CANDLE = register("minecraft:orange_candle", -414);

    public static final BlockType ORANGE_CANDLE_CAKE = register("minecraft:orange_candle_cake", -431);

    public static final BlockType ORANGE_GLAZED_TERRACOTTA = register("minecraft:orange_glazed_terracotta", 221);

    public static final BlockType OXIDIZED_CHISELED_COPPER = register("minecraft:oxidized_chiseled_copper", -763);

    public static final BlockType OXIDIZED_COPPER = register("minecraft:oxidized_copper", -343);

    public static final BlockType OXIDIZED_COPPER_BULB = register("minecraft:oxidized_copper_bulb", -779);

    public static final BlockType OXIDIZED_COPPER_DOOR = register("minecraft:oxidized_copper_door", -787);

    public static final BlockType OXIDIZED_COPPER_GRATE = register("minecraft:oxidized_copper_grate", -771);

    public static final BlockType OXIDIZED_COPPER_TRAPDOOR = register("minecraft:oxidized_copper_trapdoor", -795);

    public static final BlockType OXIDIZED_CUT_COPPER = register("minecraft:oxidized_cut_copper", -350);

    public static final BlockType OXIDIZED_CUT_COPPER_SLAB = register("minecraft:oxidized_cut_copper_slab", -364);

    public static final BlockType OXIDIZED_CUT_COPPER_STAIRS = register("minecraft:oxidized_cut_copper_stairs", -357);

    public static final BlockType OXIDIZED_DOUBLE_CUT_COPPER_SLAB = register("minecraft:oxidized_double_cut_copper_slab", -371);

    public static final BlockType PACKED_ICE = register("minecraft:packed_ice", 174);

    public static final BlockType PACKED_MUD = register("minecraft:packed_mud", -477);

    public static final BlockType PEARLESCENT_FROGLIGHT = register("minecraft:pearlescent_froglight", -469);

    public static final BlockType PINK_CANDLE = register("minecraft:pink_candle", -419);

    public static final BlockType PINK_CANDLE_CAKE = register("minecraft:pink_candle_cake", -436);

    public static final BlockType PINK_GLAZED_TERRACOTTA = register("minecraft:pink_glazed_terracotta", 226);

    public static final BlockType PINK_PETALS = register("minecraft:pink_petals", -549);

    public static final BlockType PISTON = register("minecraft:piston", 33);

    public static final BlockType PISTON_ARM_COLLISION = register("minecraft:piston_arm_collision", 34);

    public static final BlockType PITCHER_CROP = register("minecraft:pitcher_crop", -574);

    public static final BlockType PITCHER_PLANT = register("minecraft:pitcher_plant", -612);

    public static final BlockType PODZOL = register("minecraft:podzol", 243);

    public static final BlockType POINTED_DRIPSTONE = register("minecraft:pointed_dripstone", -308);

    public static final BlockType POLISHED_ANDESITE_STAIRS = register("minecraft:polished_andesite_stairs", -174);

    public static final BlockType POLISHED_BASALT = register("minecraft:polished_basalt", -235);

    public static final BlockType POLISHED_BLACKSTONE = register("minecraft:polished_blackstone", -291);

    public static final BlockType POLISHED_BLACKSTONE_BRICK_DOUBLE_SLAB = register("minecraft:polished_blackstone_brick_double_slab", -285);

    public static final BlockType POLISHED_BLACKSTONE_BRICK_SLAB = register("minecraft:polished_blackstone_brick_slab", -284);

    public static final BlockType POLISHED_BLACKSTONE_BRICK_STAIRS = register("minecraft:polished_blackstone_brick_stairs", -275);

    public static final BlockType POLISHED_BLACKSTONE_BRICK_WALL = register("minecraft:polished_blackstone_brick_wall", -278);

    public static final BlockType POLISHED_BLACKSTONE_BRICKS = register("minecraft:polished_blackstone_bricks", -274);

    public static final BlockType POLISHED_BLACKSTONE_BUTTON = register("minecraft:polished_blackstone_button", -296);

    public static final BlockType POLISHED_BLACKSTONE_DOUBLE_SLAB = register("minecraft:polished_blackstone_double_slab", -294);

    public static final BlockType POLISHED_BLACKSTONE_PRESSURE_PLATE = register("minecraft:polished_blackstone_pressure_plate", -295);

    public static final BlockType POLISHED_BLACKSTONE_SLAB = register("minecraft:polished_blackstone_slab", -293);

    public static final BlockType POLISHED_BLACKSTONE_STAIRS = register("minecraft:polished_blackstone_stairs", -292);

    public static final BlockType POLISHED_BLACKSTONE_WALL = register("minecraft:polished_blackstone_wall", -297);

    public static final BlockType POLISHED_DEEPSLATE = register("minecraft:polished_deepslate", -383);

    public static final BlockType POLISHED_DEEPSLATE_DOUBLE_SLAB = register("minecraft:polished_deepslate_double_slab", -397);

    public static final BlockType POLISHED_DEEPSLATE_SLAB = register("minecraft:polished_deepslate_slab", -384);

    public static final BlockType POLISHED_DEEPSLATE_STAIRS = register("minecraft:polished_deepslate_stairs", -385);

    public static final BlockType POLISHED_DEEPSLATE_WALL = register("minecraft:polished_deepslate_wall", -386);

    public static final BlockType POLISHED_DIORITE_STAIRS = register("minecraft:polished_diorite_stairs", -173);

    public static final BlockType POLISHED_GRANITE_STAIRS = register("minecraft:polished_granite_stairs", -172);

    public static final BlockType POLISHED_TUFF = register("minecraft:polished_tuff", -748);

    public static final BlockType POLISHED_TUFF_SLAB = register("minecraft:polished_tuff_slab", -749);

    public static final BlockType POLISHED_TUFF_STAIRS = register("minecraft:polished_tuff_stairs", -751);

    public static final BlockType POLISHED_TUFF_WALL = register("minecraft:polished_tuff_wall", -752);

    public static final BlockType PORTAL = register("minecraft:portal", 90);

    public static final BlockType POTATOES = register("minecraft:potatoes", 142);

    public static final BlockType POWDER_SNOW = register("minecraft:powder_snow", -306);

    public static final BlockType POWERED_COMPARATOR = register("minecraft:powered_comparator", 150);

    public static final BlockType POWERED_REPEATER = register("minecraft:powered_repeater", 94);

    public static final BlockType PRISMARINE = register("minecraft:prismarine", 168);

    public static final BlockType PRISMARINE_BRICKS_STAIRS = register("minecraft:prismarine_bricks_stairs", -4);

    public static final BlockType PRISMARINE_STAIRS = register("minecraft:prismarine_stairs", -2);

    public static final BlockType PRISMARINE_WALL = register("minecraft:prismarine_wall", -981);

    public static final BlockType PUMPKIN = register("minecraft:pumpkin", 86);

    public static final BlockType PUMPKIN_STEM = register("minecraft:pumpkin_stem", 104);

    public static final BlockType PURPLE_CANDLE = register("minecraft:purple_candle", -423);

    public static final BlockType PURPLE_CANDLE_CAKE = register("minecraft:purple_candle_cake", -440);

    public static final BlockType PURPLE_GLAZED_TERRACOTTA = register("minecraft:purple_glazed_terracotta", 219);

    public static final BlockType PURPUR_BLOCK = register("minecraft:purpur_block", 201);

    public static final BlockType PURPUR_STAIRS = register("minecraft:purpur_stairs", 203);

    public static final BlockType QUARTZ_BLOCK = register("minecraft:quartz_block", 155);

    public static final BlockType QUARTZ_BRICKS = register("minecraft:quartz_bricks", -304);

    public static final BlockType QUARTZ_ORE = register("minecraft:quartz_ore", 153);

    public static final BlockType QUARTZ_STAIRS = register("minecraft:quartz_stairs", 156);

    public static final BlockType RAIL = register("minecraft:rail", 66);

    public static final BlockType RAW_COPPER_BLOCK = register("minecraft:raw_copper_block", -452);

    public static final BlockType RAW_GOLD_BLOCK = register("minecraft:raw_gold_block", -453);

    public static final BlockType RAW_IRON_BLOCK = register("minecraft:raw_iron_block", -451);

    public static final BlockType RED_CANDLE = register("minecraft:red_candle", -427);

    public static final BlockType RED_CANDLE_CAKE = register("minecraft:red_candle_cake", -444);

    public static final BlockType RED_GLAZED_TERRACOTTA = register("minecraft:red_glazed_terracotta", 234);

    public static final BlockType RED_MUSHROOM = register("minecraft:red_mushroom", 40);

    public static final BlockType RED_MUSHROOM_BLOCK = register("minecraft:red_mushroom_block", 100);

    public static final BlockType RED_NETHER_BRICK = register("minecraft:red_nether_brick", 215);

    public static final BlockType RED_NETHER_BRICK_STAIRS = register("minecraft:red_nether_brick_stairs", -184);

    public static final BlockType RED_NETHER_BRICK_WALL = register("minecraft:red_nether_brick_wall", -983);

    public static final BlockType RED_SANDSTONE = register("minecraft:red_sandstone", 179);

    public static final BlockType RED_SANDSTONE_STAIRS = register("minecraft:red_sandstone_stairs", 180);

    public static final BlockType RED_SANDSTONE_WALL = register("minecraft:red_sandstone_wall", -982);

    public static final BlockType REDSTONE_BLOCK = register("minecraft:redstone_block", 152);

    public static final BlockType REDSTONE_LAMP = register("minecraft:redstone_lamp", 123);

    public static final BlockType REDSTONE_ORE = register("minecraft:redstone_ore", 73);

    public static final BlockType REDSTONE_TORCH = register("minecraft:redstone_torch", 76);

    public static final BlockType REDSTONE_WIRE = register("minecraft:redstone_wire", 55);

    public static final BlockType REINFORCED_DEEPSLATE = register("minecraft:reinforced_deepslate", -466);

    public static final BlockType REPEATING_COMMAND_BLOCK = register("minecraft:repeating_command_block", 188);

    public static final BlockType RESERVED6 = register("minecraft:reserved6", 255);

    public static final BlockType RESPAWN_ANCHOR = register("minecraft:respawn_anchor", -272);

    public static final BlockType SAND = register("minecraft:sand", 12);

    public static final BlockType SANDSTONE = register("minecraft:sandstone", 24);

    public static final BlockType SANDSTONE_STAIRS = register("minecraft:sandstone_stairs", 128);

    public static final BlockType SANDSTONE_WALL = register("minecraft:sandstone_wall", -975);

    public static final BlockType SCAFFOLDING = register("minecraft:scaffolding", -165);

    public static final BlockType SCULK = register("minecraft:sculk", -458);

    public static final BlockType SCULK_CATALYST = register("minecraft:sculk_catalyst", -460);

    public static final BlockType SCULK_SENSOR = register("minecraft:sculk_sensor", -307);

    public static final BlockType SCULK_SHRIEKER = register("minecraft:sculk_shrieker", -461);

    public static final BlockType SCULK_VEIN = register("minecraft:sculk_vein", -459);

    public static final BlockType SEA_LANTERN = register("minecraft:sea_lantern", 169);

    public static final BlockType SEA_PICKLE = register("minecraft:sea_pickle", -156);

    public static final BlockType SEAGRASS = register("minecraft:seagrass", -130);

    public static final BlockType SHROOMLIGHT = register("minecraft:shroomlight", -230);

    public static final BlockType SILVER_GLAZED_TERRACOTTA = register("minecraft:silver_glazed_terracotta", 228);

    public static final BlockType SLIME = register("minecraft:slime", 165);

    public static final BlockType SMALL_AMETHYST_BUD = register("minecraft:small_amethyst_bud", -332);

    public static final BlockType SMALL_DRIPLEAF_BLOCK = register("minecraft:small_dripleaf_block", -336);

    public static final BlockType SMITHING_TABLE = register("minecraft:smithing_table", -202);

    public static final BlockType SMOKER = register("minecraft:smoker", -198);

    public static final BlockType SMOOTH_BASALT = register("minecraft:smooth_basalt", -377);

    public static final BlockType SMOOTH_QUARTZ_STAIRS = register("minecraft:smooth_quartz_stairs", -185);

    public static final BlockType SMOOTH_RED_SANDSTONE_STAIRS = register("minecraft:smooth_red_sandstone_stairs", -176);

    public static final BlockType SMOOTH_SANDSTONE_STAIRS = register("minecraft:smooth_sandstone_stairs", -177);

    public static final BlockType SMOOTH_STONE = register("minecraft:smooth_stone", -183);

    public static final BlockType SNIFFER_EGG = register("minecraft:sniffer_egg", -596);

    public static final BlockType SNOW = register("minecraft:snow", 80);

    public static final BlockType SNOW_LAYER = register("minecraft:snow_layer", 78);

    public static final BlockType SOUL_CAMPFIRE = register("minecraft:soul_campfire", 801);

    public static final BlockType SOUL_FIRE = register("minecraft:soul_fire", -237);

    public static final BlockType SOUL_LANTERN = register("minecraft:soul_lantern", -269);

    public static final BlockType SOUL_SAND = register("minecraft:soul_sand", 88);

    public static final BlockType SOUL_SOIL = register("minecraft:soul_soil", -236);

    public static final BlockType SOUL_TORCH = register("minecraft:soul_torch", -268);

    public static final BlockType SPONGE = register("minecraft:sponge", 19);

    public static final BlockType SPORE_BLOSSOM = register("minecraft:spore_blossom", -321);

    public static final BlockType SPRUCE_BUTTON = register("minecraft:spruce_button", -144);

    public static final BlockType SPRUCE_DOOR = register("minecraft:spruce_door", 427);

    public static final BlockType SPRUCE_FENCE_GATE = register("minecraft:spruce_fence_gate", 183);

    public static final BlockType SPRUCE_HANGING_SIGN = register("minecraft:spruce_hanging_sign", -501);

    public static final BlockType SPRUCE_PRESSURE_PLATE = register("minecraft:spruce_pressure_plate", -154);

    public static final BlockType SPRUCE_STAIRS = register("minecraft:spruce_stairs", 134);

    public static final BlockType SPRUCE_STANDING_SIGN = register("minecraft:spruce_standing_sign", -181);

    public static final BlockType SPRUCE_TRAPDOOR = register("minecraft:spruce_trapdoor", -149);

    public static final BlockType SPRUCE_WALL_SIGN = register("minecraft:spruce_wall_sign", -182);

    public static final BlockType STANDING_BANNER = register("minecraft:standing_banner", 176);

    public static final BlockType STANDING_SIGN = register("minecraft:standing_sign", 63);

    public static final BlockType STICKY_PISTON = register("minecraft:sticky_piston", 29);

    public static final BlockType STICKY_PISTON_ARM_COLLISION = register("minecraft:sticky_piston_arm_collision", -217);

    public static final BlockType STONE = register("minecraft:stone", 1);

    public static final BlockType STONE_BRICK_STAIRS = register("minecraft:stone_brick_stairs", 109);

    public static final BlockType STONE_BRICK_WALL = register("minecraft:stone_brick_wall", -977);

    public static final BlockType STONE_BUTTON = register("minecraft:stone_button", 77);

    public static final BlockType STONE_PRESSURE_PLATE = register("minecraft:stone_pressure_plate", 70);

    public static final BlockType STONE_STAIRS = register("minecraft:stone_stairs", 67);

    public static final BlockType STONECUTTER = register("minecraft:stonecutter", 245);

    public static final BlockType STONECUTTER_BLOCK = register("minecraft:stonecutter_block", -197);

    public static final BlockType STRIPPED_ACACIA_LOG = register("minecraft:stripped_acacia_log", -8);

    public static final BlockType STRIPPED_BAMBOO_BLOCK = register("minecraft:stripped_bamboo_block", -528);

    public static final BlockType STRIPPED_BIRCH_LOG = register("minecraft:stripped_birch_log", -6);

    public static final BlockType STRIPPED_CHERRY_LOG = register("minecraft:stripped_cherry_log", -535);

    public static final BlockType STRIPPED_CHERRY_WOOD = register("minecraft:stripped_cherry_wood", -545);

    public static final BlockType STRIPPED_CRIMSON_HYPHAE = register("minecraft:stripped_crimson_hyphae", -300);

    public static final BlockType STRIPPED_CRIMSON_STEM = register("minecraft:stripped_crimson_stem", -240);

    public static final BlockType STRIPPED_DARK_OAK_LOG = register("minecraft:stripped_dark_oak_log", -9);

    public static final BlockType STRIPPED_JUNGLE_LOG = register("minecraft:stripped_jungle_log", -7);

    public static final BlockType STRIPPED_MANGROVE_LOG = register("minecraft:stripped_mangrove_log", -485);

    public static final BlockType STRIPPED_MANGROVE_WOOD = register("minecraft:stripped_mangrove_wood", -498);

    public static final BlockType STRIPPED_OAK_LOG = register("minecraft:stripped_oak_log", -10);

    public static final BlockType STRIPPED_SPRUCE_LOG = register("minecraft:stripped_spruce_log", -5);

    public static final BlockType STRIPPED_WARPED_HYPHAE = register("minecraft:stripped_warped_hyphae", -301);

    public static final BlockType STRIPPED_WARPED_STEM = register("minecraft:stripped_warped_stem", -241);

    public static final BlockType STRUCTURE_BLOCK = register("minecraft:structure_block", 252);

    public static final BlockType STRUCTURE_VOID = register("minecraft:structure_void", 217);

    public static final BlockType SUSPICIOUS_GRAVEL = register("minecraft:suspicious_gravel", -573);

    public static final BlockType SUSPICIOUS_SAND = register("minecraft:suspicious_sand", -529);

    public static final BlockType SWEET_BERRY_BUSH = register("minecraft:sweet_berry_bush", -207);

    public static final BlockType TARGET = register("minecraft:target", -239);

    public static final BlockType TINTED_GLASS = register("minecraft:tinted_glass", -334);

    public static final BlockType TNT = register("minecraft:tnt", 46);

    public static final BlockType TORCH = register("minecraft:torch", 50);

    public static final BlockType TORCHFLOWER = register("minecraft:torchflower", -568);

    public static final BlockType TRAPDOOR = register("minecraft:trapdoor", 96);

    public static final BlockType TRAPPED_CHEST = register("minecraft:trapped_chest", 146);

    public static final BlockType TRIP_WIRE = register("minecraft:trip_wire", 132);

    public static final BlockType TRIPWIRE_HOOK = register("minecraft:tripwire_hook", 131);

    public static final BlockType TUFF = register("minecraft:tuff", -333);

    public static final BlockType TUFF_BRICK_SLAB = register("minecraft:tuff_brick_slab", -755);

    public static final BlockType TUFF_BRICK_STAIRS = register("minecraft:tuff_brick_stairs", -757);

    public static final BlockType TUFF_BRICK_WALL = register("minecraft:tuff_brick_wall", -758);

    public static final BlockType TUFF_BRICKS = register("minecraft:tuff_bricks", -754);

    public static final BlockType TUFF_SLAB = register("minecraft:tuff_slab", -744);

    public static final BlockType TUFF_STAIRS = register("minecraft:tuff_stairs", -746);

    public static final BlockType TUFF_WALL = register("minecraft:tuff_wall", -747);

    public static final BlockType TURTLE_EGG = register("minecraft:turtle_egg", -159);

    public static final BlockType TWISTING_VINES = register("minecraft:twisting_vines", -287);

    public static final BlockType UNDERWATER_TORCH = register("minecraft:underwater_torch", 239);

    public static final BlockType UNDYED_SHULKER_BOX = register("minecraft:undyed_shulker_box", 205);

    public static final BlockType UNKNOWN = register("minecraft:unknown", -305);

    public static final BlockType UNLIT_REDSTONE_TORCH = register("minecraft:unlit_redstone_torch", 75);

    public static final BlockType UNPOWERED_COMPARATOR = register("minecraft:unpowered_comparator", 149);

    public static final BlockType UNPOWERED_REPEATER = register("minecraft:unpowered_repeater", 93);

    public static final BlockType VERDANT_FROGLIGHT = register("minecraft:verdant_froglight", -470);

    public static final BlockType VINE = register("minecraft:vine", 106);

    public static final BlockType WALL_BANNER = register("minecraft:wall_banner", 177);

    public static final BlockType WALL_SIGN = register("minecraft:wall_sign", 68);

    public static final BlockType WARPED_BUTTON = register("minecraft:warped_button", -261);

    public static final BlockType WARPED_DOOR = register("minecraft:warped_door", 756);

    public static final BlockType WARPED_DOUBLE_SLAB = register("minecraft:warped_double_slab", -267);

    public static final BlockType WARPED_FENCE = register("minecraft:warped_fence", -257);

    public static final BlockType WARPED_FENCE_GATE = register("minecraft:warped_fence_gate", -259);

    public static final BlockType WARPED_FUNGUS = register("minecraft:warped_fungus", -229);

    public static final BlockType WARPED_HANGING_SIGN = register("minecraft:warped_hanging_sign", -507);

    public static final BlockType WARPED_HYPHAE = register("minecraft:warped_hyphae", -298);

    public static final BlockType WARPED_NYLIUM = register("minecraft:warped_nylium", -233);

    public static final BlockType WARPED_PLANKS = register("minecraft:warped_planks", -243);

    public static final BlockType WARPED_PRESSURE_PLATE = register("minecraft:warped_pressure_plate", -263);

    public static final BlockType WARPED_ROOTS = register("minecraft:warped_roots", -224);

    public static final BlockType WARPED_SLAB = register("minecraft:warped_slab", -265);

    public static final BlockType WARPED_STAIRS = register("minecraft:warped_stairs", -255);

    public static final BlockType WARPED_STANDING_SIGN = register("minecraft:warped_standing_sign", -251);

    public static final BlockType WARPED_STEM = register("minecraft:warped_stem", -226);

    public static final BlockType WARPED_TRAPDOOR = register("minecraft:warped_trapdoor", -247);

    public static final BlockType WARPED_WALL_SIGN = register("minecraft:warped_wall_sign", -253);

    public static final BlockType WARPED_WART_BLOCK = register("minecraft:warped_wart_block", -227);

    public static final BlockType WATER = register("minecraft:water", 9);

    public static final BlockType WATERLILY = register("minecraft:waterlily", 111);

    public static final BlockType WAXED_CHISELED_COPPER = register("minecraft:waxed_chiseled_copper", -764);

    public static final BlockType WAXED_COPPER = register("minecraft:waxed_copper", -344);

    public static final BlockType WAXED_COPPER_BULB = register("minecraft:waxed_copper_bulb", -780);

    public static final BlockType WAXED_COPPER_DOOR = register("minecraft:waxed_copper_door", -788);

    public static final BlockType WAXED_COPPER_GRATE = register("minecraft:waxed_copper_grate", -772);

    public static final BlockType WAXED_COPPER_TRAPDOOR = register("minecraft:waxed_copper_trapdoor", -796);

    public static final BlockType WAXED_CUT_COPPER = register("minecraft:waxed_cut_copper", -351);

    public static final BlockType WAXED_CUT_COPPER_SLAB = register("minecraft:waxed_cut_copper_slab", -365);

    public static final BlockType WAXED_CUT_COPPER_STAIRS = register("minecraft:waxed_cut_copper_stairs", -358);

    public static final BlockType WAXED_DOUBLE_CUT_COPPER_SLAB = register("minecraft:waxed_double_cut_copper_slab", -372);

    public static final BlockType WAXED_EXPOSED_CHISELED_COPPER = register("minecraft:waxed_exposed_chiseled_copper", -765);

    public static final BlockType WAXED_EXPOSED_COPPER = register("minecraft:waxed_exposed_copper", -345);

    public static final BlockType WAXED_EXPOSED_COPPER_BULB = register("minecraft:waxed_exposed_copper_bulb", -781);

    public static final BlockType WAXED_EXPOSED_COPPER_DOOR = register("minecraft:waxed_exposed_copper_door", -789);

    public static final BlockType WAXED_EXPOSED_COPPER_GRATE = register("minecraft:waxed_exposed_copper_grate", -773);

    public static final BlockType WAXED_EXPOSED_COPPER_TRAPDOOR = register("minecraft:waxed_exposed_copper_trapdoor", -797);

    public static final BlockType WAXED_EXPOSED_CUT_COPPER = register("minecraft:waxed_exposed_cut_copper", -352);

    public static final BlockType WAXED_EXPOSED_CUT_COPPER_SLAB = register("minecraft:waxed_exposed_cut_copper_slab", -366);

    public static final BlockType WAXED_EXPOSED_CUT_COPPER_STAIRS = register("minecraft:waxed_exposed_cut_copper_stairs", -359);

    public static final BlockType WAXED_EXPOSED_DOUBLE_CUT_COPPER_SLAB = register("minecraft:waxed_exposed_double_cut_copper_slab", -373);

    public static final BlockType WAXED_OXIDIZED_CHISELED_COPPER = register("minecraft:waxed_oxidized_chiseled_copper", -767);

    public static final BlockType WAXED_OXIDIZED_COPPER = register("minecraft:waxed_oxidized_copper", -446);

    public static final BlockType WAXED_OXIDIZED_COPPER_BULB = register("minecraft:waxed_oxidized_copper_bulb", -783);

    public static final BlockType WAXED_OXIDIZED_COPPER_DOOR = register("minecraft:waxed_oxidized_copper_door", -791);

    public static final BlockType WAXED_OXIDIZED_COPPER_GRATE = register("minecraft:waxed_oxidized_copper_grate", -775);

    public static final BlockType WAXED_OXIDIZED_COPPER_TRAPDOOR = register("minecraft:waxed_oxidized_copper_trapdoor", -799);

    public static final BlockType WAXED_OXIDIZED_CUT_COPPER = register("minecraft:waxed_oxidized_cut_copper", -447);

    public static final BlockType WAXED_OXIDIZED_CUT_COPPER_SLAB = register("minecraft:waxed_oxidized_cut_copper_slab", -449);

    public static final BlockType WAXED_OXIDIZED_CUT_COPPER_STAIRS = register("minecraft:waxed_oxidized_cut_copper_stairs", -448);

    public static final BlockType WAXED_OXIDIZED_DOUBLE_CUT_COPPER_SLAB = register("minecraft:waxed_oxidized_double_cut_copper_slab", -450);

    public static final BlockType WAXED_WEATHERED_CHISELED_COPPER = register("minecraft:waxed_weathered_chiseled_copper", -766);

    public static final BlockType WAXED_WEATHERED_COPPER = register("minecraft:waxed_weathered_copper", -346);

    public static final BlockType WAXED_WEATHERED_COPPER_BULB = register("minecraft:waxed_weathered_copper_bulb", -782);

    public static final BlockType WAXED_WEATHERED_COPPER_DOOR = register("minecraft:waxed_weathered_copper_door", -790);

    public static final BlockType WAXED_WEATHERED_COPPER_GRATE = register("minecraft:waxed_weathered_copper_grate", -774);

    public static final BlockType WAXED_WEATHERED_COPPER_TRAPDOOR = register("minecraft:waxed_weathered_copper_trapdoor", -798);

    public static final BlockType WAXED_WEATHERED_CUT_COPPER = register("minecraft:waxed_weathered_cut_copper", -353);

    public static final BlockType WAXED_WEATHERED_CUT_COPPER_SLAB = register("minecraft:waxed_weathered_cut_copper_slab", -367);

    public static final BlockType WAXED_WEATHERED_CUT_COPPER_STAIRS = register("minecraft:waxed_weathered_cut_copper_stairs", -360);

    public static final BlockType WAXED_WEATHERED_DOUBLE_CUT_COPPER_SLAB = register("minecraft:waxed_weathered_double_cut_copper_slab", -374);

    public static final BlockType WEATHERED_CHISELED_COPPER = register("minecraft:weathered_chiseled_copper", -762);

    public static final BlockType WEATHERED_COPPER = register("minecraft:weathered_copper", -342);

    public static final BlockType WEATHERED_COPPER_BULB = register("minecraft:weathered_copper_bulb", -778);

    public static final BlockType WEATHERED_COPPER_DOOR = register("minecraft:weathered_copper_door", -786);

    public static final BlockType WEATHERED_COPPER_GRATE = register("minecraft:weathered_copper_grate", -770);

    public static final BlockType WEATHERED_COPPER_TRAPDOOR = register("minecraft:weathered_copper_trapdoor", -794);

    public static final BlockType WEATHERED_CUT_COPPER = register("minecraft:weathered_cut_copper", -349);

    public static final BlockType WEATHERED_CUT_COPPER_SLAB = register("minecraft:weathered_cut_copper_slab", -363);

    public static final BlockType WEATHERED_CUT_COPPER_STAIRS = register("minecraft:weathered_cut_copper_stairs", -356);

    public static final BlockType WEATHERED_DOUBLE_CUT_COPPER_SLAB = register("minecraft:weathered_double_cut_copper_slab", -370);

    public static final BlockType WEB = register("minecraft:web", 30);

    public static final BlockType WEEPING_VINES = register("minecraft:weeping_vines", -231);

    public static final BlockType WHEAT = register("minecraft:wheat", 296);

    public static final BlockType WHITE_CANDLE = register("minecraft:white_candle", -413);

    public static final BlockType WHITE_CANDLE_CAKE = register("minecraft:white_candle_cake", -430);

    public static final BlockType WHITE_GLAZED_TERRACOTTA = register("minecraft:white_glazed_terracotta", 220);

    public static final BlockType WITHER_ROSE = register("minecraft:wither_rose", -216);

    public static final BlockType WOODEN_BUTTON = register("minecraft:wooden_button", 143);

    public static final BlockType WOODEN_DOOR = register("minecraft:wooden_door", 324);

    public static final BlockType WOODEN_PRESSURE_PLATE = register("minecraft:wooden_pressure_plate", 72);

    public static final BlockType YELLOW_CANDLE = register("minecraft:yellow_candle", -417);

    public static final BlockType YELLOW_CANDLE_CAKE = register("minecraft:yellow_candle_cake", -434);

    public static final BlockType YELLOW_GLAZED_TERRACOTTA = register("minecraft:yellow_glazed_terracotta", 224);

    public static BlockType register(String identifier, int legacyId) {
        return register(new BlockTypeImpl(identifier, legacyId));
    }

    public static BlockType register(BlockType blockType) {
        BlockType oldType = ID_TO_TYPE.get(blockType.getIdentifier());
        LEGACY_TO_TYPE.putIfAbsent(blockType.getLegacyId(), blockType);
        ID_TO_TYPE.putIfAbsent(blockType.getIdentifier(), blockType);
        ItemTypes.register(blockType.getIdentifier(), blockType.getLegacyId());
        return oldType != null ? oldType : blockType;
    }

    public static BlockType get(String identifier) {
        return ID_TO_TYPE.get(identifier);
    }

    public static BlockType getFromLegacy(int legacyId) {
        return LEGACY_TO_TYPE.get(legacyId);
    }

    @Data
    private static class BlockTypeImpl implements BlockType {
        private final String identifier;
        private final int legacyId;
    }
}
