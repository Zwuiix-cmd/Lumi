package cn.nukkit.recipe.impl.special;

import cn.nukkit.Player;
import cn.nukkit.item.ItemBanner;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.impl.MultiRecipe;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class BannerDuplicateRecipe extends MultiRecipe {

    public BannerDuplicateRecipe(){
        super(UUID.fromString(TYPE_BANNER_DUPLICATE));
    }

    @Override
    public boolean canExecute(Player player, Item outputItem, Collection<ItemDescriptor> inputs) {
        int count = 0;
        for (ItemDescriptor input : inputs) {
            if (!(input instanceof ItemBanner)) {
                return false;
            }
            count += 1;
        }
        if (count < 2) {
            return false;
        }
        if (outputItem.getId() == ItemID.BANNER) {
            return true;
        }
        return false;
    }
}