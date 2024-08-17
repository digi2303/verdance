package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.common.worldgen.DecayPatchConfiguration;
import com.teamabode.verdance.common.worldgen.MulberryTrunkPlacer;
import com.teamabode.verdance.core.tag.VerdanceBlockTags;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Map;

public class VerdanceConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_MULBERRY_FOREST = createKey("flower_mulberry_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MULBERRY = createKey("mulberry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CANTALOUPE = createKey("patch_cantaloupe");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_YELLOW_FLOWERING_SHRUB = createKey("patch_yellow_flowering_shrub");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_YELLOW_FLOWERING_SHRUB_BONEMEAL = createKey("patch_yellow_flowering_shrub_bonemeal");
    public static final ResourceKey<ConfiguredFeature<? ,?>> PATCH_ORANGE_FLOWERING_SHRUB_BONEMEAL = createKey("patch_orange_flowering_shrub_bonemeal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_VIOLET = createKey("flower_violet");

    public static void register(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, FLOWER_MULBERRY_FOREST, Feature.FLOWER, new RandomPatchConfiguration(
                64,
                7,
                3,
                PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(Blocks.LILY_OF_THE_VALLEY.defaultBlockState(), 1)
                                .add(Blocks.OXEYE_DAISY.defaultBlockState(), 2).build())
                ), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Blocks.AIR)))
        ));
        FeatureUtils.register(context, MULBERRY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                SimpleStateProvider.simple(VerdanceBlocks.MULBERRY_LOG),
                new MulberryTrunkPlacer(7, 2, 0),
                new WeightedStateProvider(
                        SimpleWeightedRandomList.<BlockState>builder()
                                .add(VerdanceBlocks.MULBERRY_LEAVES.defaultBlockState(), 14)
                                .add(VerdanceBlocks.FLOWERING_MULBERRY_LEAVES.defaultBlockState(), 1)
                                .build()
                ),
                new CherryFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(4), 0.33333333F, 0.25f, 0.16666667f, 0.33333334f),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());
        FeatureUtils.register(context, PATCH_CANTALOUPE, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(
                Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(VerdanceBlocks.CANTALOUPE)),
                List.of(Blocks.GRASS_BLOCK)
        ));
        FeatureUtils.register(context, PATCH_YELLOW_FLOWERING_SHRUB, VerdanceFeatures.DECAY_PATCH, new DecayPatchConfiguration(
                new DecayPatchConfiguration.Patch(96, 8, 1),
                List.of(
                        new DecayPatchConfiguration.Distance(6, createWeightedFeature(Map.of(
                                VerdanceBlocks.SHRUB, 4,
                                Blocks.DEAD_BUSH, 1
                        ))),
                        new DecayPatchConfiguration.Distance(4, createWeightedFeature(Map.of(
                                VerdanceBlocks.SHRUB, 1,
                                VerdanceBlocks.YELLOW_FLOWERING_SHRUB, 1
                        ))),
                        new DecayPatchConfiguration.Distance(0, createWeightedFeature(Map.of(
                                VerdanceBlocks.YELLOW_FLOWERING_SHRUB, 4,
                                VerdanceBlocks.SHRUB, 1
                        )))
                )
        ));
        FeatureUtils.register(context, PATCH_YELLOW_FLOWERING_SHRUB_BONEMEAL, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                32,
                4,
                2,
                floweringShrubPlacement(VerdanceBlocks.YELLOW_FLOWERING_SHRUB)
        ));
        FeatureUtils.register(context, PATCH_ORANGE_FLOWERING_SHRUB_BONEMEAL, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                32,
                4,
                2,
                floweringShrubPlacement(VerdanceBlocks.ORANGE_FLOWERING_SHRUB)
        ));
        FeatureUtils.register(context, FLOWER_VIOLET, Feature.FLOWER, new RandomPatchConfiguration(
                64,
                6,
                2,
                PlacementUtils.onlyWhenEmpty(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(SimpleStateProvider.simple(VerdanceBlocks.VIOLET))
                )
        ));
    }

    public static Holder<PlacedFeature> floweringShrubPlacement(Block shrubBlock) {
        return PlacementUtils.inlinePlaced(
                Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(shrubBlock.defaultBlockState(), 3).add(VerdanceBlocks.SHRUB.defaultBlockState(), 4)
                )),
                BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                        BlockPredicate.matchesTag(Direction.DOWN.getNormal(), VerdanceBlockTags.SHRUB_MAY_PLACE_ON)
                ))
        );
    }

    public static Holder<PlacedFeature> createWeightedFeature(Map<Block, Integer> weights) {
        var builder = SimpleWeightedRandomList.<BlockState>builder();
        weights.forEach((block, weight) -> builder.add(block.defaultBlockState(), weight));

        return PlacementUtils.inlinePlaced(
                Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(new WeightedStateProvider(builder.build())),
                BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                        BlockPredicate.matchesTag(Direction.DOWN.getNormal(), VerdanceBlockTags.SHRUB_MAY_PLACE_ON)
                ))
        );
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Verdance.id(name));
    }

}
