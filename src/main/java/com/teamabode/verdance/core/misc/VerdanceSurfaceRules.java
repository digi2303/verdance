package com.teamabode.verdance.core.misc;

import com.teamabode.verdance.core.registry.VerdanceBiomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class VerdanceSurfaceRules {

    public static SurfaceRules.RuleSource shrublands() {
        var sand = SurfaceRules.state(Blocks.SAND.defaultBlockState());

        return SurfaceRules.ifTrue(
                SurfaceRules.isBiome(VerdanceBiomes.SHRUBLANDS), SurfaceRules.ifTrue(
                        SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.waterBlockCheck(-1, 0),
                                                SurfaceRules.sequence(
                                                        sandstone(CaveSurface.CEILING, false, 0),
                                                        sand
                                                )
                                        )
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.waterStartCheck(-6, -1),
                                        SurfaceRules.sequence(
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.stoneDepthCheck(0, true, CaveSurface.FLOOR),
                                                        SurfaceRules.sequence(
                                                                sandstone(CaveSurface.CEILING, false, 0),
                                                                sand
                                                        )
                                                ),
                                                sandstone(CaveSurface.FLOOR, true, 30)
                                        )
                                )
                        )
                )
        );
    }

    private static SurfaceRules.RuleSource sandstone(CaveSurface surfaceType, boolean addSurfaceDepth, int secondaryDepthRange) {
        return SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, addSurfaceDepth, secondaryDepthRange, surfaceType), SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState()));

    }
}
