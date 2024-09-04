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
    public static final ResourceKey<StructureProcessorList> TOWN_RUINS_ARCHAEOLOGY = createKey("town_ruins_archaeology");
    public static final ResourceKey<StructureProcessorList> TOWN_RUINS_SMALL_ARCHAEOLOGY = createKey("town_ruins_small_archaeology");

    public static void register(BootstrapContext<StructureProcessorList> context) {
        registerArchaeology(context, TOWN_RUINS_ARCHAEOLOGY, 6, 2);
        registerArchaeology(context, TOWN_RUINS_SMALL_ARCHAEOLOGY, 3, 1);
    }

    private static void registerArchaeology(BootstrapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> key, int commonAmount, int rareAmount) {
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
                        new AppendLoot(VerdanceLootTables.ARCHAEOLOGY_TOWN_RUINS_TREASURE)
                ))),
                ConstantInt.of(rareAmount)
        );
        register(context, key, common, rare);
    }

    private static void register(BootstrapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> key, StructureProcessor... processors) {
        context.register(key, new StructureProcessorList(List.of(processors)));
    }

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, Verdance.id(name));
    }
}
