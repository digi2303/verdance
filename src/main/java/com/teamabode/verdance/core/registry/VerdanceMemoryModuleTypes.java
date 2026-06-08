package com.teamabode.verdance.core.registry;

import com.mojang.serialization.Codec;
import com.teamabode.verdance.Verdance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;

import java.util.Optional;

public class VerdanceMemoryModuleTypes {
    public static MemoryModuleType<Unit> IS_FLYING;
    public static MemoryModuleType<Unit> WANTS_TO_COCOON;
    public static MemoryModuleType<Unit> WANTS_TO_LAND;
    public static MemoryModuleType<Long> LANDING_TIME;
    public static MemoryModuleType<BlockPos> NEAREST_LIGHT_SOURCE;

    public static void register() {
        IS_FLYING = register("is_flying");
        WANTS_TO_COCOON = register("wants_to_cocoon");
        WANTS_TO_LAND = register("wants_to_land", Unit.CODEC);
        LANDING_TIME = register("landing_time", Codec.LONG);
        NEAREST_LIGHT_SOURCE = register("nearest_light_source");
    }

    private static <U> MemoryModuleType<U> register(String name) {
        return Registry.register(BuiltInRegistries.MEMORY_MODULE_TYPE, Verdance.id(name), new MemoryModuleType<>(Optional.empty()));
    }

    private static <U> MemoryModuleType<U> register(String name, Codec<U> codec) {
        return Registry.register(BuiltInRegistries.MEMORY_MODULE_TYPE, Verdance.id(name), new MemoryModuleType<>(Optional.of(codec)));
    }
}
