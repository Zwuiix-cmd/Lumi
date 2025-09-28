package cn.nukkit.recipe;

import cn.nukkit.item.Item;

import java.util.*;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public interface Recipe {

    Item getResult();

    void registerToCraftingManager();

    RecipeType getType();

    static boolean matchItemList(List<Item> haveItems, Collection<ItemDescriptor> needItems) {
        final Map<ItemDescriptor, Integer> map = new HashMap<>();
        for(final ItemDescriptor item : needItems) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        for (ItemDescriptor recipeItem : new ArrayList<>(needItems)) {
            for (Item haveItem : new ArrayList<>(haveItems)) {
                if (recipeItem.equals(haveItem)) {
                    int amount = Math.min(haveItem.getCount(), map.get(recipeItem));
                    map.put(recipeItem, map.get(recipeItem) - amount);
                    haveItem.setCount(haveItem.getCount() - amount);
                    if (haveItem.getCount() == 0) {
                        haveItems.remove(haveItem);
                    }
                    if (map.get(recipeItem) == 0) {
                        needItems.remove(recipeItem);
                        break;
                    }
                }
            }
        }
        return haveItems.isEmpty() && needItems.isEmpty();
    }
}
