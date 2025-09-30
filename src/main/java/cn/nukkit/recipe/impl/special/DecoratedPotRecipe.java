package cn.nukkit.recipe.impl.special;

import cn.nukkit.Player;
import cn.nukkit.item.ItemBrick;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.impl.MultiRecipe;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemPotterySherd;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class DecoratedPotRecipe extends MultiRecipe {

    public DecoratedPotRecipe(){
        super(UUID.fromString(TYPE_DECORATED_POT_RECIPE));
    }

    @Override
    public boolean canExecute(Player player, Item outputItem, Collection<ItemDescriptor> inputs) {
        if (outputItem.getId() != Item.DECORATED_POT) {
            return false;
        }
        int brickCount = 0;
        int sherdCount = 0;
        for (ItemDescriptor input : inputs) {
            if (input instanceof ItemBrick) {
                brickCount += 1;
            }
            if (input instanceof ItemPotterySherd) {
                sherdCount += 1;
            }
        }
        if (sherdCount + brickCount < 4) {
            return false;
        }
        return true;
    }
}