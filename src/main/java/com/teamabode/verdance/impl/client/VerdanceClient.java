package com.teamabode.verdance.impl.client;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.client.model.SilkMothModel;
import com.teamabode.verdance.client.model.SilkwormModel;
import com.teamabode.verdance.client.renderer.SilkCocoonBlockEntityRenderer;
import com.teamabode.verdance.client.renderer.SilkMothRenderer;
import com.teamabode.verdance.client.renderer.SilkwormRenderer;
import com.teamabode.verdance.core.registry.VerdanceBlockEntityTypes;
import com.teamabode.verdance.core.registry.VerdanceBlocks;
import com.teamabode.verdance.core.registry.VerdanceEntityTypes;
import com.teamabode.verdance.impl.platform.ClientAbstraction;
import dev.yumi.mc.core.api.ModContainer;
import dev.yumi.mc.core.api.entrypoint.client.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;

import java.util.List;

@Environment(EnvType.CLIENT)
public class VerdanceClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer modContainer) {
        ClientAbstraction abstraction = ClientAbstraction.INSTANCE;

        abstraction.registerEntityModelLayer(SilkMothModel.LAYER_LOCATION, SilkMothModel::createBodyLayer);
        abstraction.registerEntityModelLayer(SilkwormModel.LAYER_LOCATION, SilkwormModel::createBodyLayer);
        abstraction.registerEntityModelLayer(SilkCocoonBlockEntityRenderer.LAYER_LOCATION, SilkCocoonBlockEntityRenderer::createLayer);

        ModelLayerLocation mulberryBoatLayer = new ModelLayerLocation(Verdance.id("boat/mulberry"), "main");
        ModelLayerLocation mulberryChestBoatLayer = new ModelLayerLocation(Verdance.id("chest_boat/mulberry"), "main");
        abstraction.registerEntityModelLayer(mulberryBoatLayer, BoatModel::createBoatModel);
        abstraction.registerEntityModelLayer(mulberryChestBoatLayer, BoatModel::createChestBoatModel);

        abstraction.registerEntityRenderer(VerdanceEntityTypes.SILK_MOTH, SilkMothRenderer::new);
        abstraction.registerEntityRenderer(VerdanceEntityTypes.SILKWORM, SilkwormRenderer::new);
        abstraction.registerEntityRenderer(VerdanceEntityTypes.CUSHION, NoopRenderer::new);
        abstraction.<AbstractBoat>registerEntityRenderer(VerdanceEntityTypes.MULBERRY_BOAT, context -> new BoatRenderer(context, mulberryBoatLayer));
        abstraction.<AbstractBoat>registerEntityRenderer(VerdanceEntityTypes.MULBERRY_CHEST_BOAT, context -> new BoatRenderer(context, mulberryChestBoatLayer));

        abstraction.registerBlockColor(List.of(BlockTintSources.foliage()), VerdanceBlocks.MULBERRY_LEAVES, VerdanceBlocks.FLOWERING_MULBERRY_LEAVES);

        abstraction.registerBlockEntityRenderer(VerdanceBlockEntityTypes.SILK_COCOON, SilkCocoonBlockEntityRenderer::new);
    }
}
