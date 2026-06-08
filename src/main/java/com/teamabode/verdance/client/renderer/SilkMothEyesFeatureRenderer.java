package com.teamabode.verdance.client.renderer;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.client.model.SilkMothModel;
import com.teamabode.verdance.client.renderer.state.SilkMothRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;

@Environment(EnvType.CLIENT)
public class SilkMothEyesFeatureRenderer extends EyesLayer<SilkMothRenderState, SilkMothModel> {
    private static final RenderType EYES = RenderTypes.eyes(Verdance.id("textures/entity/silk_moth/eyes.png"));

    public SilkMothEyesFeatureRenderer(RenderLayerParent<SilkMothRenderState, SilkMothModel> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public RenderType renderType() {
        return EYES;
    }
}
