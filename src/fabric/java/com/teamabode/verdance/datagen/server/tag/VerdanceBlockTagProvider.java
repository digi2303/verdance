package com.teamabode.verdance.datagen.server.tag;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.core.registry.VerdanceBlocks;
import com.teamabode.verdance.core.tag.VerdanceBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class VerdanceBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public VerdanceBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        walls();
        planks();
        stairs();
        slabs();
        fences();
        fenceGates();
        doors();
        trapdoors();
        pressurePlates();
        buttons();
        signs();
        logs();
        saplings();
        leaves();
        flowerPots();
        maintainsFarmland();
        mineablePickaxe();
        mineableHoe();
        mineableAxe();
        swordEfficient();
        silkMothsSpawnableOn();
        replaceableBySugarCane();
        shrubs();
        floweringShrubs();
        shrubMayPlaceOn();
        flowers();
        smallFlowers();
        crops();
        cabinets();
    }

    private void cabinets() {
        builder(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("farmersdelight", "cabinets/wooden")))
                .addOptional(ResourceKey.create(Registries.BLOCK, Verdance.id("mulberry_cabinet")));
    }

    private void add(TagKey<Block> tag, Block... blocks) {
        TagAppender<ResourceKey<Block>, Block> appender = builder(tag);
        for (Block block : blocks) {
            appender.add(block.builtInRegistryHolder().key());
        }
    }

    private void mineablePickaxe() {
        add(BlockTags.MINEABLE_WITH_PICKAXE,
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
                VerdanceBlocks.PINK_STUCCO, VerdanceBlocks.PINK_STUCCO_STAIRS, VerdanceBlocks.PINK_STUCCO_SLAB, VerdanceBlocks.PINK_STUCCO_WALL);
    }

    private void mineableHoe() {
        add(BlockTags.MINEABLE_WITH_HOE, VerdanceBlocks.MULBERRY_LEAVES, VerdanceBlocks.FLOWERING_MULBERRY_LEAVES);
    }

    private void mineableAxe() {
        add(BlockTags.MINEABLE_WITH_AXE,
                VerdanceBlocks.CANTALOUPE,
                VerdanceBlocks.WHITE_CUSHION, VerdanceBlocks.LIGHT_GRAY_CUSHION, VerdanceBlocks.GRAY_CUSHION, VerdanceBlocks.BLACK_CUSHION,
                VerdanceBlocks.BROWN_CUSHION, VerdanceBlocks.RED_CUSHION, VerdanceBlocks.ORANGE_CUSHION, VerdanceBlocks.YELLOW_CUSHION,
                VerdanceBlocks.LIME_CUSHION, VerdanceBlocks.GREEN_CUSHION, VerdanceBlocks.CYAN_CUSHION, VerdanceBlocks.LIGHT_BLUE_CUSHION,
                VerdanceBlocks.BLUE_CUSHION, VerdanceBlocks.PURPLE_CUSHION, VerdanceBlocks.MAGENTA_CUSHION, VerdanceBlocks.PINK_CUSHION);
        builder(BlockTags.MINEABLE_WITH_AXE)
                .addOptional(ResourceKey.create(Registries.BLOCK, Verdance.id("mulberry_cabinet")))
                .addOptional(ResourceKey.create(Registries.BLOCK, Verdance.id("mulberry_crate")));
    }

    private void swordEfficient() {
        add(BlockTags.SWORD_EFFICIENT, VerdanceBlocks.CANTALOUPE);
    }

    private void walls() {
        add(BlockTags.WALLS,
                VerdanceBlocks.WHITE_STUCCO_WALL, VerdanceBlocks.LIGHT_GRAY_STUCCO_WALL, VerdanceBlocks.GRAY_STUCCO_WALL, VerdanceBlocks.BLACK_STUCCO_WALL,
                VerdanceBlocks.BROWN_STUCCO_WALL, VerdanceBlocks.RED_STUCCO_WALL, VerdanceBlocks.ORANGE_STUCCO_WALL, VerdanceBlocks.YELLOW_STUCCO_WALL,
                VerdanceBlocks.LIME_STUCCO_WALL, VerdanceBlocks.GREEN_STUCCO_WALL, VerdanceBlocks.CYAN_STUCCO_WALL, VerdanceBlocks.LIGHT_BLUE_STUCCO_WALL,
                VerdanceBlocks.BLUE_STUCCO_WALL, VerdanceBlocks.PURPLE_STUCCO_WALL, VerdanceBlocks.MAGENTA_STUCCO_WALL, VerdanceBlocks.PINK_STUCCO_WALL);
    }

    private void planks() {
        add(BlockTags.PLANKS, VerdanceBlocks.MULBERRY_PLANKS);
    }

    private void stairs() {
        add(BlockTags.STAIRS,
                VerdanceBlocks.WHITE_STUCCO_STAIRS, VerdanceBlocks.LIGHT_GRAY_STUCCO_STAIRS, VerdanceBlocks.GRAY_STUCCO_STAIRS, VerdanceBlocks.BLACK_STUCCO_STAIRS,
                VerdanceBlocks.BROWN_STUCCO_STAIRS, VerdanceBlocks.RED_STUCCO_STAIRS, VerdanceBlocks.ORANGE_STUCCO_STAIRS, VerdanceBlocks.YELLOW_STUCCO_STAIRS,
                VerdanceBlocks.LIME_STUCCO_STAIRS, VerdanceBlocks.GREEN_STUCCO_STAIRS, VerdanceBlocks.CYAN_STUCCO_STAIRS, VerdanceBlocks.LIGHT_BLUE_STUCCO_STAIRS,
                VerdanceBlocks.BLUE_STUCCO_STAIRS, VerdanceBlocks.PURPLE_STUCCO_STAIRS, VerdanceBlocks.MAGENTA_STUCCO_STAIRS, VerdanceBlocks.PINK_STUCCO_STAIRS);
        add(BlockTags.WOODEN_STAIRS, VerdanceBlocks.MULBERRY_STAIRS);
    }

    private void slabs() {
        add(BlockTags.SLABS,
                VerdanceBlocks.WHITE_STUCCO_SLAB, VerdanceBlocks.LIGHT_GRAY_STUCCO_SLAB, VerdanceBlocks.GRAY_STUCCO_SLAB, VerdanceBlocks.BLACK_STUCCO_SLAB,
                VerdanceBlocks.BROWN_STUCCO_SLAB, VerdanceBlocks.RED_STUCCO_SLAB, VerdanceBlocks.ORANGE_STUCCO_SLAB, VerdanceBlocks.YELLOW_STUCCO_SLAB,
                VerdanceBlocks.LIME_STUCCO_SLAB, VerdanceBlocks.GREEN_STUCCO_SLAB, VerdanceBlocks.CYAN_STUCCO_SLAB, VerdanceBlocks.LIGHT_BLUE_STUCCO_SLAB,
                VerdanceBlocks.BLUE_STUCCO_SLAB, VerdanceBlocks.PURPLE_STUCCO_SLAB, VerdanceBlocks.MAGENTA_STUCCO_SLAB, VerdanceBlocks.PINK_STUCCO_SLAB);
        add(BlockTags.WOODEN_SLABS, VerdanceBlocks.MULBERRY_SLAB);
    }

    private void fences() {
        add(BlockTags.WOODEN_FENCES, VerdanceBlocks.MULBERRY_FENCE);
    }

    private void fenceGates() {
        add(BlockTags.FENCE_GATES, VerdanceBlocks.MULBERRY_FENCE_GATE);
    }

    private void doors() {
        add(BlockTags.WOODEN_DOORS, VerdanceBlocks.MULBERRY_DOOR);
    }

    private void trapdoors() {
        add(BlockTags.WOODEN_TRAPDOORS, VerdanceBlocks.MULBERRY_TRAPDOOR);
    }

    private void pressurePlates() {
        add(BlockTags.WOODEN_PRESSURE_PLATES, VerdanceBlocks.MULBERRY_PRESSURE_PLATE);
    }

    private void buttons() {
        add(BlockTags.WOODEN_BUTTONS, VerdanceBlocks.MULBERRY_BUTTON);
    }

    private void signs() {
        add(BlockTags.STANDING_SIGNS, VerdanceBlocks.MULBERRY_SIGN);
        add(BlockTags.WALL_SIGNS, VerdanceBlocks.MULBERRY_WALL_SIGN);
        add(BlockTags.CEILING_HANGING_SIGNS, VerdanceBlocks.MULBERRY_HANGING_SIGN);
        add(BlockTags.WALL_HANGING_SIGNS, VerdanceBlocks.MULBERRY_WALL_HANGING_SIGN);
    }

    private void logs() {
        add(VerdanceBlockTags.MULBERRY_LOGS,
                VerdanceBlocks.MULBERRY_LOG, VerdanceBlocks.MULBERRY_WOOD, VerdanceBlocks.STRIPPED_MULBERRY_LOG, VerdanceBlocks.STRIPPED_MULBERRY_WOOD);
        builder(BlockTags.LOGS_THAT_BURN).addTag(VerdanceBlockTags.MULBERRY_LOGS);
        add(BlockTags.OVERWORLD_NATURAL_LOGS, VerdanceBlocks.MULBERRY_LOG);
    }

    private void saplings() {
        add(BlockTags.SAPLINGS, VerdanceBlocks.MULBERRY_SAPLING);
    }

    private void leaves() {
        add(BlockTags.LEAVES, VerdanceBlocks.MULBERRY_LEAVES, VerdanceBlocks.FLOWERING_MULBERRY_LEAVES);
    }

    private void flowerPots() {
        add(BlockTags.FLOWER_POTS,
                VerdanceBlocks.POTTED_MULBERRY_SAPLING, VerdanceBlocks.POTTED_VIOLET, VerdanceBlocks.POTTED_SHRUB,
                VerdanceBlocks.POTTED_YELLOW_FLOWERING_SHRUB, VerdanceBlocks.POTTED_PINK_FLOWERING_SHRUB);
    }

    private void maintainsFarmland() {
        add(BlockTags.MAINTAINS_FARMLAND, VerdanceBlocks.CANTALOUPE_STEM, VerdanceBlocks.ATTACHED_CANTALOUPE_STEM);
    }

    private void silkMothsSpawnableOn() {
        add(VerdanceBlockTags.SILK_MOTHS_SPAWNABLE_ON, VerdanceBlocks.MULBERRY_LEAVES, VerdanceBlocks.FLOWERING_MULBERRY_LEAVES, Blocks.GRASS_BLOCK);
    }

    private void replaceableBySugarCane() {
        builder(VerdanceBlockTags.REPLACEABLE_BY_SUGAR_CANE).addOptionalTag(BlockTags.REPLACEABLE);
        add(VerdanceBlockTags.REPLACEABLE_BY_SUGAR_CANE, Blocks.SUGAR_CANE);
    }

    private void shrubs() {
        add(VerdanceBlockTags.SHRUBS, VerdanceBlocks.SHRUB, VerdanceBlocks.YELLOW_FLOWERING_SHRUB, VerdanceBlocks.PINK_FLOWERING_SHRUB);
    }

    private void floweringShrubs() {
        add(VerdanceBlockTags.FLOWERING_SHRUBS, VerdanceBlocks.YELLOW_FLOWERING_SHRUB, VerdanceBlocks.PINK_FLOWERING_SHRUB);
    }

    private void shrubMayPlaceOn() {
        builder(VerdanceBlockTags.SHRUB_MAY_PLACE_ON)
                .addOptionalTag(BlockTags.DIRT)
                .addOptionalTag(BlockTags.SAND)
                .addOptionalTag(BlockTags.TERRACOTTA);
    }

    private void flowers() {
        builder(BlockTags.FLOWERS).addTag(VerdanceBlockTags.FLOWERING_SHRUBS);
    }

    private void smallFlowers() {
        add(BlockTags.SMALL_FLOWERS, VerdanceBlocks.VIOLET);
    }

    private void crops() {
        add(BlockTags.CROPS, VerdanceBlocks.CANTALOUPE_STEM);
    }
}
