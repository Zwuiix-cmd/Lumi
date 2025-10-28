package cn.nukkit.event.player;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.Event;
import cn.nukkit.event.HandlerList;
import cn.nukkit.math.BlockFace;

public class PlayerEmitCriticalHitEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    public static HandlerList getHandlers() {
        return handlers;
    }

    private Entity entity;
    private Player damager;

    public PlayerEmitCriticalHitEvent(Entity entity, Player damager) {
        this.entity = entity;
        this.damager = damager;
    }

    public Entity getEntity() {
        return entity;
    }

    public Player getDamager() {
        return damager;
    }
}
