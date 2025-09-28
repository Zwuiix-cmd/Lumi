package cn.nukkit.recipe;

import cn.nukkit.item.Item;
import cn.nukkit.item.material.tags.ItemTag;
import cn.nukkit.utils.BinaryStream;

public interface ItemDescriptor extends Cloneable {
    void putRecipe(BinaryStream stream, int protocol);

    default boolean equalsRecipeItem(ItemDescriptor entry) {
        if(this instanceof ItemTag tag && entry instanceof Item item) {
            return tag.has(item.getItemType());
        }
        if(this instanceof Item item1 && entry instanceof Item item2) {
            return item1.equals(item2);
        }
        return false;
    }
}
