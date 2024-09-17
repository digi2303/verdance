package com.teamabode.verdance.core.integration.guarding;

import com.teamabode.verdance.core.integration.CompatUtils;
import net.fabricmc.loader.api.ModContainer;

public class GuardingIntegration {

    public static void register(ModContainer container) {
        // TODO: This could probably be handled in Guarding itself
        CompatUtils.registerBuiltinPack("guarding_resourcepack", container);
    }
}
