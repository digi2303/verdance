package com.teamabode.verdance.datagen.server.tag;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.core.registry.VerdanceBlocks;
import com.teamabode.verdance.core.registry.VerdanceItems;
import com.teamabode.verdance.core.tag.VerdanceItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class VerdanceItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

    public VerdanceItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        silkMothFood();
        silkwormFood();
        planks();
        stairs();
        slabs();
        walls();
        fences();
        fenceGates();
        doors();
        trapdoors();
        pressurePlates();
        buttons();
        signs();
        logs();
        boats();
        foods();
        decoratedPotSherds();
        saplings();
        leaves();
        flowers();
        smallFlowers();
        cabinets();
    }

    private void cabinets() {
        builder(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("farmersdelight", "cabinets/wooden")))
                .addOptional(ResourceKey.create(Registries.ITEM, Verdance.id("mulberry_cabinet")));
    }

    private void add(TagKey<Item> tag, ItemLike... items) {
        TagAppender<ResourceKey<Item>, Item> appender = builder(tag);
        for (ItemLike item : items) {
            appender.add(item.asItem().builtInRegistryHolder().key());
        }
    }

    private void silkMothFood() {
        builder(VerdanceItemTags.SILK_MOTH_FOOD).addOptionalTag(ItemTags.FLOWERS);
    }

    private void silkwormFood() {
        add(VerdanceItemTags.SILKWORM_FOOD, VerdanceItems.MULBERRY);
        builder(VerdanceItemTags.SILKWORM_FOOD).addOptionalTag(ItemTags.LEAVES);
    }

    private void planks() {
        add(ItemTags.PLANKS, VerdanceBlocks.MULBERRY_PLANKS);
    }

    private void stairs() {
        add(ItemTags.STAIRS,
                VerdanceBlocks.WHITE_STUCCO_STAIRS, VerdanceBlocks.LIGHT_GRAY_STUCCO_STAIRS, VerdanceBlocks.GRAY_STUCCO_STAIRS, VerdanceBlocks.BLACK_STUCCO_STAIRS,
                VerdanceBlocks.BROWN_STUCCO_STAIRS, VerdanceBlocks.RED_STUCCO_STAIRS, VerdanceBlocks.ORANGE_STUCCO_STAIRS);
        add(ItemTags.WOODEN_STAIRS, VerdanceBlocks.MULBERRY_STAIRS);
    }

    private void slabs() {
        add(ItemTags.SLABS,
                VerdanceBlocks.WHITE_STUCCO_SLAB, VerdanceBlocks.LIGHT_GRAY_STUCCO_SLAB, VerdanceBlocks.GRAY_STUCCO_SLAB, VerdanceBlocks.BLACK_STUCCO_SLAB,
                VerdanceBlocks.BROWN_STUCCO_SLAB, VerdanceBlocks.RED_STUCCO_SLAB, VerdanceBlocks.ORANGE_STUCCO_SLAB);
        add(ItemTags.WOODEN_SLABS, VerdanceBlocks.MULBERRY_SLAB);
    }

    private void walls() {
        add(ItemTags.WALLS,
                VerdanceBlocks.WHITE_STUCCO_WALL, VerdanceBlocks.LIGHT_GRAY_STUCCO_WALL, VerdanceBlocks.GRAY_STUCCO_WALL, VerdanceBlocks.BLACK_STUCCO_WALL,
                VerdanceBlocks.BROWN_STUCCO_WALL, VerdanceBlocks.RED_STUCCO_WALL, VerdanceBlocks.ORANGE_STUCCO_WALL);
    }

    private void fences() {
        add(ItemTags.WOODEN_FENCES, VerdanceBlocks.MULBERRY_FENCE);
    }

    private void fenceGates() {
        add(ItemTags.FENCE_GATES, VerdanceBlocks.MULBERRY_FENCE_GATE);
    }

    private void doors() {
        add(ItemTags.WOODEN_DOORS, VerdanceBlocks.MULBERRY_DOOR);
    }

    private void trapdoors() {
        add(ItemTags.WOODEN_TRAPDOORS, VerdanceBlocks.MULBERRY_TRAPDOOR);
    }

    private void pressurePlates() {
        add(ItemTags.WOODEN_PRESSURE_PLATES, VerdanceBlocks.MULBERRY_PRESSURE_PLATE);
    }

    private void buttons() {
        add(ItemTags.WOODEN_BUTTONS, VerdanceBlocks.MULBERRY_BUTTON);
    }

    private void signs() {
        add(ItemTags.SIGNS, VerdanceItems.MULBERRY_SIGN);
        add(ItemTags.HANGING_SIGNS, VerdanceItems.MULBERRY_HANGING_SIGN);
    }

    private void logs() {
        builder(ItemTags.LOGS_THAT_BURN).addTag(VerdanceItemTags.MULBERRY_LOGS);
        add(VerdanceItemTags.MULBERRY_LOGS,
                VerdanceBlocks.MULBERRY_LOG, VerdanceBlocks.MULBERRY_WOOD, VerdanceBlocks.STRIPPED_MULBERRY_LOG, VerdanceBlocks.STRIPPED_MULBERRY_WOOD);
    }

    private void boats() {
        add(ItemTags.BOATS, VerdanceItems.MULBERRY_BOAT);
        add(ItemTags.CHEST_BOATS, VerdanceItems.MULBERRY_CHEST_BOAT);
    }

    private void foods() {
        add(ConventionalItemTags.FOODS, VerdanceItems.GRILLED_CANTALOUPE_SLICE);
        add(ConventionalItemTags.FRUIT_FOODS, VerdanceItems.CANTALOUPE_SLICE);
        add(ConventionalItemTags.BERRY_FOODS, VerdanceItems.MULBERRY);
        add(ItemTags.CHICKEN_FOOD, VerdanceItems.CANTALOUPE_SEEDS);
        add(ItemTags.PARROT_FOOD, VerdanceItems.CANTALOUPE_SEEDS);
    }

    private void decoratedPotSherds() {
        add(ItemTags.DECORATED_POT_SHERDS,
                VerdanceItems.ABODE_POTTERY_SHERD, VerdanceItems.FRILLS_POTTERY_SHERD, VerdanceItems.PITCH_POTTERY_SHERD,
                VerdanceItems.PRICKLE_POTTERY_SHERD, VerdanceItems.SPIRIT_POTTERY_SHERD, VerdanceItems.TRAP_POTTERY_SHERD);
    }

    private void saplings() {
        add(ItemTags.SAPLINGS, VerdanceItems.MULBERRY);
    }

    private void leaves() {
        add(ItemTags.LEAVES, VerdanceBlocks.MULBERRY_LEAVES, VerdanceBlocks.FLOWERING_MULBERRY_LEAVES);
    }

    private void flowers() {
        add(ItemTags.FLOWERS, VerdanceBlocks.YELLOW_FLOWERING_SHRUB, VerdanceBlocks.PINK_FLOWERING_SHRUB);
    }

    private void smallFlowers() {
        add(ItemTags.SMALL_FLOWERS, VerdanceBlocks.VIOLET);
    }
}
