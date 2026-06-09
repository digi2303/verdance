package com.teamabode.verdance.impl.platform.neo;

import com.teamabode.verdance.impl.platform.CommonAbstraction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public record NeoCommonAbstraction(List<Consumer<IEventBus>> lateActions) implements CommonAbstraction {
    public static IEventBus EVENT_BUS = null;
    public static final NeoCommonAbstraction INSTANCE = new NeoCommonAbstraction(new ArrayList<>());

    @Override
    public boolean isClient() {
        return FMLEnvironment.getDist().isClient();
    }

    @Override
    public void modifyCreativeTab(ResourceKey<CreativeModeTab> tab, Consumer<TabEntries> modifier) {
        addLateAction(bus -> bus.addListener(BuildCreativeModeTabContentsEvent.class, event -> {
            if (event.getTabKey().equals(tab)) {
                modifier.accept((anchor, items) -> {
                    ItemStack last = anchor.asItem().getDefaultInstance();
                    for (ItemLike item : items) {
                        ItemStack stack = item.asItem().getDefaultInstance();
                        event.insertAfter(last, stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                        last = stack;
                    }
                });
            }
        }));
    }

    @Override
    public void registerAttributes(Consumer<AttributeRegistry> consumer) {
        addLateAction(bus -> bus.addListener(EntityAttributeCreationEvent.class, event ->
                consumer.accept((type, builder) -> event.put(type, builder.build()))));
    }

    @Override
    public <T extends Mob> void registerSpawnPlacement(EntityType<T> type, SpawnPlacementType placementType, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate) {
        addLateAction(bus -> bus.addListener(RegisterSpawnPlacementsEvent.class, event ->
                event.register(type, placementType, heightmap, predicate, RegisterSpawnPlacementsEvent.Operation.AND)));
    }

    @Override
    public void addBlockEntityBlocks(BlockEntityType<?> type, Block... blocks) {
        addLateAction(bus -> bus.addListener(BlockEntityTypeAddBlocksEvent.class, event -> event.modify(type, blocks)));
    }

    @Override
    public void registerStrippable(Block from, Block to) {
    }

    @Override
    public void registerCompostable(ItemLike item, float chance) {
    }

    @Override
    public void onServerAboutToStart(Consumer<MinecraftServer> consumer) {
        NeoForge.EVENT_BUS.addListener(ServerAboutToStartEvent.class, event -> consumer.accept(event.getServer()));
    }

    @Override
    public void injectChestLoot() {
    }

    public void addLateAction(Consumer<IEventBus> consumer) {
        if (EVENT_BUS != null) {
            consumer.accept(EVENT_BUS);
        } else {
            this.lateActions.add(consumer);
        }
    }
}
