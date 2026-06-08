package com.teamabode.verdance.client.renderer;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.client.model.SilkMothModel;
import com.teamabode.verdance.client.renderer.state.SilkMothRenderState;
import com.teamabode.verdance.common.entity.silkmoth.SilkMoth;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

@Environment(EnvType.CLIENT)
public class SilkMothRenderer extends MobRenderer<SilkMoth, SilkMothRenderState, SilkMothModel> {
    private static final Identifier TEXTURE = Verdance.id("textures/entity/silk_moth/silk_moth.png");

    public SilkMothRenderer(EntityRendererProvider.Context context) {
        super(context, new SilkMothModel(context.bakeLayer(SilkMothModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new SilkMothEyesFeatureRenderer(this));
    }

    @Override
    public SilkMothRenderState createRenderState() {
        return new SilkMothRenderState();
    }

    @Override
    public void extractRenderState(SilkMoth entity, SilkMothRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.flying = entity.isFlying();
        state.onGround = entity.onGround();
        state.soarProgress = entity.getSoarProgress(partialTicks);
        state.bodyXRot = Mth.clamp(entity.bodyPitch * 45.0f, -45.0f, 45.0f) * Mth.DEG_TO_RAD;
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.flyAnimationState.copyFrom(entity.flyAnimationState);
    }

    @Override
    public Identifier getTextureLocation(SilkMothRenderState state) {
        return TEXTURE;
    }
}
