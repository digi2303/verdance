package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class VerdancePlacedFeatures {
    public static final ResourceKey<PlacedFeature> FLOWER_MULBERRY_FOREST = createKey("flower_mulberry_forest");
    public static final ResourceKey<PlacedFeature> MULBERRY = createKey("mulberry");
    public static final ResourceKey<PlacedFeature> MULBERRY_CHECKED = createKey("mulberry_checked");
    public static final ResourceKey<PlacedFeature> PATCH_CANTALOUPE = createKey("patch_cantaloupe");
    public static final ResourceKey<PlacedFeature> PILE_CANTALOUPE = createKey("pile_cantaloupe");
    public static final ResourceKey<PlacedFeature> PATCH_SHRUB = createKey("patch_shrub");
    public static final ResourceKey<PlacedFeature> SHRUBLANDS_BUSH = createKey("shrublands_bush");
    public static final ResourceKey<PlacedFeature> FLOWER_VIOLET = createKey("flower_violet");

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Verdance.id(name));
    }
}
