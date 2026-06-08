package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.schedule.Activity;

public class VerdanceActivities {
    public static Activity COCOON;
    public static Activity LAY_EGGS;
    public static Activity SLEEP;

    public static void register() {
        COCOON = register("cocoon");
        LAY_EGGS = register("lay_eggs");
        SLEEP = register("sleep");
    }

    private static Activity register(String name) {
        return Registry.register(BuiltInRegistries.ACTIVITY, Verdance.id(name), new Activity(name));
    }
}
