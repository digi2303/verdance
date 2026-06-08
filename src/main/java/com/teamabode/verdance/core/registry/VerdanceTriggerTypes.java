package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.common.trigger.SilkwormEggsDestroyedCriterion;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.criterion.PlayerTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class VerdanceTriggerTypes {
    public static SilkwormEggsDestroyedCriterion SILKWORM_EGGS_DESTROYED;
    public static PlayerTrigger EXTINGUISHED_WITH_CANTALOUPE_JUICE;

    public static void register() {
        SILKWORM_EGGS_DESTROYED = register("silkworm_eggs_destroyed", new SilkwormEggsDestroyedCriterion());
        EXTINGUISHED_WITH_CANTALOUPE_JUICE = register("extinguished_with_cantaloupe_juice", new PlayerTrigger());
    }

    private static <T extends CriterionTrigger<?>> T register(String name, T trigger) {
        return Registry.register(BuiltInRegistries.TRIGGER_TYPES, Verdance.id(name), trigger);
    }
}
