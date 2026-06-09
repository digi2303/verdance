package com.teamabode.verdance.core.level;

import net.minecraft.world.level.levelgen.SurfaceRules;

import java.util.ArrayList;
import java.util.List;

public final class VerdanceSurfaceRuleRegistry {
    private static final List<SurfaceRules.RuleSource> RULES = new ArrayList<>();

    private VerdanceSurfaceRuleRegistry() {
    }

    public static void add(SurfaceRules.RuleSource rule) {
        RULES.add(rule);
    }

    public static List<SurfaceRules.RuleSource> rules() {
        return RULES;
    }
}
