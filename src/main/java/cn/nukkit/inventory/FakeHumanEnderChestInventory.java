package cn.nukkit.inventory;

import cn.nukkit.Player;
import cn.nukkit.entity.EntityIntelligentHuman;

public class FakeHumanEnderChestInventory extends BaseInventory {
    public FakeHumanEnderChestInventory(EntityIntelligentHuman player) {
        super(player, InventoryType.ENDER_CHEST);
    }

    @Override
    public EntityIntelligentHuman getHolder() {
        return (EntityIntelligentHuman) this.holder;
    }

    //non
    @Override
    public void close(Player who) {
    }

    @Override
    public void onOpen(Player who) {
    }

    @Override
    public void onClose(Player who) {
    }

    @Override
    public boolean open(Player who) {
        return false;
    }
}