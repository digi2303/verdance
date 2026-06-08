package com.teamabode.verdance.datagen.server.tag;

import com.teamabode.verdance.core.registry.VerdanceEntityTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class VerdanceEntityTypeTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {

    public VerdanceEntityTypeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(EntityTypeTags.ARTHROPOD)
                .add(VerdanceEntityTypes.SILK_MOTH.builtInRegistryHolder().key())
                .add(VerdanceEntityTypes.SILKWORM.builtInRegistryHolder().key());
    }
}
