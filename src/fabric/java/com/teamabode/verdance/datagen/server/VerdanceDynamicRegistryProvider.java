package com.teamabode.verdance.datagen.server;

import com.teamabode.verdance.core.registry.VerdanceJukeboxSongs;
import com.teamabode.verdance.core.registry.VerdanceTrimPatterns;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class VerdanceDynamicRegistryProvider extends FabricDynamicRegistryProvider {

    public VerdanceDynamicRegistryProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.add(registries.lookupOrThrow(Registries.TRIM_PATTERN), VerdanceTrimPatterns.HERITAGE);
        entries.add(registries.lookupOrThrow(Registries.JUKEBOX_SONG), VerdanceJukeboxSongs.RANGE);
    }

    @Override
    public String getName() {
        return "Verdance Dynamic Registries";
    }
}
