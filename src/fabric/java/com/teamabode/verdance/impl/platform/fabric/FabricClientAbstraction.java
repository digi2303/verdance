package com.teamabode.verdance.impl.platform.fabric;

import com.teamabode.verdance.impl.platform.ClientAbstraction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.List;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public record FabricClientAbstraction() implements ClientAbstraction {
    public static final ClientAbstraction INSTANCE = new FabricClientAbstraction();

    @Override
    public <T extends Entity> void registerEntityRenderer(EntityType<? extends T> type, EntityRendererProvider<T> provider) {
        EntityRendererRegistry.register(type, provider);
    }

    @Override
    public void registerEntityModelLayer(ModelLayerLocation location, Supplier<LayerDefinition> supplier) {
        ModelLayerRegistry.registerModelLayer(location, supplier::get);
    }

    @Override
    public void registerBlockColor(List<BlockTintSource> sources, Block... blocks) {
        BlockColorRegistry.register(sources, blocks);
    }

    @Override
    public <T extends BlockEntity, S extends BlockEntityRenderState> void registerBlockEntityRenderer(BlockEntityType<T> type, BlockEntityRendererProvider<T, S> provider) {
        BlockEntityRendererRegistry.register(type, provider);
    }
}
