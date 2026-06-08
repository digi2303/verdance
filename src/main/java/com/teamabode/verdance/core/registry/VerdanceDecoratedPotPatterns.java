package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public class VerdanceDecoratedPotPatterns {
    public static final ResourceKey<DecoratedPotPattern> ABODE = createKey("abode");
    public static final ResourceKey<DecoratedPotPattern> FRILLS = createKey("frills");
    public static final ResourceKey<DecoratedPotPattern> PITCH = createKey("pitch");
    public static final ResourceKey<DecoratedPotPattern> PRICKLE = createKey("prickle");
    public static final ResourceKey<DecoratedPotPattern> SPIRIT = createKey("spirit");
    public static final ResourceKey<DecoratedPotPattern> TRAP = createKey("trap");

    public static void register() {
        register("abode", ABODE);
        register("frills", FRILLS);
        register("pitch", PITCH);
        register("prickle", PRICKLE);
        register("spirit", SPIRIT);
        register("trap", TRAP);
    }

    private static void register(String name, ResourceKey<DecoratedPotPattern> key) {
        Registry.register(BuiltInRegistries.DECORATED_POT_PATTERN, key, new DecoratedPotPattern(Verdance.id(name + "_pottery_pattern")));
    }

    private static ResourceKey<DecoratedPotPattern> createKey(String name) {
        return ResourceKey.create(Registries.DECORATED_POT_PATTERN, Verdance.id(name));
    }
}
