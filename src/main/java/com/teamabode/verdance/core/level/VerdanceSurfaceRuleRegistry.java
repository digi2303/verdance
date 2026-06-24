package com.teamabode.verdance.core.level;

import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.SurfaceRules;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class VerdanceSurfaceRuleRegistry {
    private static final List<Function<HolderGetter<Biome>, SurfaceRules.RuleSource>> FACTORIES = new ArrayList<>();
    private static final List<SurfaceRules.RuleSource> RESOLVED = new ArrayList<>();

    private VerdanceSurfaceRuleRegistry() {
    }

    public static void add(Function<HolderGetter<Biome>, SurfaceRules.RuleSource> factory) {
        FACTORIES.add(factory);
    }

    public static void resolve(HolderGetter<Biome> biomes) {
        RESOLVED.clear();
        for (Function<HolderGetter<Biome>, SurfaceRules.RuleSource> factory : FACTORIES) {
            RESOLVED.add(factory.apply(biomes));
        }
    }

    public static List<SurfaceRules.RuleSource> rules() {
        return RESOLVED;
    }
}
