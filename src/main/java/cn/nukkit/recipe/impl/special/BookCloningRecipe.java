package cn.nukkit.recipe.impl.special;

import cn.nukkit.Player;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.impl.MultiRecipe;
import cn.nukkit.item.Item;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class BookCloningRecipe extends MultiRecipe {

    public BookCloningRecipe(){
        super(UUID.fromString(TYPE_BOOK_CLONING));
    }

    @Override
    public boolean canExecute(Player player, Item outputItem, Collection<ItemDescriptor> inputs) {
        // Processing the checks about the inputs and outputItem
        ItemDescriptor[] items = inputs.toArray(new ItemDescriptor[0]);
        if (inputs.size() == 2 &&  items[0] instanceof Item item1 && items[1] instanceof Item item2) {
            if (item1.getId() == Item.WRITTEN_BOOK && item2.getId() == Item.BOOK_AND_QUILL) {
                return true;
            } else return item1.getId() == Item.BOOK_AND_QUILL && item2.getId() == Item.WRITTEN_BOOK;
        }
        return false;
    }
}