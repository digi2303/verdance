package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.AppendLoot;

import java.util.List;

public class VerdanceProcessorLists {
    public static final ResourceKey<StructureProcessorList> TOWN_RUINS_BUILDING_ARCHAEOLOGY = createKey("town_ruins_building_archaeology");
    public static final ResourceKey<StructureProcessorList> TOWN_RUINS_LARGE_BUILDING_ARCHAEOLOGY = createKey("town_ruins_large_building_archaeology");
    public static final ResourceKey<StructureProcessorList> TOWN_RUINS_ROAD_ARCHAEOLOGY = createKey("town_ruins_road_archaeology");

    public static void register(BootstrapContext<StructureProcessorList> context) {
        registerArchaeology(context, TOWN_RUINS_BUILDING_ARCHAEOLOGY, 6, 3);
        registerArchaeology(context, TOWN_RUINS_LARGE_BUILDING_ARCHAEOLOGY, 8, 4);
        registerArchaeology(context, TOWN_RUINS_ROAD_ARCHAEOLOGY, 4, 2);
    }

    private static void registerArchaeology(BootstrapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> key, int commonAmount, int rareAmount) {
        RuleProcessor cobblestone = new RuleProcessor(List.of(
                new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.GRANITE, 0.3f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.COBBLESTONE.defaultBlockState()
        )));
        CappedProcessor common = new CappedProcessor(
                new RuleProcessor(List.of(new ProcessorRule(
                        new BlockMatchTest(Blocks.SAND),
                        AlwaysTrueTest.INSTANCE,
                        PosAlwaysTrueTest.INSTANCE,
                        Blocks.SUSPICIOUS_SAND.defaultBlockState(),
                        new AppendLoot(VerdanceLootTables.ARCHAEOLOGY_TOWN_RUINS_COMMON)
                ))),
                ConstantInt.of(commonAmount)
        );
        CappedProcessor rare = new CappedProcessor(
                new RuleProcessor(List.of(new ProcessorRule(
                        new BlockMatchTest(Blocks.SAND),
                        AlwaysTrueTest.INSTANCE,
                        PosAlwaysTrueTest.INSTANCE,
                        Blocks.SUSPICIOUS_SAND.defaultBlockState(),
                        new AppendLoot(VerdanceLootTables.ARCHAEOLOGY_TOWN_RUINS_RARE)
                ))),
                ConstantInt.of(rareAmount)
        );
        register(context, key, cobblestone, common, rare);
    }

    private static void register(BootstrapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> key, StructureProcessor... processors) {
        context.register(key, new StructureProcessorList(List.of(processors)));
    }

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, Verdance.id(name));
    }
}
