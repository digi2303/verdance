package com.teamabode.verdance.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.client.renderer.state.SilkCocoonRenderState;
import com.teamabode.verdance.common.block.SilkCocoonBlock;
import com.teamabode.verdance.common.block.entity.SilkCocoonBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import org.joml.Quaternionf;

@Environment(EnvType.CLIENT)
public class SilkCocoonBlockEntityRenderer implements BlockEntityRenderer<SilkCocoonBlockEntity, SilkCocoonRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Verdance.id("silk_cocoon"), "main");
    private static final RenderType RENDER_TYPE = RenderTypes.entitySolid(Verdance.id("textures/entity/silk_cocoon.png"));

    private final ModelPart cocoon;

    public SilkCocoonBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart root = context.bakeLayer(LAYER_LOCATION);
        this.cocoon = root.getChild("cocoon");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        root.addOrReplaceChild(
                "cocoon",
                CubeListBuilder.create().texOffs(0, 0).addBox(3, 0, 6, 10.0f, 12.0f, 10.0f),
                PartPose.ZERO
        );
        return LayerDefinition.create(mesh, 64, 32);
    }

    @Override
    public SilkCocoonRenderState createRenderState() {
        return new SilkCocoonRenderState();
    }

    @Override
    public void extractRenderState(SilkCocoonBlockEntity cocoon, SilkCocoonRenderState state, float partialTick, net.minecraft.world.phys.Vec3 cameraPosition, net.minecraft.client.renderer.feature.ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(cocoon, state, partialTick, cameraPosition, breakProgress);
        state.wobbling = cocoon.wobbling;
        state.wobbleTicks = cocoon.wobbleTicks + partialTick;
        state.facing = cocoon.getBlockState().getValue(SilkCocoonBlock.FACING);
    }

    @Override
    public void submit(SilkCocoonRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        poseStack.pushPose();
        Direction dir = state.facing;
        float wobble = Mth.sin(state.wobbleTicks * 3.0f / Mth.PI) * (5.0f * Mth.DEG_TO_RAD);

        Quaternionf rotation;
        if (dir == Direction.NORTH || dir == Direction.SOUTH) {
            rotation = Axis.ZP.rotation(wobble);
        } else {
            rotation = Axis.XP.rotation(wobble);
        }
        if (state.wobbling) {
            poseStack.rotateAround(rotation, 0.5f, 0.5f, 0.5f);
        }
        poseStack.translate(0.5f, 0.5f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot()));
        poseStack.translate(-0.5f, -0.5f, -0.5f);

        submitNodeCollector.submitModelPart(this.cocoon, poseStack, RENDER_TYPE, state.lightCoords, OverlayTexture.NO_OVERLAY, null);
        poseStack.popPose();
    }
}
