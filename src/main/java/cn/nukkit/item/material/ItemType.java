package cn.nukkit.item.material;

import cn.nukkit.item.Item;

public interface ItemType {

    String getIdentifier();

    int getLegacyId();

    default Item createItem() {
        return this.createItem(1);
    }

    default Item createItem(int count) {
        return this.createItem(count, 0);
    }

    default Item createItem(int count, int meta) {
        return Item.get(this.getLegacyId(), count, meta);
    }
}
