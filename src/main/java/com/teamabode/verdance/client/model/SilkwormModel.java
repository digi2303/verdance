package com.teamabode.verdance.client.model;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.client.VerdanceAnimations;
import com.teamabode.verdance.client.renderer.state.SilkwormRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

@Environment(EnvType.CLIENT)
public class SilkwormModel extends EntityModel<SilkwormRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Verdance.id("silkworm"), "main");

    private final KeyframeAnimation moveAnimation;

    public SilkwormModel(ModelPart root) {
        super(root);
        this.moveAnimation = VerdanceAnimations.SILKWORM_MOVE.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition meshRoot = mesh.getRoot();

        meshRoot.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -5.5F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(-7, 0).addBox(2.0F, 0.0F, -2.5F, 1.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(-7, 0).addBox(-3.0F, 0.0F, -2.5F, 1.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-3.0F, -4.0F, -3.5F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-3.0F, -4.0F, 0.5F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-3.0F, -4.0F, 3.5F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(mesh, 32, 32);
    }

    @Override
    public void setupAnim(SilkwormRenderState state) {
        super.setupAnim(state);
        this.moveAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2.0f, 4.0f);
    }
}
