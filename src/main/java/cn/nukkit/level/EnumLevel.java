package cn.nukkit.level;

import cn.nukkit.Server;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.math.Vector3;

/**
 * Default dimensions and their Levels
 */
public enum EnumLevel {
    OVERWORLD,
    NETHER,
    THE_END;

    Level level;

    /**
     * Get Level
     *
     * @return Level or null if the dimension is not enabled
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Internal: Initialize default overworld, nether and the end Levels
     */
    public static void initLevels() {
        Server server = Server.getInstance();

        OVERWORLD.level = server.getDefaultLevel();
        if (server.getSettings().getWorld().isEnableNether()) {
            if (server.getLevelByName("nether") == null) {
                server.generateLevel("nether", System.currentTimeMillis(), Generator.getGenerator(Generator.TYPE_NETHER));
                server.loadLevel("nether");
            }
            NETHER.level = server.getLevelByName("nether");
            if (server.getSettings().getWorld().isEnableEnd()) {
                if (server.getLevelByName("the_end") == null) {
                    server.generateLevel("the_end", System.currentTimeMillis(), Generator.getGenerator(Generator.TYPE_THE_END));
                    server.loadLevel("the_end");
                    server.getLevelByName("the_end").setSpawnLocation(new Vector3(100.5, 49, 0.5));
                }
                THE_END.level = server.getLevelByName("the_end");
            }
        }
    }
}