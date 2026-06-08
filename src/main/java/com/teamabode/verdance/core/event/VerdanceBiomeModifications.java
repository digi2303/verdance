package com.teamabode.verdance.core.event;

import com.teamabode.verdance.VerdanceConfig;
import com.teamabode.verdance.core.misc.VerdanceSurfaceRules;
import com.teamabode.verdance.core.registry.VerdanceBiomes;
import com.teamabode.verdance.impl.platform.CommonAbstraction;
import net.minecraft.world.level.biome.Biomes;

public class VerdanceBiomeModifications {

    public static void register() {
        CommonAbstraction.INSTANCE.registerBiomePlacements(injector -> {
            injector.replaceOverworld(Biomes.CHERRY_GROVE, VerdanceBiomes.MULBERRY_FOREST, VerdanceConfig.instance.mulberryForestProportion);
            injector.replaceOverworld(Biomes.SPARSE_JUNGLE, VerdanceBiomes.SHRUBLANDS, VerdanceConfig.instance.shrublandsProportion);
            injector.addOverworldSurfaceRule(VerdanceSurfaceRules.shrublands());
        });
    }
}
