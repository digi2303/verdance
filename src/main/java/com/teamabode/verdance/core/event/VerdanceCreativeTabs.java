package com.teamabode.verdance.core.event;

import com.teamabode.verdance.core.registry.VerdanceBlocks;
import com.teamabode.verdance.core.registry.VerdanceItems;
import com.teamabode.verdance.impl.platform.CommonAbstraction;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class VerdanceCreativeTabs {

    public static void register() {
        CommonAbstraction abstraction = CommonAbstraction.INSTANCE;

        abstraction.modifyCreativeTab(CreativeModeTabs.BUILDING_BLOCKS, entries -> entries.addAfter(
                Items.CHERRY_BUTTON,
                VerdanceBlocks.MULBERRY_LOG,
                VerdanceBlocks.MULBERRY_WOOD,
                VerdanceBlocks.STRIPPED_MULBERRY_LOG,
                VerdanceBlocks.STRIPPED_MULBERRY_WOOD,
                VerdanceBlocks.MULBERRY_PLANKS,
                VerdanceBlocks.MULBERRY_STAIRS,
                VerdanceBlocks.MULBERRY_SLAB,
                VerdanceBlocks.MULBERRY_FENCE,
                VerdanceBlocks.MULBERRY_FENCE_GATE,
                VerdanceBlocks.MULBERRY_DOOR,
                VerdanceBlocks.MULBERRY_TRAPDOOR,
                VerdanceBlocks.MULBERRY_PRESSURE_PLATE,
                VerdanceBlocks.MULBERRY_BUTTON
        ));
        abstraction.modifyCreativeTab(CreativeModeTabs.TOOLS_AND_UTILITIES, entries -> {
            entries.addAfter(Items.CHERRY_CHEST_BOAT, VerdanceItems.MULBERRY_BOAT, VerdanceItems.MULBERRY_CHEST_BOAT);
            entries.addAfter(Items.MUSIC_DISC_5, VerdanceItems.MUSIC_DISC_RANGE);
        });
        abstraction.modifyCreativeTab(CreativeModeTabs.FUNCTIONAL_BLOCKS, entries -> {
            entries.addAfter(Items.CHERRY_HANGING_SIGN, VerdanceItems.MULBERRY_SIGN, VerdanceItems.MULBERRY_HANGING_SIGN);
            entries.addAfter(
//? if >=26.2 {
                    /*Items.BED.pick(net.minecraft.world.item.DyeColor.PINK),
*///?} else {
                    Items.PINK_BED,
//?}
                    VerdanceBlocks.WHITE_CUSHION,
                    VerdanceBlocks.LIGHT_GRAY_CUSHION,
                    VerdanceBlocks.GRAY_CUSHION,
                    VerdanceBlocks.BLACK_CUSHION,
                    VerdanceBlocks.BROWN_CUSHION,
                    VerdanceBlocks.RED_CUSHION,
                    VerdanceBlocks.ORANGE_CUSHION,
                    VerdanceBlocks.YELLOW_CUSHION,
                    VerdanceBlocks.LIME_CUSHION,
                    VerdanceBlocks.GREEN_CUSHION,
                    VerdanceBlocks.CYAN_CUSHION,
                    VerdanceBlocks.LIGHT_BLUE_CUSHION,
                    VerdanceBlocks.BLUE_CUSHION,
                    VerdanceBlocks.PURPLE_CUSHION,
                    VerdanceBlocks.MAGENTA_CUSHION,
                    VerdanceBlocks.PINK_CUSHION
            );
        });
        abstraction.modifyCreativeTab(CreativeModeTabs.FOOD_AND_DRINKS, entries -> {
            entries.addAfter(Items.GLOW_BERRIES, VerdanceItems.MULBERRY);
            entries.addAfter(Items.MELON_SLICE, VerdanceItems.CANTALOUPE_SLICE, VerdanceItems.GRILLED_CANTALOUPE_SLICE);
            entries.addAfter(Items.HONEY_BOTTLE, VerdanceItems.CANTALOUPE_JUICE);
        });
        abstraction.modifyCreativeTab(CreativeModeTabs.NATURAL_BLOCKS, entries -> {
            entries.addAfter(Items.CHERRY_LOG, VerdanceBlocks.MULBERRY_LOG);
            entries.addAfter(Items.MELON, VerdanceBlocks.CANTALOUPE);
            entries.addAfter(Items.MELON_SEEDS, VerdanceItems.CANTALOUPE_SEEDS);
            entries.addAfter(Items.CHERRY_LEAVES, VerdanceBlocks.MULBERRY_LEAVES, VerdanceBlocks.FLOWERING_MULBERRY_LEAVES);
            entries.addAfter(Items.CHERRY_SAPLING, VerdanceItems.MULBERRY);
            entries.addAfter(Items.FROGSPAWN, VerdanceBlocks.SILKWORM_EGGS);
            entries.addAfter(Items.CORNFLOWER, VerdanceBlocks.VIOLET);
            entries.addAfter(Items.DEAD_BUSH, VerdanceBlocks.SHRUB, VerdanceBlocks.YELLOW_FLOWERING_SHRUB, VerdanceBlocks.PINK_FLOWERING_SHRUB);
        });
        abstraction.modifyCreativeTab(CreativeModeTabs.COLORED_BLOCKS, entries -> {
            entries.addAfter(
//? if >=26.2 {
                    /*Items.DYED_TERRACOTTA.pick(net.minecraft.world.item.DyeColor.PINK),
*///?} else {
                    Items.PINK_TERRACOTTA,
//?}
                    VerdanceBlocks.WHITE_STUCCO, VerdanceBlocks.WHITE_STUCCO_STAIRS, VerdanceBlocks.WHITE_STUCCO_SLAB, VerdanceBlocks.WHITE_STUCCO_WALL,
                    VerdanceBlocks.LIGHT_GRAY_STUCCO, VerdanceBlocks.LIGHT_GRAY_STUCCO_STAIRS, VerdanceBlocks.LIGHT_GRAY_STUCCO_SLAB, VerdanceBlocks.LIGHT_GRAY_STUCCO_WALL,
                    VerdanceBlocks.GRAY_STUCCO, VerdanceBlocks.GRAY_STUCCO_STAIRS, VerdanceBlocks.GRAY_STUCCO_SLAB, VerdanceBlocks.GRAY_STUCCO_WALL,
                    VerdanceBlocks.BLACK_STUCCO, VerdanceBlocks.BLACK_STUCCO_STAIRS, VerdanceBlocks.BLACK_STUCCO_SLAB, VerdanceBlocks.BLACK_STUCCO_WALL,
                    VerdanceBlocks.BROWN_STUCCO, VerdanceBlocks.BROWN_STUCCO_STAIRS, VerdanceBlocks.BROWN_STUCCO_SLAB, VerdanceBlocks.BROWN_STUCCO_WALL,
                    VerdanceBlocks.RED_STUCCO, VerdanceBlocks.RED_STUCCO_STAIRS, VerdanceBlocks.RED_STUCCO_SLAB, VerdanceBlocks.RED_STUCCO_WALL,
                    VerdanceBlocks.ORANGE_STUCCO, VerdanceBlocks.ORANGE_STUCCO_STAIRS, VerdanceBlocks.ORANGE_STUCCO_SLAB, VerdanceBlocks.ORANGE_STUCCO_WALL,
                    VerdanceBlocks.YELLOW_STUCCO, VerdanceBlocks.YELLOW_STUCCO_STAIRS, VerdanceBlocks.YELLOW_STUCCO_SLAB, VerdanceBlocks.YELLOW_STUCCO_WALL,
                    VerdanceBlocks.LIME_STUCCO, VerdanceBlocks.LIME_STUCCO_STAIRS, VerdanceBlocks.LIME_STUCCO_SLAB, VerdanceBlocks.LIME_STUCCO_WALL,
                    VerdanceBlocks.GREEN_STUCCO, VerdanceBlocks.GREEN_STUCCO_STAIRS, VerdanceBlocks.GREEN_STUCCO_SLAB, VerdanceBlocks.GREEN_STUCCO_WALL,
                    VerdanceBlocks.CYAN_STUCCO, VerdanceBlocks.CYAN_STUCCO_STAIRS, VerdanceBlocks.CYAN_STUCCO_SLAB, VerdanceBlocks.CYAN_STUCCO_WALL,
                    VerdanceBlocks.LIGHT_BLUE_STUCCO, VerdanceBlocks.LIGHT_BLUE_STUCCO_STAIRS, VerdanceBlocks.LIGHT_BLUE_STUCCO_SLAB, VerdanceBlocks.LIGHT_BLUE_STUCCO_WALL,
                    VerdanceBlocks.BLUE_STUCCO, VerdanceBlocks.BLUE_STUCCO_STAIRS, VerdanceBlocks.BLUE_STUCCO_SLAB, VerdanceBlocks.BLUE_STUCCO_WALL,
                    VerdanceBlocks.PURPLE_STUCCO, VerdanceBlocks.PURPLE_STUCCO_STAIRS, VerdanceBlocks.PURPLE_STUCCO_SLAB, VerdanceBlocks.PURPLE_STUCCO_WALL,
                    VerdanceBlocks.MAGENTA_STUCCO, VerdanceBlocks.MAGENTA_STUCCO_STAIRS, VerdanceBlocks.MAGENTA_STUCCO_SLAB, VerdanceBlocks.MAGENTA_STUCCO_WALL,
                    VerdanceBlocks.PINK_STUCCO, VerdanceBlocks.PINK_STUCCO_STAIRS, VerdanceBlocks.PINK_STUCCO_SLAB, VerdanceBlocks.PINK_STUCCO_WALL
            );
            entries.addAfter(
//? if >=26.2 {
                    /*Items.BED.pick(net.minecraft.world.item.DyeColor.PINK),
*///?} else {
                    Items.PINK_BED,
//?}
                    VerdanceBlocks.WHITE_CUSHION,
                    VerdanceBlocks.LIGHT_GRAY_CUSHION,
                    VerdanceBlocks.GRAY_CUSHION,
                    VerdanceBlocks.BLACK_CUSHION,
                    VerdanceBlocks.BROWN_CUSHION,
                    VerdanceBlocks.RED_CUSHION,
                    VerdanceBlocks.ORANGE_CUSHION,
                    VerdanceBlocks.YELLOW_CUSHION,
                    VerdanceBlocks.LIME_CUSHION,
                    VerdanceBlocks.GREEN_CUSHION,
                    VerdanceBlocks.CYAN_CUSHION,
                    VerdanceBlocks.LIGHT_BLUE_CUSHION,
                    VerdanceBlocks.BLUE_CUSHION,
                    VerdanceBlocks.PURPLE_CUSHION,
                    VerdanceBlocks.MAGENTA_CUSHION,
                    VerdanceBlocks.PINK_CUSHION
            );
        });
        abstraction.modifyCreativeTab(CreativeModeTabs.REDSTONE_BLOCKS, entries -> entries.addAfter(Items.CAULDRON, VerdanceBlocks.WHITE_CUSHION));
        abstraction.modifyCreativeTab(CreativeModeTabs.INGREDIENTS, entries -> {
            entries.addAfter(Items.DISC_FRAGMENT_5, VerdanceItems.DISC_FRAGMENT_RANGE);
            entries.addAfter(Items.ANGLER_POTTERY_SHERD, VerdanceItems.ABODE_POTTERY_SHERD);
            entries.addAfter(Items.FRIEND_POTTERY_SHERD, VerdanceItems.FRILLS_POTTERY_SHERD);
            entries.addAfter(Items.PLENTY_POTTERY_SHERD, VerdanceItems.PITCH_POTTERY_SHERD);
            entries.addAfter(Items.PRIZE_POTTERY_SHERD, VerdanceItems.PRICKLE_POTTERY_SHERD);
            entries.addAfter(Items.SNORT_POTTERY_SHERD, VerdanceItems.SPIRIT_POTTERY_SHERD, VerdanceItems.TRAP_POTTERY_SHERD);
            entries.addAfter(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, VerdanceItems.HERITAGE_ARMOR_TRIM_SMITHING_TEMPLATE);
        });
        abstraction.modifyCreativeTab(CreativeModeTabs.SPAWN_EGGS, entries -> entries.addAfter(
                Items.SILVERFISH_SPAWN_EGG,
                VerdanceItems.SILK_MOTH_SPAWN_EGG,
                VerdanceItems.SILKWORM_SPAWN_EGG
        ));
    }
}
