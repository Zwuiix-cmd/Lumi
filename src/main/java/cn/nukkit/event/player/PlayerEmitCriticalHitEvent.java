package cn.nukkit.event.player;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.Event;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerEmitCriticalHitEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    public static HandlerList getHandlers() {
        return handlers;
    }

    private Entity entity;
    private Player damager;
    private EntityDamageByEntityEvent damageEvent;
    private float damage;

    public PlayerEmitCriticalHitEvent(float damage, Entity entity, Player damager, EntityDamageByEntityEvent damageEvent) {
        this.damage = damage;
        this.entity = entity;
        this.damager = damager;
        this.damageEvent = damageEvent;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public Entity getEntity() {
        return entity;
    }

    public Player getDamager() {
        return damager;
    }

    public EntityDamageByEntityEvent getDamageEvent() {
        return damageEvent;
    }
}
