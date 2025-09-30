package cn.nukkit.recipe.impl.special;

import cn.nukkit.Player;
import cn.nukkit.item.ItemMap;
import cn.nukkit.item.ItemPaper;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.impl.MultiRecipe;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class MapExtendingRecipe extends MultiRecipe {

    public MapExtendingRecipe(){
        super(UUID.fromString(TYPE_MAP_EXTENDING));
    }

    @Override
    public boolean canExecute(Player player, Item outputItem, Collection<ItemDescriptor> inputs) {
        // todo: I guess this recipe is similar to MapUpgradingRecipe, but without certain ideas.
        if (outputItem.getId() != ItemID.MAP && outputItem.getCount() != 1) {
            return false;
        }
        int filledMap = 0;
        int paper = 0;
        for (ItemDescriptor input : inputs) {
            if (input instanceof ItemMap) {
                filledMap += 1;
            } else if (input instanceof ItemPaper) {
                paper += 1;
            }
        }
        if (filledMap < 1) {
            return false;
        }
        if (paper < 8) {
            return false;
        }
        return true;
    }
}