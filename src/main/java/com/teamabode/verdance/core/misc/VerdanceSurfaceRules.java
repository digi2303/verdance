package com.teamabode.verdance.core.misc;

import com.teamabode.verdance.core.registry.VerdanceBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceRules.RuleSource;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class VerdanceSurfaceRules {

    public static RuleSource shrublands(HolderGetter<Biome> biomes) {
        RuleSource coarseDirt = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(4, false, 0, CaveSurface.FLOOR), state(Blocks.COARSE_DIRT));

        RuleSource aboveSurface = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
//? if >=26.2 {
                /*SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, -0.9, -0.5), coarseDirt),
                SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, -0.2, 0.2), coarseDirt),
                SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, 0.5, 0.9), coarseDirt),
*///?} else {
                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.9f, -0.5f), coarseDirt),
                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.2f, 0.2f), coarseDirt),
                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, 0.5f, 0.9f), coarseDirt),
//?}
                applyDesertRules()
        ));

//? if >=26.2 {
        /*return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomes, VerdanceBiomes.SHRUBLANDS), aboveSurface);
*///?} else {
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(VerdanceBiomes.SHRUBLANDS), aboveSurface);
//?}
    }

    private static RuleSource applyDesertRules() {
        RuleSource sand = state(Blocks.SAND);
        RuleSource floorSandstone = sandstone(CaveSurface.CEILING, false, 0);
        RuleSource deepSandstone = sandstone(CaveSurface.FLOOR, true, 30);
        RuleSource desertSurface = SurfaceRules.sequence(floorSandstone, sand);

        RuleSource floorDepthCheck = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, CaveSurface.FLOOR), desertSurface);
        RuleSource floorSand = SurfaceRules.ifTrue(SurfaceRules.waterStartCheck(-6, -1), SurfaceRules.sequence(floorDepthCheck, deepSandstone));

        RuleSource ceilingWaterCheck = SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), desertSurface);
        RuleSource ceilingSand = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), ceilingWaterCheck);

        return SurfaceRules.sequence(ceilingSand, floorSand);
    }

    private static RuleSource state(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static RuleSource sandstone(CaveSurface surfaceType, boolean addSurfaceDepth, int secondaryDepthRange) {
        return SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, addSurfaceDepth, secondaryDepthRange, surfaceType), state(Blocks.SANDSTONE));
    }
}
