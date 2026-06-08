package com.teamabode.verdance.impl.platform;

import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Util;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.List;
import java.util.function.Supplier;

public interface ClientAbstraction {
    ClientAbstraction INSTANCE = Util.make(() -> {
        try {
            return (ClientAbstraction) Class.forName(
                    "com.teamabode.verdance.impl.platform." +
                            (CommonAbstraction.IS_FABRIC ? "fabric.FabricClientAbstraction" : "neo.NeoClientAbstraction")).getField("INSTANCE").get(null);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    });

    <T extends Entity> void registerEntityRenderer(EntityType<? extends T> type, EntityRendererProvider<T> provider);

    void registerEntityModelLayer(ModelLayerLocation location, Supplier<LayerDefinition> supplier);

    void registerBlockColor(List<BlockTintSource> sources, Block... blocks);

    <T extends BlockEntity, S extends BlockEntityRenderState> void registerBlockEntityRenderer(BlockEntityType<T> type, BlockEntityRendererProvider<T, S> provider);
}
