package com.teamabode.verdance.datagen;

import com.teamabode.verdance.core.registry.VerdanceJukeboxSongs;
import com.teamabode.verdance.core.registry.VerdanceTrimPatterns;
import com.teamabode.verdance.datagen.server.VerdanceAdvancementProvider;
import com.teamabode.verdance.datagen.server.VerdanceDynamicRegistryProvider;
import com.teamabode.verdance.datagen.server.VerdanceRecipeProvider;
import com.teamabode.verdance.datagen.server.loot.VerdanceBlockLootTableProvider;
import com.teamabode.verdance.datagen.server.loot.VerdanceLootTableProvider;
import com.teamabode.verdance.datagen.server.tag.VerdanceBiomeTagProvider;
import com.teamabode.verdance.datagen.server.tag.VerdanceBlockTagProvider;
import com.teamabode.verdance.datagen.server.tag.VerdanceEntityTypeTagProvider;
import com.teamabode.verdance.datagen.server.tag.VerdanceItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class VerdanceDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(VerdanceBlockTagProvider::new);
        pack.addProvider(VerdanceItemTagProvider::new);
        pack.addProvider(VerdanceEntityTypeTagProvider::new);
        pack.addProvider(VerdanceBiomeTagProvider::new);
        pack.addProvider(VerdanceBlockLootTableProvider::new);
        pack.addProvider(VerdanceLootTableProvider::new);
        pack.addProvider(VerdanceRecipeProvider::new);
        pack.addProvider(VerdanceAdvancementProvider::new);
        pack.addProvider(VerdanceDynamicRegistryProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.JUKEBOX_SONG, VerdanceJukeboxSongs::register);
        registryBuilder.add(Registries.TRIM_PATTERN, VerdanceTrimPatterns::register);
    }
}
