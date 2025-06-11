package cn.nukkit.plugin;

import cn.nukkit.event.Event;

@FunctionalInterface
public interface NonReflectionEventConsumer<T extends Event> {
    void execute(T event);
}
