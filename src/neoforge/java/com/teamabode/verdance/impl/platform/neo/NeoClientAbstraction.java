package com.teamabode.verdance.impl.platform.neo;

import com.teamabode.verdance.impl.platform.ClientAbstraction;
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.List;
import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public record NeoClientAbstraction() implements ClientAbstraction {
    public static final ClientAbstraction INSTANCE = new NeoClientAbstraction();

    @Override
    public <T extends Entity> void registerEntityRenderer(EntityType<? extends T> type, EntityRendererProvider<T> provider) {
        NeoCommonAbstraction.INSTANCE.addLateAction(bus -> bus.addListener(EntityRenderersEvent.RegisterRenderers.class, event -> event.registerEntityRenderer(type, provider)));
    }

    @Override
    public void registerEntityModelLayer(ModelLayerLocation location, Supplier<LayerDefinition> supplier) {
        NeoCommonAbstraction.INSTANCE.addLateAction(bus -> bus.addListener(EntityRenderersEvent.RegisterLayerDefinitions.class, event -> event.registerLayerDefinition(location, supplier)));
    }

    @Override
    public void registerBlockColor(List<BlockTintSource> sources, Block... blocks) {
        NeoCommonAbstraction.INSTANCE.addLateAction(bus -> bus.addListener(RegisterColorHandlersEvent.BlockTintSources.class, event -> event.register(sources, blocks)));
    }

    @Override
    public <T extends BlockEntity, S extends BlockEntityRenderState> void registerBlockEntityRenderer(BlockEntityType<T> type, BlockEntityRendererProvider<T, S> provider) {
        NeoCommonAbstraction.INSTANCE.addLateAction(bus -> bus.addListener(EntityRenderersEvent.RegisterRenderers.class, event -> event.registerBlockEntityRenderer(type, provider)));
    }
}
