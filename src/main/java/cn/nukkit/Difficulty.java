package cn.nukkit;

import lombok.Getter;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum Difficulty {
    PEACEFUL("Peaceful", "%options.difficulty.peaceful", "p", "0"),
    EASY("Easy", "%options.difficulty.easy", "e", "1"),
    NORMAL("Normal", "%options.difficulty.normal", "n", "2"),
    HARD("Hard", "%options.difficulty.hard", "h", "3");

    private static final Difficulty[] VALUES = values();
    private static final Map<String, Difficulty> BY_NAME = new HashMap<>();
    private static final Map<String, Difficulty> BY_ALIAS = new HashMap<>();

    private final String name;
    private final String translationKey;
    private final String[] aliases;

    Difficulty(String name, String translationKey, String... aliases) {
        this.name = name;
        this.translationKey = translationKey;
        this.aliases = aliases;
    }

    public String getLowerName() {
        return name.toLowerCase();
    }

    public int getId() {
        return this.ordinal();
    }

    public static @Nullable Difficulty byId(int id) {
        if (id < 0 || id >= VALUES.length) {
            return null;
        }
        return VALUES[id];
    }

    public static @Nullable Difficulty byName(String name) {
        Difficulty difficulty = BY_NAME.get(name.toLowerCase());
        if (difficulty == null) {
            return BY_ALIAS.get(name.toLowerCase());
        }
        return difficulty;
    }

    static {
        for (Difficulty difficulty : VALUES) {
            BY_NAME.put(difficulty.getLowerName(), difficulty);
            for (String alias : difficulty.aliases) {
                BY_ALIAS.put(alias, difficulty);
            }
        }
    }
}