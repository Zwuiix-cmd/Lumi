package cn.nukkit.recipe.impl;

import cn.nukkit.item.Item;
import cn.nukkit.recipe.RecipeType;
import cn.nukkit.registry.Registries;

public class ContainerRecipe extends MixRecipe {

    public ContainerRecipe(Item input, Item ingredient, Item output) {
        super(input, ingredient, output);
    }

    @Override
    public void registerToCraftingManager() {
        Registries.RECIPE.registerContainerRecipe(this);
    }

    @Override
    public RecipeType getType() {
        throw new UnsupportedOperationException();
    }
}
