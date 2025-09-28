package cn.nukkit.recipe;

import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.item.material.tags.ItemTags;
import cn.nukkit.recipe.impl.*;
import cn.nukkit.registry.Registries;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RecipeParser {
    public static void init() {
        loadRecipes(JsonParser.parseReader(new InputStreamReader(Server.class.getClassLoader().getResourceAsStream("recipes/recipes_827.json"))).getAsJsonObject().get("recipes").getAsJsonArray());
    }

    private static Item parseItem(JsonObject item) {
        final Item result;
        if(item.has("id")) {
            result = Registries.ITEM.get(item.get("id").getAsString());
        } else {
            result = Registries.ITEM.get(item.get("itemId").getAsString());
        }


        if(item.has("count")) {
            result.setCount(item.get("count").getAsInt());
        }

        int damage = 0;
        if(item.has("damage")) {
            damage = item.get("damage").getAsInt();
        }

        if(item.has("auxValue")) {
            damage = item.get("auxValue").getAsInt();
        }

        if(damage == 32767) damage = 0;
        result.setDamage(damage);

        return result;
    }

    private static ItemDescriptor parseInput(JsonObject input) {
        if(input.has("itemTag")) {
            return ItemTags.getTag(input.get("itemTag").getAsString());
        }
        return parseItem(input);
    }

    private static Item parseOutput(JsonElement output) {
        Item result;
        if (output.isJsonArray()) {
            JsonArray array = output.getAsJsonArray();
            if (array.size() > 1) {
                throw new RuntimeException("Aboba?");
            }
            result = parseItem(array.get(0).getAsJsonObject());
        } else {
            result = parseItem(output.getAsJsonObject());
        }
        return result;
    }

    private static void loadRecipes(JsonArray recipes) {
        recipes.forEach(json -> {
            final JsonObject recipe = json.getAsJsonObject();

            try {
                final int type = recipe.get("type").getAsInt();

                switch (type) {
                    case 3 -> {
                        final String block = recipe.get("block").getAsString();
                        switch (block) {
                            case "furnace", "deprecated" -> {
                                Registries.RECIPE_REGISTRY.addFurnace(new FurnaceRecipe(
                                        parseItem(recipe.get("output").getAsJsonObject()),
                                        parseItem(recipe.get("input").getAsJsonObject())
                                ));
                            }

                            case "blast_furnace" -> {
                                Registries.RECIPE_REGISTRY.addBlastFurnace(new BlastFurnaceRecipe(
                                        parseItem(recipe.get("output").getAsJsonObject()),
                                        parseItem(recipe.get("input").getAsJsonObject())
                                ));
                            }

                            case "campfire" -> {
                                Registries.RECIPE_REGISTRY.registerCampfireRecipe(new CampfireRecipe(
                                        parseItem(recipe.get("output").getAsJsonObject()),
                                        parseItem(recipe.get("input").getAsJsonObject())
                                ));
                            }

                            case "smoker" -> {
                            }
                            case "soul_campfire" -> {
                            }

                            default -> log.warn("Not support block type: {}", block);
                        }

                    }

                    case 1 -> {
                        final String block = recipe.get("block").getAsString();

                        switch (block) {
                            case "crafting_table", "deprecated" -> {
                                final String[] shape = new String[recipe.get("height").getAsInt()];
                                final JsonArray shapeJson = recipe.get("shape").getAsJsonArray();
                                for(int i = 0; i < shape.length; i++) {
                                    shape[i] = shapeJson.get(i).getAsString();
                                }

                                final Map<Character, ItemDescriptor> items = new HashMap<>();
                                final JsonObject input =  recipe.get("input").getAsJsonObject();

                                input.entrySet().forEach(entry -> {
                                   items.put(entry.getKey().charAt(0), parseInput(entry.getValue().getAsJsonObject()));
                                });

                                Registries.RECIPE_REGISTRY.registerShapedRecipe(new ShapedRecipe(
                                        recipe.get("id").getAsString(),
                                        recipe.get("priority").getAsInt(),
                                        parseOutput(recipe.get("output")),
                                        shape,
                                        items,
                                        new ArrayList<>()
                                ));
                            }
                        }
                    }

                    case 0 -> {
                        final String block = recipe.get("block").getAsString();

                        switch (block) {
                            case "crafting_table", "deprecated" -> {
                                final Collection<ItemDescriptor> inputs = new ArrayList<>();

                                recipe.getAsJsonArray("input").getAsJsonArray().forEach(item -> {
                                    inputs.add(parseInput(item.getAsJsonObject()));
                                });

                                Registries.RECIPE_REGISTRY.registerShapelessRecipe(new ShapelessRecipe(
                                        recipe.get("id").getAsString(),
                                        recipe.get("priority").getAsInt(),
                                        parseOutput(recipe.get("output")),
                                        inputs
                                ));
                            }

                            default -> log.warn("Not support block type: {}", block);
                        }
                    }

                    default -> log.warn("Unknown recipe type: {}", type);
                }
            } catch (Exception e) {
                log.warn("Failed to load recipe {}", recipe.get("id").toString());
            }
        });

        Registries.RECIPE_REGISTRY.rebuildPacket();
    }
}
