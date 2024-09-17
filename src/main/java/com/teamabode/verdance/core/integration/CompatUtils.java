package com.teamabode.verdance.core.integration;

import com.teamabode.verdance.Verdance;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

public class CompatUtils {

    public static void registerBuiltinPack(String packName, ModContainer container) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                Verdance.id(packName),
                container,
                ResourcePackActivationType.ALWAYS_ENABLED
        );
    }

    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
