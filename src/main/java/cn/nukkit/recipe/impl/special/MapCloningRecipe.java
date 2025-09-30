package cn.nukkit.recipe.impl.special;

import cn.nukkit.Player;
import cn.nukkit.item.ItemEmptyMap;
import cn.nukkit.item.ItemMap;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.impl.MultiRecipe;
import cn.nukkit.item.Item;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class MapCloningRecipe extends MultiRecipe {

    public MapCloningRecipe(){
        super(UUID.fromString(TYPE_MAP_CLONING));
    }

    @Override
    public boolean canExecute(Player player, Item outputItem, Collection<ItemDescriptor> inputs) {
        if (outputItem.getId() != Item.MAP) {
            return false;
        }
        int filledMap = 0;
        int emptyMap = 0;
        for (ItemDescriptor input : inputs) {
            if (input instanceof ItemMap item) {
                filledMap += item.getCount();
            } else if (input instanceof ItemEmptyMap item) {
                emptyMap += item.getCount();
            }
        }
        if (filledMap == 0 || emptyMap == 0) {
            return false;
        }
        if (outputItem.getCount() - 1 != emptyMap) {
            return false;
        }
        return true;
    }
}