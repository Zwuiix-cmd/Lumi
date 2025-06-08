package cn.nukkit.entity;

public interface EntitySwimmable {
    /**
     * @return 此实体是否会受到溺水伤害
     */
    default boolean canDrown() {
        return false;
    }
}
