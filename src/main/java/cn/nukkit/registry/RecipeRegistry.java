package cn.nukkit.registry;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.BatchPacket;
import cn.nukkit.network.protocol.CraftingDataPacket;
import cn.nukkit.recipe.CraftingRecipe;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.Recipe;
import cn.nukkit.recipe.impl.*;
import cn.nukkit.utils.RecipeUtils;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Getter;

import javax.annotation.Nullable;
import java.util.*;
import java.util.zip.Deflater;

@Getter
public class RecipeRegistry {
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

    public void addFurnace(FurnaceRecipe recipe) {
        furnace.put(RecipeUtils.getItemHash(recipe.getInput()), recipe);
    }

    public FurnaceRecipe matchFurnaceRecipe(Item input) {
        FurnaceRecipe recipe = furnace.get(RecipeUtils.getItemHash(input));
        if (recipe == null) recipe = furnace.get(RecipeUtils.getItemHash(input, 0));
        return recipe;
    }

    public void addBlastFurnace(BlastFurnaceRecipe recipe) {
        blastFurnace.put(RecipeUtils.getItemHash(recipe.getInput()), recipe);
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

    public void registerCampfireRecipe(CampfireRecipe recipe) {
        Item input = recipe.getInput();
        this.campfireRecipes.put(RecipeUtils.getItemHash(input), recipe);
    }

    public void registerMultiRecipe(MultiRecipe recipe) {
        this.multiRecipes.put(recipe.getId(), recipe);
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
