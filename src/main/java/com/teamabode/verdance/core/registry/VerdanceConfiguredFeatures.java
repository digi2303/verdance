package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class VerdanceConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_MULBERRY_FOREST = createKey("flower_mulberry_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MULBERRY = createKey("mulberry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MULBERRY_WITH_SILK_COCOON = createKey("mulberry_with_silk_cocoon");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CANTALOUPE = createKey("patch_cantaloupe");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PILE_CANTALOUPE = createKey("pile_cantaloupe");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SHRUB = createKey("patch_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUBLANDS_BUSH = createKey("shrublands_bush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_VIOLET = createKey("flower_violet");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_YELLOW_FLOWERING_SHRUB_BONEMEAL = createKey("patch_yellow_flowering_shrub_bonemeal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PINK_FLOWERING_SHRUB_BONEMEAL = createKey("patch_pink_flowering_shrub_bonemeal");

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Verdance.id(name));
    }
}
