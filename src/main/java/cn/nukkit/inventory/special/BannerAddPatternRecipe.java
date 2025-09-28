package cn.nukkit.inventory.special;

import cn.nukkit.Player;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.impl.MultiRecipe;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemDye;
import cn.nukkit.item.ItemID;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class BannerAddPatternRecipe extends MultiRecipe {

    public BannerAddPatternRecipe(){
        super(UUID.fromString(TYPE_BANNER_ADD_PATTERN));
    }

    @Override
    public boolean canExecute(Player player, Item outputItem, Collection<ItemDescriptor> inputs) {
        if (outputItem.getId() != ItemID.BANNER) {
            return false;
        }
        int dyeCount = 0;
        for (ItemDescriptor input : inputs) {
            if (input instanceof ItemDye) {
                dyeCount += 1;
            }
        }
        if (dyeCount < 3) {
            return false;
        }
        return true;
    }
}