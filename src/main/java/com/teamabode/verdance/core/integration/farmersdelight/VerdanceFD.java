package com.teamabode.verdance.core.integration.farmersdelight;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.core.integration.farmersdelight.registry.FDCompatBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.Optional;

public class VerdanceFD {
    private static final ResourceKey<CreativeModeTab> TAB_FARMERS_DELIGHT = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            ResourceLocation.parse("farmersdelight:farmersdelight")
    );

    public static void register() {
        FDCompatBlocks.register();

        ItemGroupEvents.modifyEntriesEvent(TAB_FARMERS_DELIGHT).register(entries -> {
            entries.addAfter(ModItems.ONION_CRATE.get(), FDCompatBlocks.MULBERRY_CRATE);
            entries.addAfter(ModBlocks.CHERRY_CABINET.get(), FDCompatBlocks.MULBERRY_CABINET);
        });

        Optional<ModContainer> container = FabricLoader.getInstance().getModContainer(Verdance.MOD_ID);
        if (container.isPresent()) {
            registerBuiltinPack("datapack", container.get());
            registerBuiltinPack("resourcepack", container.get());
        }
    }

    private static void registerBuiltinPack(String packType, ModContainer container) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                Verdance.id("farmersdelight" + packType),
                container,
                ResourcePackActivationType.DEFAULT_ENABLED
        );
    }
}
