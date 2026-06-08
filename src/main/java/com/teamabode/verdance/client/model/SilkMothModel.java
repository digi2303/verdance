package com.teamabode.verdance.client.model;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.client.VerdanceAnimations;
import com.teamabode.verdance.client.renderer.state.SilkMothRenderState;
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
import net.minecraft.util.Mth;

@Environment(EnvType.CLIENT)
public class SilkMothModel extends EntityModel<SilkMothRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Verdance.id("silk_moth"), "main");

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart rightAntenna;
    private final ModelPart leftAntenna;
    private final ModelPart leftLegFront;
    private final ModelPart leftLegMid;
    private final ModelPart leftLegBack;
    private final ModelPart rightLegFront;
    private final ModelPart rightLegMid;
    private final ModelPart rightLegBack;
    private final ModelPart leftWing;
    private final ModelPart rightWing;

    private final KeyframeAnimation idleAnimation;
    private final KeyframeAnimation walkAnimation;
    private final KeyframeAnimation flyAnimation;

    public SilkMothModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.head = body.getChild("head");
        this.leftAntenna = head.getChild("left_antenna");
        this.rightAntenna = head.getChild("right_antenna");
        this.leftLegFront = body.getChild("left_leg_front");
        this.leftLegMid = body.getChild("left_leg_mid");
        this.leftLegBack = body.getChild("left_leg_back");
        this.rightLegFront = body.getChild("right_leg_front");
        this.rightLegMid = body.getChild("right_leg_mid");
        this.rightLegBack = body.getChild("right_leg_back");
        this.rightWing = body.getChild("right_wing");
        this.leftWing = body.getChild("left_wing");

        this.idleAnimation = VerdanceAnimations.SILK_MOTH_IDLE.bake(root);
        this.walkAnimation = VerdanceAnimations.SILK_MOTH_WALK.bake(root);
        this.flyAnimation = VerdanceAnimations.SILK_MOTH_FLY.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).addBox(-5.0F, -4.0F, -5.0F, 9.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
        .texOffs(0, 25).addBox(-4.0F, -3.0F, 2.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 19.0F, -1.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -3.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -5.0F));

        head.addOrReplaceChild("right_antenna", CubeListBuilder.create().texOffs(20, -7).addBox(0.0F, -7.0F, -7.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -3.0F, -2.0F));
        head.addOrReplaceChild("left_antenna", CubeListBuilder.create().texOffs(20, -7).addBox(0.0F, -7.0F, -7.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -3.0F, -2.0F));

        body.addOrReplaceChild("left_leg_front", CubeListBuilder.create().texOffs(48, 0).addBox(0.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 4.0F, -3.0F));
        body.addOrReplaceChild("left_leg_mid", CubeListBuilder.create().texOffs(48, 0).addBox(0.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 4.0F, 1.0F));
        body.addOrReplaceChild("left_leg_back", CubeListBuilder.create().texOffs(48, 0).addBox(0.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 4.0F, 5.0F));

        body.addOrReplaceChild("right_leg_front", CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 4.0F, -3.0F));
        body.addOrReplaceChild("right_leg_mid", CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 4.0F, 1.0F));
        body.addOrReplaceChild("right_leg_back", CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 4.0F, 5.0F));

        body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(14, 7).mirror().addBox(0.0F, 0.0F, -9.5F, 12.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -2.0F, -1.0F));
        body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(14, 7).addBox(-12.0F, 0.0F, -9.5F, 12.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -2.0F, -1.0F));

        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public void setupAnim(SilkMothRenderState state) {
        super.setupAnim(state);
        this.setupBones();
        this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks);
        if (state.onGround && !state.flying) {
            this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2.0f, 2.5f);
        }
        this.flyAnimation.apply(state.flyAnimationState, state.ageInTicks);
        this.animateBones(state);
    }

    private void setupBones() {
        this.body.y = 17.75f;

        this.rightAntenna.zRot = -22.5f * Mth.DEG_TO_RAD;
        this.leftAntenna.zRot = 22.5f * Mth.DEG_TO_RAD;

        this.rightLegFront.yRot = -22.5f * Mth.DEG_TO_RAD;
        this.rightLegFront.zRot = -22.5f * Mth.DEG_TO_RAD;
        this.rightLegMid.zRot = -22.5f * Mth.DEG_TO_RAD;
        this.rightLegBack.yRot = 22.5f * Mth.DEG_TO_RAD;
        this.rightLegBack.zRot = -22.5f * Mth.DEG_TO_RAD;
        this.leftLegFront.yRot = 22.5f * Mth.DEG_TO_RAD;
        this.leftLegFront.zRot = 22.5f * Mth.DEG_TO_RAD;
        this.leftLegMid.zRot = 22.5f * Mth.DEG_TO_RAD;
        this.leftLegBack.yRot = -22.5f * Mth.DEG_TO_RAD;
        this.leftLegBack.zRot = 22.5f * Mth.DEG_TO_RAD;
        this.rightWing.zRot = 45.0f * Mth.DEG_TO_RAD;
        this.leftWing.zRot = -45.0f * Mth.DEG_TO_RAD;
    }

    private void animateBones(SilkMothRenderState state) {
        float headYaw = Mth.clamp(state.yRot, -30.0F, 30.0F);
        float headPitch = Mth.clamp(state.xRot, -25.0F, 45.0F);
        float soarProgress = state.soarProgress;

        this.body.xRot = state.bodyXRot;
        this.head.yRot = headYaw * Mth.DEG_TO_RAD;
        this.head.xRot = (headPitch * Mth.DEG_TO_RAD) - state.bodyXRot;

        this.leftLegFront.zRot -= (soarProgress * 15.0f) * Mth.DEG_TO_RAD;
        this.leftLegFront.yRot -= (soarProgress * 30.0f) * Mth.DEG_TO_RAD;
        this.leftLegMid.zRot -= (soarProgress * 15.0f) * Mth.DEG_TO_RAD;
        this.leftLegMid.yRot -= (soarProgress * 30.0f) * Mth.DEG_TO_RAD;
        this.leftLegBack.zRot -= (soarProgress * 15.0f) * Mth.DEG_TO_RAD;
        this.leftLegBack.yRot -= (soarProgress * 30.0f) * Mth.DEG_TO_RAD;
        this.rightLegFront.zRot += (soarProgress * 15.0f) * Mth.DEG_TO_RAD;
        this.rightLegFront.yRot += (soarProgress * 30.0f) * Mth.DEG_TO_RAD;
        this.rightLegMid.zRot += (soarProgress * 15.0f) * Mth.DEG_TO_RAD;
        this.rightLegMid.yRot += (soarProgress * 30.0f) * Mth.DEG_TO_RAD;
        this.rightLegBack.zRot += (soarProgress * 15.0f) * Mth.DEG_TO_RAD;
        this.rightLegBack.yRot += (soarProgress * 30.0f) * Mth.DEG_TO_RAD;
    }
}
