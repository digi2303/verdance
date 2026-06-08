package com.teamabode.verdance.impl.platform;

import dev.yumi.mc.core.api.YumiMods;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Util;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.SurfaceRules;

import java.util.function.Consumer;

public interface CommonAbstraction {
    boolean IS_FABRIC = YumiMods.get().isModLoaded("fabricloader") && !YumiMods.get().isModLoaded("connector");

    CommonAbstraction INSTANCE = Util.make(() -> {
        try {
            return (CommonAbstraction) Class.forName(
                    "com.teamabode.verdance.impl.platform." +
                            (CommonAbstraction.IS_FABRIC ? "fabric.FabricCommonAbstraction" : "neo.NeoCommonAbstraction")).getField("INSTANCE").get(null);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    });

    boolean isClient();

    void modifyCreativeTab(ResourceKey<CreativeModeTab> tab, Consumer<TabEntries> modifier);

    void registerAttributes(Consumer<AttributeRegistry> consumer);

    <T extends Mob> void registerSpawnPlacement(EntityType<T> type, SpawnPlacementType placementType, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate);

    void addBlockEntityBlocks(BlockEntityType<?> type, Block... blocks);

    void registerStrippable(Block from, Block to);

    void registerCompostable(ItemLike item, float chance);

    void registerBiomePlacements(Consumer<BiomeInjector> consumer);

    void onServerAboutToStart(Consumer<MinecraftServer> consumer);

    void injectChestLoot();

    interface TabEntries {
        void addAfter(ItemLike anchor, ItemLike... items);
    }

    interface AttributeRegistry {
        void register(EntityType<? extends LivingEntity> type, AttributeSupplier.Builder builder);
    }

    interface BiomeInjector {
        void replaceOverworld(ResourceKey<Biome> target, ResourceKey<Biome> replacement, double proportion);

        void addOverworldSurfaceRule(SurfaceRules.RuleSource rule);
    }
}
