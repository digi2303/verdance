package com.teamabode.verdance.core.event;

import com.mojang.datafixers.util.Pair;
import com.teamabode.verdance.core.mixin.accessor.StructurePoolAccessor;
import com.teamabode.verdance.core.registry.VerdancePlacedFeatures;
import com.teamabode.verdance.impl.platform.CommonAbstraction;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class VerdanceStructureModifications {

    public static void register() {
        CommonAbstraction.INSTANCE.onServerAboutToStart(server -> {
            HolderLookup.Provider registries = server.registryAccess();
            var placedFeatures = registries.lookupOrThrow(Registries.PLACED_FEATURE);

            modifyStructurePool(Identifier.withDefaultNamespace("village/desert/decor"), registries, elements ->
                    elements.put(StructurePoolElement.feature(placedFeatures.getOrThrow(VerdancePlacedFeatures.PILE_CANTALOUPE)).apply(StructureTemplatePool.Projection.RIGID), 4));
        });
    }

    private static void modifyStructurePool(Identifier id, HolderLookup.Provider registries, Modifier modifier) {
        ResourceKey<StructureTemplatePool> pool = ResourceKey.create(Registries.TEMPLATE_POOL, id);
        StructurePoolAccessor accessor = (StructurePoolAccessor) registries.lookupOrThrow(Registries.TEMPLATE_POOL).getOrThrow(pool).value();

        Object2IntArrayMap<StructurePoolElement> builder = new Object2IntArrayMap<>();
        accessor.getRawTemplates().forEach(pair -> builder.put(pair.getFirst(), pair.getSecond().intValue()));
        modifier.apply(builder);
        accessor.setRawTemplates(builder.object2IntEntrySet().stream().map(entry -> Pair.of(entry.getKey(), entry.getIntValue())).toList());
        accessor.getTemplates().clear();
        builder.forEach((element, weight) -> {
            for (int i = 0; i < weight; ++i) {
                accessor.getTemplates().add(element);
            }
        });
    }

    @FunctionalInterface
    public interface Modifier {
        void apply(Object2IntArrayMap<StructurePoolElement> elements);
    }
}
