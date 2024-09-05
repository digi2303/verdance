package com.teamabode.verdance.core.integration.farmersdelight;

import com.teamabode.verdance.core.registry.VerdanceBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import vectorwing.farmersdelight.common.registry.ModItems;

public class VerdanceFD {
    private static final ResourceKey<CreativeModeTab> TAB_FARMERS_DELIGHT = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            ResourceLocation.parse("farmersdelight:farmersdelight")
    );

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(TAB_FARMERS_DELIGHT).register(entries -> {
            entries.addAfter(ModItems.ONION_CRATE.get(), VerdanceBlocks.MULBERRY_CRATE);
        });
    }
}
