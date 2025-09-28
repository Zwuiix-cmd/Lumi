package cn.nukkit.inventory.special;

import cn.nukkit.Player;
import cn.nukkit.item.ItemGunpowder;
import cn.nukkit.item.ItemPaper;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.impl.MultiRecipe;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class FireworkRecipe extends MultiRecipe {

    public FireworkRecipe(){
        super(UUID.fromString(TYPE_FIREWORKS));
    }

    @Override
    public boolean canExecute(Player player, Item outputItem, Collection<ItemDescriptor> inputs) {
        if (outputItem.getId() == ItemID.FIREWORKS) {
            boolean hasPaper = false;
            int powder = 0;
            for (ItemDescriptor input : inputs) {
                if (input instanceof ItemGunpowder) {
                    powder += 1;
                } else if (input instanceof ItemPaper) {
                    hasPaper = true;
                }
            }
            if (!hasPaper) {
                return false;
            }
            if (powder != outputItem.getCount()) {
                return false;
            }
            return true;
        }
        return false;
    }
}