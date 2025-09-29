package cn.nukkit.recipe.impl;

import cn.nukkit.item.Item;
import cn.nukkit.recipe.RecipeType;
import cn.nukkit.registry.Registries;

public class BlastFurnaceRecipe extends FurnaceRecipe {

    public BlastFurnaceRecipe(Item result, Item ingredient) {
        super(result, ingredient);
    }

    @Override
    public void registerToCraftingManager() {
        Registries.RECIPE.addBlastFurnace(this);
    }

    @Override
    public RecipeType getType() {
        return this.ingredient.hasMeta() ? RecipeType.BLAST_FURNACE_DATA : RecipeType.BLAST_FURNACE;
    }
}
