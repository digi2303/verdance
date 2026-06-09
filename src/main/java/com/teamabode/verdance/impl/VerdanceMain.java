package com.teamabode.verdance.impl;

import com.teamabode.verdance.VerdanceConfig;
import com.teamabode.verdance.core.event.VerdanceBiomeModifications;
import com.teamabode.verdance.core.event.VerdanceContentRegistries;
import com.teamabode.verdance.core.event.VerdanceCreativeTabs;
import com.teamabode.verdance.core.event.VerdanceDispenserBehaviors;
import com.teamabode.verdance.core.event.VerdanceEntityEvents;
import com.teamabode.verdance.core.event.VerdanceFlammability;
import com.teamabode.verdance.core.event.VerdanceLootModifications;
import com.teamabode.verdance.core.event.VerdanceStructureModifications;
import com.teamabode.verdance.core.registry.VerdanceActivities;
import com.teamabode.verdance.core.registry.VerdanceBlockEntityTypes;
import com.teamabode.verdance.core.registry.VerdanceBlocks;
import com.teamabode.verdance.core.registry.VerdanceDecoratedPotPatterns;
import com.teamabode.verdance.core.registry.VerdanceEntityTypes;
import com.teamabode.verdance.core.registry.VerdanceFeatures;
import com.teamabode.verdance.core.registry.VerdanceItems;
import com.teamabode.verdance.core.registry.VerdanceMemoryModuleTypes;
import com.teamabode.verdance.core.registry.VerdanceSensorTypes;
import com.teamabode.verdance.core.registry.VerdanceSoundEvents;
import com.teamabode.verdance.core.registry.VerdanceTreeDecoratorTypes;
import com.teamabode.verdance.core.registry.VerdanceTriggerTypes;
import com.teamabode.verdance.core.registry.VerdanceTrunkPlacerTypes;
import com.teamabode.verdance.core.integration.farmersdelight.FDCompat;
import dev.yumi.mc.core.api.ModContainer;
import dev.yumi.mc.core.api.YumiMods;
import dev.yumi.mc.core.api.entrypoint.ModInitializer;

public class VerdanceMain implements ModInitializer {
    @Override
    public void onInitialize(ModContainer modContainer) {
        VerdanceConfig.load();
        VerdanceSoundEvents.register();
        VerdanceMemoryModuleTypes.register();
        VerdanceActivities.register();
        VerdanceSensorTypes.register();
        VerdanceDecoratedPotPatterns.register();
        VerdanceTriggerTypes.register();
        VerdanceEntityTypes.register();
        VerdanceBlocks.register();
        VerdanceBlockEntityTypes.register();
        VerdanceItems.register();
        if (YumiMods.get().isModLoaded("farmersdelight")) {
            FDCompat.register();
        }
        VerdanceFeatures.register();
        VerdanceTrunkPlacerTypes.register();
        VerdanceTreeDecoratorTypes.register();
        VerdanceFlammability.register();
        VerdanceCreativeTabs.register();
        VerdanceEntityEvents.register();
        VerdanceContentRegistries.register();
        VerdanceDispenserBehaviors.register();
        VerdanceBiomeModifications.register();
        VerdanceStructureModifications.register();
        VerdanceLootModifications.register();
    }
}
