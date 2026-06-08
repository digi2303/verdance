package com.teamabode.verdance.datagen.server.tag;

import com.teamabode.verdance.core.registry.VerdanceBiomes;
import com.teamabode.verdance.core.tag.VerdanceBiomeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.concurrent.CompletableFuture;

public class VerdanceBiomeTagProvider extends FabricTagsProvider<Biome> {

    public VerdanceBiomeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BIOME, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(BiomeTags.IS_FOREST).addOptional(VerdanceBiomes.MULBERRY_FOREST);
        builder(BiomeTags.IS_MOUNTAIN).addOptional(VerdanceBiomes.MULBERRY_FOREST);
        builder(BiomeTags.IS_OVERWORLD)
                .addOptional(VerdanceBiomes.MULBERRY_FOREST)
                .addOptional(VerdanceBiomes.SHRUBLANDS);
        builder(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).addOptional(VerdanceBiomes.SHRUBLANDS);
        builder(BiomeTags.STRONGHOLD_BIASED_TO)
                .addOptional(VerdanceBiomes.MULBERRY_FOREST)
                .addOptional(VerdanceBiomes.SHRUBLANDS);
        builder(VerdanceBiomeTags.HAS_CANTALOUPE)
                .addOptionalTag(BiomeTags.IS_SAVANNA)
                .addOptional(VerdanceBiomes.SHRUBLANDS);
        builder(VerdanceBiomeTags.HAS_GOLDEN_WOLF).addOptional(VerdanceBiomes.MULBERRY_FOREST);
        builder(VerdanceBiomeTags.HAS_VIOLET)
                .addOptionalTag(BiomeTags.IS_TAIGA)
                .addOptional(Biomes.OLD_GROWTH_BIRCH_FOREST)
                .addOptional(Biomes.WINDSWEPT_HILLS)
                .addOptional(Biomes.WINDSWEPT_FOREST);
        builder(BiomeTags.HAS_TRIAL_CHAMBERS)
                .addOptional(VerdanceBiomes.MULBERRY_FOREST)
                .addOptional(VerdanceBiomes.SHRUBLANDS);
        builder(BiomeTags.HAS_MINESHAFT).addOptional(VerdanceBiomes.SHRUBLANDS);
        builder(BiomeTags.HAS_RUINED_PORTAL_STANDARD).addOptional(VerdanceBiomes.SHRUBLANDS);
        builder(VerdanceBiomeTags.HAS_TOWN_RUINS)
                .addOptional(VerdanceBiomes.SHRUBLANDS)
                .addOptionalTag(ConventionalBiomeTags.IS_DESERT);
        builder(ConventionalBiomeTags.IS_HOT_OVERWORLD).addOptional(VerdanceBiomes.SHRUBLANDS);
        builder(ConventionalBiomeTags.IS_VEGETATION_DENSE).addOptional(VerdanceBiomes.SHRUBLANDS);
    }
}
