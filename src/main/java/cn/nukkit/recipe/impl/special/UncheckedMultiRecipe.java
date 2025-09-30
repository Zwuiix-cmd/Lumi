package cn.nukkit.recipe.impl.special;

import cn.nukkit.Player;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.impl.MultiRecipe;
import cn.nukkit.item.Item;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/*
   TODO: when cartography is supported, this should be disused.
 */
public class UncheckedMultiRecipe extends MultiRecipe {

    public UncheckedMultiRecipe(String id){
        super(UUID.fromString(id));
    }

    @Override
    public boolean canExecute(Player player, Item outputItem, Collection<ItemDescriptor> inputs) {
        return true;
    }
}