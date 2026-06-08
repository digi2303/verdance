package com.teamabode.verdance.client.renderer;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.client.model.SilkwormModel;
import com.teamabode.verdance.client.renderer.state.SilkwormRenderState;
import com.teamabode.verdance.common.entity.silkworm.Silkworm;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@Environment(EnvType.CLIENT)
public class SilkwormRenderer extends MobRenderer<Silkworm, SilkwormRenderState, SilkwormModel> {
    private static final Identifier TEXTURE = Verdance.id("textures/entity/silkworm.png");

    public SilkwormRenderer(EntityRendererProvider.Context context) {
        super(context, new SilkwormModel(context.bakeLayer(SilkwormModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public SilkwormRenderState createRenderState() {
        return new SilkwormRenderState();
    }

    @Override
    public Identifier getTextureLocation(SilkwormRenderState state) {
        return TEXTURE;
    }
}
