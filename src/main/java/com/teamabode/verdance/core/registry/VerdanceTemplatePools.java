package com.teamabode.verdance.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabode.verdance.Verdance;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool.Projection;

import java.util.List;

public class VerdanceTemplatePools {
    public static final ResourceKey<StructureTemplatePool> TOWN_RUINS_BUILDINGS = createKey("town_ruins/buildings");
    public static final ResourceKey<StructureTemplatePool> TOWN_RUINS_CENTERS = createKey("town_ruins/centers");
    public static final ResourceKey<StructureTemplatePool> TOWN_RUINS_ROADS = createKey("town_ruins/roads");
    public static final ResourceKey<StructureTemplatePool> TOWN_RUINS_ROAD_ENDS = createKey("town_ruins/road_ends");

    public static void register(BootstrapContext<StructureTemplatePool> context) {
        var templatePools = context.lookup(Registries.TEMPLATE_POOL);
        var processorLists = context.lookup(Registries.PROCESSOR_LIST);

        var emptyPool = templatePools.getOrThrow(Pools.EMPTY);
        var buildingProcessor = processorLists.getOrThrow(VerdanceProcessorLists.TOWN_RUINS_BUILDING_ARCHAEOLOGY);
        var largeBuildingProcessor = processorLists.getOrThrow(VerdanceProcessorLists.TOWN_RUINS_LARGE_BUILDING_ARCHAEOLOGY);
        var roadProcessor = processorLists.getOrThrow(VerdanceProcessorLists.TOWN_RUINS_ROAD_ARCHAEOLOGY);

        context.register(TOWN_RUINS_BUILDINGS, new StructureTemplatePool(emptyPool, List.of(
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/house_1", largeBuildingProcessor), 2),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/house_2", buildingProcessor), 2),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/house_3", buildingProcessor), 2),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/house_4", buildingProcessor), 2),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/house_5", largeBuildingProcessor), 2),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/garden", buildingProcessor), 1),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/statue_1", buildingProcessor), 1),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/statue_2", largeBuildingProcessor), 1),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/statue_3", buildingProcessor), 1)
        ), Projection.RIGID));
        context.register(TOWN_RUINS_CENTERS, new StructureTemplatePool(emptyPool, List.of(
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/center_1", largeBuildingProcessor), 1),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/center_2", largeBuildingProcessor), 1),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/center_3", largeBuildingProcessor), 1),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/buildings/center_4", largeBuildingProcessor), 1)
        ), Projection.RIGID));
        context.register(TOWN_RUINS_ROADS, new StructureTemplatePool(emptyPool, List.of(
                Pair.of(StructurePoolElement.single("verdance:town_ruins/roads/road_1", roadProcessor), 1),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/roads/road_2", roadProcessor), 1),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/roads/road_3", roadProcessor), 1)
        ), Projection.RIGID));
        context.register(TOWN_RUINS_ROAD_ENDS, new StructureTemplatePool(emptyPool, List.of(
                Pair.of(StructurePoolElement.single("verdance:town_ruins/roads/road_end_1", roadProcessor), 1),
                Pair.of(StructurePoolElement.single("verdance:town_ruins/roads/road_end_2", roadProcessor), 1)
        ), Projection.RIGID));
    }

    private static ResourceKey<StructureTemplatePool> createKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, Verdance.id(name));
    }
}
