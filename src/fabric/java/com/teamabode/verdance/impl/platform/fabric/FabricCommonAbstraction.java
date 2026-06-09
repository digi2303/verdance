package com.teamabode.verdance.impl.platform.fabric;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.impl.platform.CommonAbstraction;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;

import java.util.function.Consumer;

public record FabricCommonAbstraction() implements CommonAbstraction {
    public static final CommonAbstraction INSTANCE = new FabricCommonAbstraction();

    @Override
    public boolean isClient() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }

    @Override
    public void modifyCreativeTab(ResourceKey<CreativeModeTab> tab, Consumer<TabEntries> modifier) {
        CreativeModeTabEvents.modifyOutputEvent(tab).register(output -> modifier.accept(output::insertAfter));
    }

    @Override
    public void registerAttributes(Consumer<AttributeRegistry> consumer) {
        consumer.accept(FabricDefaultAttributeRegistry::register);
    }

    @Override
    public <T extends Mob> void registerSpawnPlacement(EntityType<T> type, SpawnPlacementType placementType, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate) {
        SpawnPlacements.register(type, placementType, heightmap, predicate);
    }

    @Override
    public void addBlockEntityBlocks(BlockEntityType<?> type, Block... blocks) {
        for (Block block : blocks) {
            ((FabricBlockEntityType) type).addValidBlock(block);
        }
    }

    @Override
    public void registerStrippable(Block from, Block to) {
        StrippableBlockRegistry.register(from, to);
    }

    @Override
    public void registerCompostable(ItemLike item, float chance) {
        CompostableRegistry.INSTANCE.add(item, chance);
    }

    @Override
    public void onServerAboutToStart(Consumer<MinecraftServer> consumer) {
        ServerLifecycleEvents.SERVER_STARTING.register(consumer::accept);
    }

    @Override
    public void injectChestLoot() {
        ResourceKey<LootTable> cantaloupeSeeds = ResourceKey.create(Registries.LOOT_TABLE, Verdance.id("chests/cantaloupe_seeds"));
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key == BuiltInLootTables.ABANDONED_MINESHAFT
                    || key == BuiltInLootTables.SIMPLE_DUNGEON
                    || key == BuiltInLootTables.WOODLAND_MANSION) {
                tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(cantaloupeSeeds)));
            }
        });
    }
}
