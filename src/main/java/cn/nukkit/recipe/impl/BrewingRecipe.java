package cn.nukkit.recipe.impl;


import cn.nukkit.item.Item;
import cn.nukkit.recipe.RecipeType;
import cn.nukkit.registry.Registries;

public class BrewingRecipe extends MixRecipe {

    public BrewingRecipe(Item input, Item ingredient, Item output) {
        super(input, ingredient, output);
    }

    @Override
    public void registerToCraftingManager() {
        Registries.RECIPE_REGISTRY.registerBrewingRecipe(this);
    }

    @Override
    public RecipeType getType() {
        throw new UnsupportedOperationException();
    }
}