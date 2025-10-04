package cn.nukkit.registry;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.BatchPacket;
import cn.nukkit.network.protocol.CraftingDataPacket;
import cn.nukkit.recipe.CraftingRecipe;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.Recipe;
import cn.nukkit.recipe.impl.*;
import cn.nukkit.recipe.impl.special.*;
import cn.nukkit.recipe.parser.RecipeParser;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.RecipeUtils;
import com.google.gson.JsonParser;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Getter;

import javax.annotation.Nullable;
import java.io.InputStreamReader;
import java.util.*;
import java.util.zip.Deflater;

@Getter
public class RecipeRegistry implements IRegistry<String, Recipe, Recipe> {
    public static int NEXT_NETWORK_ID = 1;

    private BatchPacket packet;

    private final Map<Integer, Map<UUID, ShapedRecipe>> shaped = new HashMap<>();
    private final Map<Integer, Map<UUID, ShapelessRecipe>> shapless = new HashMap<>();
    private final Map<Integer, FurnaceRecipe> furnace = new HashMap<>();
    private final Map<Integer, BlastFurnaceRecipe> blastFurnace = new HashMap<>();

    private final Map<UUID, MultiRecipe> multiRecipes = new HashMap<>();
    private final Map<Integer, BrewingRecipe> brewingRecipes = new Int2ObjectOpenHashMap<>();
    private final Map<Integer, ContainerRecipe> containerRecipes = new Int2ObjectOpenHashMap<>();
    private final Map<Integer, CampfireRecipe> campfireRecipes = new Int2ObjectOpenHashMap<>();
    private final Map<UUID, SmithingRecipe> smithingRecipes = new Object2ObjectOpenHashMap<>(); //589
    private final Object2DoubleOpenHashMap<Recipe> recipeXpMap = new Object2DoubleOpenHashMap<>();
    private final Collection<Recipe> recipes = new ArrayDeque<>(); //649

    @Override
    public void init() {
        this.registerMultiRecipe(new RepairItemRecipe());
        this.registerMultiRecipe(new BookCloningRecipe());
        this.registerMultiRecipe(new MapCloningRecipe());
        this.registerMultiRecipe(new MapUpgradingRecipe());
        this.registerMultiRecipe(new MapExtendingRecipe());
        this.registerMultiRecipe(new BannerAddPatternRecipe());
        this.registerMultiRecipe(new BannerDuplicateRecipe());
        this.registerMultiRecipe(new FireworkRecipe());
        this.registerMultiRecipe(new DecoratedPotRecipe());

        Config extras407 = new Config(Config.YAML).loadFromStream(Server.class.getClassLoader().getResourceAsStream("recipes/brewing_recipes.json"));
        List<Map> potionMixes407 = extras407.getMapList("potionMixes");
        for (Map potionMix : potionMixes407) {
            int fromPotionId = ((Number) potionMix.get("inputId")).intValue();
            int fromPotionMeta = ((Number) potionMix.get("inputMeta")).intValue();
            int ingredient = ((Number) potionMix.get("reagentId")).intValue();
            int ingredientMeta = ((Number) potionMix.get("reagentMeta")).intValue();
            int toPotionId = ((Number) potionMix.get("outputId")).intValue();
            int toPotionMeta = ((Number) potionMix.get("outputMeta")).intValue();
            Registries.RECIPE.registerBrewingRecipe(new BrewingRecipe(Item.get(fromPotionId, fromPotionMeta), Item.get(ingredient, ingredientMeta), Item.get(toPotionId, toPotionMeta)));
        }

        RecipeParser.loadRecipes(JsonParser.parseReader(new InputStreamReader(Server.class.getClassLoader().getResourceAsStream("recipes/recipes_827.json"))).getAsJsonObject().get("recipes").getAsJsonArray());
        this.rebuildPacket();
    }

    @Override
    public void register(String key, Recipe value) {

    }

    @Override
    public Recipe get(String key) {
        return null;
    }

    @Override
    public void trim() {

    }

    @Override
    public void reload() {

    }

    public void addFurnace(FurnaceRecipe recipe, double xp) {
        furnace.put(RecipeUtils.getItemHash(recipe.getInput()), recipe);
        recipeXpMap.put(recipe, xp);
    }

    public FurnaceRecipe matchFurnaceRecipe(Item input) {
        FurnaceRecipe recipe = furnace.get(RecipeUtils.getItemHash(input));
        if (recipe == null) recipe = furnace.get(RecipeUtils.getItemHash(input, 0));
        return recipe;
    }

    public void addBlastFurnace(BlastFurnaceRecipe recipe, double xp) {
        blastFurnace.put(RecipeUtils.getItemHash(recipe.getInput()), recipe);
        recipeXpMap.put(recipe, xp);
    }

    public FurnaceRecipe matchBlastFurnaceRecipe(Item input) {
        BlastFurnaceRecipe recipe = blastFurnace.get(RecipeUtils.getItemHash(input));
        if (recipe == null) recipe = blastFurnace.get(RecipeUtils.getItemHash(input, 0));
        return recipe;
    }

    public void registerShapedRecipe(ShapedRecipe recipe) {
        int resultHash = RecipeUtils.getItemHash(recipe.getResult());
        shaped.computeIfAbsent(resultHash, (key) -> new HashMap<>()).put(UUID.randomUUID(), recipe);
        recipes.add(recipe);
    }

    public void registerShapelessRecipe(ShapelessRecipe recipe) {
        int resultHash = RecipeUtils.getItemHash(recipe.getResult());
        shapless.computeIfAbsent(resultHash, (key) -> new HashMap<>()).put(UUID.randomUUID(), recipe);
        recipes.add(recipe);
    }

    public CraftingRecipe matchRecipe(List<Item> inputList, Item primaryOutput, List<Item> extraOutputList) {
        int outputHash = RecipeUtils.getItemHash(primaryOutput);
        if (shaped.containsKey(outputHash)) {

            UUID inputHash = RecipeUtils.getMultiItemHash(inputList);
            Map<UUID, ShapedRecipe> recipeMap = shaped.get(outputHash);

            if (recipeMap != null) {
                ShapedRecipe recipe = recipeMap.get(inputHash);

                if (recipe != null && recipe.matchItems(inputList, extraOutputList)) {
                    return recipe;
                }

                for (ShapedRecipe shapedRecipe : recipeMap.values()) {
                    if (shapedRecipe.matchItems(inputList, extraOutputList)) {
                        return shapedRecipe;
                    }
                }
            }
        }

        if (shapless.containsKey(outputHash)) {
            Map<UUID, ShapelessRecipe> recipes = shapless.get(outputHash);

            if (recipes == null) {
                return null;
            }

            UUID inputHash = RecipeUtils.getMultiItemHash(inputList);
            ShapelessRecipe recipe = recipes.get(inputHash);

            if (recipe != null && (recipe.matchItems(inputList, extraOutputList))) {
                return recipe;
            }

            for (ShapelessRecipe shapelessRecipe : recipes.values()) {
                if (shapelessRecipe.matchItems(inputList, extraOutputList)) {
                    return shapelessRecipe;
                }
            }
        }

        return null;
    }

    @Nullable
    public SmithingRecipe matchSmithingRecipe(List<Item> inputList) {
        UUID inputHash = RecipeUtils.getMultiItemHash(inputList);

        Map<UUID, SmithingRecipe> recipeMap = Registries.RECIPE.getSmithingRecipes();

        if (recipeMap != null) {
            SmithingRecipe recipe = recipeMap.get(inputHash);

            if (recipe != null && recipe.matchItems(inputList)) {
                return recipe;
            }

            ArrayList<Item> list = new ArrayList<>();
            for (Item item : inputList) {
                Item clone = item.clone();
                clone.setCount(1);
                if ((item.isTool() || item.isArmor()) && item.getDamage() > 0) {
                    clone.setDamage(0);
                }
                list.add(clone);
            }

            for (SmithingRecipe smithingRecipe : recipeMap.values()) {
                if (smithingRecipe.matchItems(list)) {
                    return smithingRecipe;
                }
            }
        }
        return null;
    }

    public MultiRecipe getMultiRecipe(Player player, Item outputItem, Collection<ItemDescriptor> inputs) {
        if(outputItem == null) return null;
        return this.multiRecipes.values().stream().filter(multiRecipe -> multiRecipe.canExecute(player, outputItem, inputs)).findFirst().orElse(null);
    }

    public void registerSmithingRecipe(SmithingRecipe recipe) {
        this.smithingRecipes.put(UUID.randomUUID(), recipe);
    }

    public void registerBrewingRecipe(BrewingRecipe recipe) {
        Item input = recipe.getIngredient();
        Item potion = recipe.getInput();
        int potionHash = RecipeUtils.getPotionHash(input, potion);
        this.brewingRecipes.put(potionHash, recipe);
    }

    public void registerContainerRecipe(ContainerRecipe recipe) {
        Item input = recipe.getIngredient();
        Item potion = recipe.getInput();
        this.containerRecipes.put(RecipeUtils.getContainerHash(input.getId(), potion.getId()), recipe);
    }


    public BrewingRecipe matchBrewingRecipe(Item input, Item potion) {
        return this.brewingRecipes.get(RecipeUtils.getPotionHash(input, potion));
    }

    public CampfireRecipe matchCampfireRecipe(Item input) {
        CampfireRecipe recipe = this.campfireRecipes.get(RecipeUtils.getItemHash(input));
        if (recipe == null) recipe = this.campfireRecipes.get(RecipeUtils.getItemHash(input, 0));
        return recipe;
    }

    public ContainerRecipe matchContainerRecipe(Item input, Item potion) {
        return this.containerRecipes.get(RecipeUtils.getContainerHash(input.getId(), potion.getId()));
    }

    public void registerCampfireRecipe(CampfireRecipe recipe, double xp) {
        Item input = recipe.getInput();
        this.campfireRecipes.put(RecipeUtils.getItemHash(input), recipe);
        recipeXpMap.put(recipe, xp);
    }

    public void registerMultiRecipe(MultiRecipe recipe) {
        this.multiRecipes.put(recipe.getId(), recipe);
        recipes.add(recipe);
    }

    public double getRecipeXp(Recipe recipe) {
        return recipeXpMap.getOrDefault(recipe, 0.0);
    }

    public void setRecipeXp(Recipe recipe, double xp) {
        recipeXpMap.put(recipe, xp);
    }

    public void rebuildPacket() {
        final CraftingDataPacket  pk = new CraftingDataPacket();

        for(FurnaceRecipe recipe : furnace.values()) {
            pk.addFurnaceRecipe(recipe);
        }

        for (MultiRecipe recipe : this.getMultiRecipes().values()) {
            pk.addMultiRecipe(recipe);
        }

        for (Recipe recipe : this.getRecipes()) {
            if (recipe instanceof ShapedRecipe) {
                pk.addShapedRecipe((ShapedRecipe) recipe);
            } else if (recipe instanceof ShapelessRecipe) {
                pk.addShapelessRecipe((ShapelessRecipe) recipe);
            }
        }

        for (SmithingRecipe recipe : this.getSmithingRecipes().values()) {
            pk.addShapelessRecipe(recipe);
        }

        for (BrewingRecipe recipe : brewingRecipes.values()) {
            pk.addBrewingRecipe(recipe);
        }

        for (ContainerRecipe recipe : containerRecipes.values()) {
            pk.addContainerRecipe(recipe);
        }

        pk.tryEncode();
        packet = pk.compress(Deflater.BEST_COMPRESSION);
    }
}
