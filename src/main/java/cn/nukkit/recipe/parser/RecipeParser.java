package cn.nukkit.recipe.parser;

import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.item.material.tags.ItemTags;
import cn.nukkit.recipe.ItemDescriptor;
import cn.nukkit.recipe.impl.*;
import cn.nukkit.recipe.impl.special.*;
import cn.nukkit.registry.Registries;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStreamReader;
import java.util.*;

@Slf4j
public class RecipeParser {
    public static void init() {
        Registries.RECIPE.registerMultiRecipe(new RepairItemRecipe());
        Registries.RECIPE.registerMultiRecipe(new BookCloningRecipe());
        Registries.RECIPE.registerMultiRecipe(new MapCloningRecipe());
        Registries.RECIPE.registerMultiRecipe(new MapUpgradingRecipe());
        Registries.RECIPE.registerMultiRecipe(new MapExtendingRecipe());
        Registries.RECIPE.registerMultiRecipe(new BannerAddPatternRecipe());
        Registries.RECIPE.registerMultiRecipe(new BannerDuplicateRecipe());
        Registries.RECIPE.registerMultiRecipe(new FireworkRecipe());
        Registries.RECIPE.registerMultiRecipe(new DecoratedPotRecipe());

        loadRecipes(JsonParser.parseReader(new InputStreamReader(Server.class.getClassLoader().getResourceAsStream("recipes/recipes_827.json"))).getAsJsonObject().get("recipes").getAsJsonArray());
    }

    private static Item parseItem(JsonObject item) {
        if(item.has("type") && item.get("type").getAsString().equals("complex_alias")) {
            throw new ComplexAliasException();
        }

        final Item result;
        if(item.has("id")) {
            result = Registries.ITEM.get(item.get("id").getAsString()).clone();
        } else {
            result = Registries.ITEM.get(item.get("itemId").getAsString()).clone();
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

        if(damage != 32767) result.setDamage(damage);

        return result;
    }

    private static ItemDescriptor parseInput(JsonObject input) {
        if(input.has("itemTag")) {
            return ItemTags.getTag(input.get("itemTag").getAsString());
        }
        return parseItem(input);
    }

    private static Item parseOutput(JsonElement output, List<Item> extra) {
        Item result;
        if (output.isJsonArray()) {
            JsonArray array = output.getAsJsonArray();
            if (array.isEmpty()) {
                throw new RuntimeException("Aboba?");
            }

            for(int i = 1; i < array.size(); ++i) {
                extra.add(parseItem(array.get(i).getAsJsonObject()));
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
                    case 4, 9 -> {}

                    case 3 -> {
                        final String block = recipe.get("block").getAsString();
                        switch (block) {
                            case "furnace", "deprecated" -> {
                                Registries.RECIPE.addFurnace(new FurnaceRecipe(
                                        parseItem(recipe.get("output").getAsJsonObject()),
                                        parseItem(recipe.get("input").getAsJsonObject())
                                ));
                            }

                            case "blast_furnace" -> {
                                Registries.RECIPE.addBlastFurnace(new BlastFurnaceRecipe(
                                        parseItem(recipe.get("output").getAsJsonObject()),
                                        parseItem(recipe.get("input").getAsJsonObject())
                                ));
                            }

                            case "campfire" -> {
                                Registries.RECIPE.registerCampfireRecipe(new CampfireRecipe(
                                        parseItem(recipe.get("output").getAsJsonObject()),
                                        parseItem(recipe.get("input").getAsJsonObject())
                                ));
                            }

                            case "stonecutter", "smoker", "soul_campfire" -> {
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

                                final List<Item> extra = new ArrayList<>();
                                Registries.RECIPE.registerShapedRecipe(new ShapedRecipe(
                                        recipe.get("id").getAsString(),
                                        recipe.get("priority").getAsInt(),
                                        parseOutput(recipe.get("output"), extra),
                                        shape,
                                        items,
                                        extra
                                ));
                            }
                        }
                    }

                    case 8 -> {
                        final String block = recipe.get("block").getAsString();
                        switch (block) {
                            case "smithing_table" -> {
                                Registries.RECIPE.registerSmithingRecipe(new SmithingRecipe(
                                        recipe.get("id").getAsString(),
                                        0,
                                        List.of(
                                                parseItem(recipe.get("base").getAsJsonObject()),
                                                parseItem(recipe.get("addition").getAsJsonObject()),
                                                parseItem(recipe.get("template").getAsJsonObject())
                                        ),
                                        parseItem(recipe.get("result").getAsJsonObject())
                                ));
                            }
                            default -> log.warn("Not support block type: {}", block);
                        }
                    }

                    case 0, 5 -> {
                        final String block = recipe.get("block").getAsString();

                        switch (block) {
                            case "crafting_table", "deprecated" -> {
                                final Collection<ItemDescriptor> inputs = new ArrayList<>();

                                recipe.getAsJsonArray("input").getAsJsonArray().forEach(item -> {
                                    inputs.add(parseInput(item.getAsJsonObject()));
                                });

                                Registries.RECIPE.registerShapelessRecipe(new ShapelessRecipe(
                                        recipe.get("id").getAsString(),
                                        recipe.get("priority").getAsInt(),
                                        parseOutput(recipe.get("output"), List.of()),
                                        inputs
                                ));
                            }

                            case "stonecutter", "cartography_table" -> {
                            }

                            default -> log.warn("Not support block type: {}", block);
                        }
                    }

                    default -> log.warn("Unknown recipe type: {}", type);
                }
            } catch (Exception e) {
                if(!(e instanceof ComplexAliasException)) {
                    log.error("Failed to load recipe {}", recipe.get("id").toString());
                }
            }
        });

        Registries.RECIPE.rebuildPacket();
    }
}
