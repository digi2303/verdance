package com.teamabode.verdance.datagen.server;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.core.registry.VerdanceBlocks;
import com.teamabode.verdance.core.registry.VerdanceItems;
import com.teamabode.verdance.core.registry.VerdanceTrimPatterns;
import com.teamabode.verdance.core.tag.VerdanceItemTags;
import com.teamabode.verdance.datagen.VerdanceBlockFamilies;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class VerdanceRecipeGenerator extends RecipeProvider {

    public VerdanceRecipeGenerator(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    public void buildRecipes() {
        VerdanceBlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateCraftingRecipe).forEach(family -> this.generateRecipes(family, FeatureFlagSet.of(FeatureFlags.VANILLA)));
        this.woodFromLogs(VerdanceBlocks.MULBERRY_WOOD, VerdanceBlocks.MULBERRY_LOG);
        this.woodFromLogs(VerdanceBlocks.STRIPPED_MULBERRY_WOOD, VerdanceBlocks.STRIPPED_MULBERRY_LOG);
        this.planksFromLog(VerdanceBlocks.MULBERRY_PLANKS, VerdanceItemTags.MULBERRY_LOGS, 4);

        this.woodenBoat(VerdanceItems.MULBERRY_BOAT, VerdanceBlocks.MULBERRY_PLANKS);
        this.chestBoat(VerdanceItems.MULBERRY_CHEST_BOAT, VerdanceItems.MULBERRY_BOAT);

        cantaloupe();
        this.hangingSign(VerdanceItems.MULBERRY_HANGING_SIGN, VerdanceBlocks.STRIPPED_MULBERRY_LOG);

        stucco(VerdanceBlockFamilies.WHITE_STUCCO, ConventionalItemTags.WHITE_DYES);
        stucco(VerdanceBlockFamilies.LIGHT_GRAY_STUCCO, ConventionalItemTags.LIGHT_GRAY_DYES);
        stucco(VerdanceBlockFamilies.GRAY_STUCCO, ConventionalItemTags.GRAY_DYES);
        stucco(VerdanceBlockFamilies.BLACK_STUCCO, ConventionalItemTags.BLACK_DYES);
        stucco(VerdanceBlockFamilies.BROWN_STUCCO, ConventionalItemTags.BROWN_DYES);
        stucco(VerdanceBlockFamilies.RED_STUCCO, ConventionalItemTags.RED_DYES);
        stucco(VerdanceBlockFamilies.ORANGE_STUCCO, ConventionalItemTags.ORANGE_DYES);
        stucco(VerdanceBlockFamilies.YELLOW_STUCCO, ConventionalItemTags.YELLOW_DYES);
        stucco(VerdanceBlockFamilies.LIME_STUCCO, ConventionalItemTags.LIME_DYES);
        stucco(VerdanceBlockFamilies.GREEN_STUCCO, ConventionalItemTags.GREEN_DYES);
        stucco(VerdanceBlockFamilies.CYAN_STUCCO, ConventionalItemTags.CYAN_DYES);
        stucco(VerdanceBlockFamilies.LIGHT_BLUE_STUCCO, ConventionalItemTags.LIGHT_BLUE_DYES);
        stucco(VerdanceBlockFamilies.BLUE_STUCCO, ConventionalItemTags.BLUE_DYES);
        stucco(VerdanceBlockFamilies.PURPLE_STUCCO, ConventionalItemTags.PURPLE_DYES);
        stucco(VerdanceBlockFamilies.MAGENTA_STUCCO, ConventionalItemTags.MAGENTA_DYES);
        stucco(VerdanceBlockFamilies.PINK_STUCCO, ConventionalItemTags.PINK_DYES);

        cushion(VerdanceBlocks.WHITE_CUSHION, Blocks.WHITE_WOOL);
        cushion(VerdanceBlocks.LIGHT_GRAY_CUSHION, Blocks.LIGHT_GRAY_WOOL);
        cushion(VerdanceBlocks.GRAY_CUSHION, Blocks.GRAY_WOOL);
        cushion(VerdanceBlocks.BLACK_CUSHION, Blocks.BLACK_WOOL);
        cushion(VerdanceBlocks.BROWN_CUSHION, Blocks.BROWN_WOOL);
        cushion(VerdanceBlocks.RED_CUSHION, Blocks.RED_WOOL);
        cushion(VerdanceBlocks.ORANGE_CUSHION, Blocks.ORANGE_WOOL);
        cushion(VerdanceBlocks.YELLOW_CUSHION, Blocks.YELLOW_WOOL);
        cushion(VerdanceBlocks.LIME_CUSHION, Blocks.LIME_WOOL);
        cushion(VerdanceBlocks.GREEN_CUSHION, Blocks.GREEN_WOOL);
        cushion(VerdanceBlocks.CYAN_CUSHION, Blocks.CYAN_WOOL);
        cushion(VerdanceBlocks.LIGHT_BLUE_CUSHION, Blocks.LIGHT_BLUE_WOOL);
        cushion(VerdanceBlocks.BLUE_CUSHION, Blocks.BLUE_WOOL);
        cushion(VerdanceBlocks.PURPLE_CUSHION, Blocks.PURPLE_WOOL);
        cushion(VerdanceBlocks.MAGENTA_CUSHION, Blocks.MAGENTA_WOOL);
        cushion(VerdanceBlocks.PINK_CUSHION, Blocks.PINK_WOOL);

        List<TagKey<Item>> dyes = List.of(
                ConventionalItemTags.BLACK_DYES,
                ConventionalItemTags.BLUE_DYES,
                ConventionalItemTags.BROWN_DYES,
                ConventionalItemTags.CYAN_DYES,
                ConventionalItemTags.GRAY_DYES,
                ConventionalItemTags.GREEN_DYES,
                ConventionalItemTags.LIGHT_BLUE_DYES,
                ConventionalItemTags.LIGHT_GRAY_DYES,
                ConventionalItemTags.LIME_DYES,
                ConventionalItemTags.MAGENTA_DYES,
                ConventionalItemTags.ORANGE_DYES,
                ConventionalItemTags.PINK_DYES,
                ConventionalItemTags.PURPLE_DYES,
                ConventionalItemTags.RED_DYES,
                ConventionalItemTags.YELLOW_DYES,
                ConventionalItemTags.WHITE_DYES
        );
        List<ItemLike> cushions = List.of(
                VerdanceBlocks.BLACK_CUSHION,
                VerdanceBlocks.BLUE_CUSHION,
                VerdanceBlocks.BROWN_CUSHION,
                VerdanceBlocks.CYAN_CUSHION,
                VerdanceBlocks.GRAY_CUSHION,
                VerdanceBlocks.GREEN_CUSHION,
                VerdanceBlocks.LIGHT_BLUE_CUSHION,
                VerdanceBlocks.LIGHT_GRAY_CUSHION,
                VerdanceBlocks.LIME_CUSHION,
                VerdanceBlocks.MAGENTA_CUSHION,
                VerdanceBlocks.ORANGE_CUSHION,
                VerdanceBlocks.PINK_CUSHION,
                VerdanceBlocks.PURPLE_CUSHION,
                VerdanceBlocks.RED_CUSHION,
                VerdanceBlocks.YELLOW_CUSHION,
                VerdanceBlocks.WHITE_CUSHION
        );
        offerDyeableRecipes(RecipeCategory.BUILDING_BLOCKS, dyes, cushions, "cushion");
        dyeFromFlower(Items.PURPLE_DYE, VerdanceBlocks.VIOLET, 1);
        dyeFromFlower(Items.MAGENTA_DYE, Blocks.SPORE_BLOSSOM, 2);
        dyeFromFlower(Items.YELLOW_DYE, VerdanceBlocks.YELLOW_FLOWERING_SHRUB, 1);
        dyeFromFlower(Items.PINK_DYE, VerdanceBlocks.PINK_FLOWERING_SHRUB, 1);
    }

    private void stucco(BlockFamily family, TagKey<Item> dye) {
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, family.getBaseBlock(), 8).requires(dye).requires(Items.CLAY, 4).requires(Ingredient.of(this.registries.lookupOrThrow(Registries.ITEM).getOrThrow(ItemTags.SAND)), 4).group("stucco").unlockedBy(getHasName(Items.CLAY), this.has(Items.CLAY)).unlockedBy("has_sand", this.has(ItemTags.SAND)).save(this.output);

        stonecutter(RecipeCategory.BUILDING_BLOCKS, family.get(BlockFamily.Variant.STAIRS), family.getBaseBlock(), 1);
        stonecutter(RecipeCategory.BUILDING_BLOCKS, family.get(BlockFamily.Variant.SLAB), family.getBaseBlock(), 2);
        stonecutter(RecipeCategory.MISC, family.get(BlockFamily.Variant.WALL), family.getBaseBlock(), 1);
    }

    private void cantaloupe() {
        this.twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, VerdanceBlocks.CANTALOUPE, VerdanceItems.CANTALOUPE_SLICE);

        this.shapeless(RecipeCategory.MISC, VerdanceItems.CANTALOUPE_SEEDS).requires(VerdanceItems.CANTALOUPE_SLICE).unlockedBy(getHasName(VerdanceItems.CANTALOUPE_SLICE), this.has(VerdanceItems.CANTALOUPE_SLICE)).save(this.output);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(VerdanceItems.CANTALOUPE_SLICE), RecipeCategory.FOOD, CookingBookCategory.FOOD, VerdanceItems.GRILLED_CANTALOUPE_SLICE, 0.25f, 200).unlockedBy("has_cantaloupe_slice", this.has(VerdanceItems.CANTALOUPE_SLICE)).save(this.output);
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(VerdanceItems.CANTALOUPE_SLICE), RecipeCategory.FOOD, VerdanceItems.GRILLED_CANTALOUPE_SLICE, 0.25f, 100).unlockedBy("has_cantaloupe_slice", this.has(VerdanceItems.CANTALOUPE_SLICE)).save(this.output, recipeKey("grilled_cantaloupe_slice_from_smoking"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(VerdanceItems.CANTALOUPE_SLICE), RecipeCategory.FOOD, VerdanceItems.GRILLED_CANTALOUPE_SLICE, 0.25f, 600).unlockedBy("has_cantaloupe_slice", this.has(VerdanceItems.CANTALOUPE_SLICE)).save(this.output, recipeKey("grilled_cantaloupe_slice_from_campfire_cooking"));
        this.shapeless(RecipeCategory.FOOD, VerdanceItems.CANTALOUPE_JUICE).requires(VerdanceItems.CANTALOUPE_SLICE, 4).requires(Items.SUGAR).requires(Items.GLASS_BOTTLE).unlockedBy("has_cantaloupe_slice", this.has(VerdanceItems.CANTALOUPE_SLICE)).unlockedBy("has_sugar", this.has(Items.SUGAR)).unlockedBy("has_glass_bottle", this.has(Items.GLASS_BOTTLE)).save(this.output);
        this.threeByThreePacker(RecipeCategory.MISC, VerdanceItems.MUSIC_DISC_RANGE, VerdanceItems.DISC_FRAGMENT_RANGE);

        this.copySmithingTemplate(VerdanceItems.HERITAGE_ARMOR_TRIM_SMITHING_TEMPLATE, VerdanceBlocks.WHITE_STUCCO);
        this.trimSmithing(VerdanceItems.HERITAGE_ARMOR_TRIM_SMITHING_TEMPLATE, VerdanceTrimPatterns.HERITAGE, recipeKey(getItemName(VerdanceItems.HERITAGE_ARMOR_TRIM_SMITHING_TEMPLATE) + "_smithing_trim"));
    }

    private void offerDyeableRecipes(RecipeCategory category, List<TagKey<Item>> dyes, List<ItemLike> dyeables, String group) {
        for (int i = 0; i < dyes.size(); ++i) {
            TagKey<Item> dye = dyes.get(i);
            final ItemLike item = dyeables.get(i);
            this.shapeless(category, item).requires(dye).requires(Ingredient.of(dyeables.stream().filter(dyeable -> !dyeable.equals(item)))).group(group).unlockedBy("has_needed_dye", this.has(dye)).save(this.output, recipeKey("dye_" + getItemName(item)));
        }
    }

    private void stonecutter(RecipeCategory category, ItemLike result, ItemLike material, int resultCount) {
        this.stonecutterResultFromBase(category, result, material, resultCount);
    }

    private void cushion(ItemLike cushion, ItemLike wool) {
        this.shaped(RecipeCategory.DECORATIONS, cushion, 2).unlockedBy(getHasName(wool), this.has(wool)).define('W', wool).define('#', ItemTags.PLANKS).pattern("WW").pattern("##").group("cushion").save(this.output);
    }

    private void dyeFromFlower(Item dye, Block flower, int count) {
        this.shapeless(RecipeCategory.MISC, dye, count).requires(flower).unlockedBy(getHasName(flower), this.has(flower)).group(getItemName(dye)).save(this.output, recipeKey(getConversionRecipeName(dye, flower)));
    }

    private static ResourceKey<Recipe<?>> recipeKey(String path) {
        return ResourceKey.create(Registries.RECIPE, Verdance.id(path));
    }
}
