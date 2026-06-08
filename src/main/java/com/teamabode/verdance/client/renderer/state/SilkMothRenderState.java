package com.teamabode.verdance.client.renderer.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class SilkMothRenderState extends LivingEntityRenderState {
    public boolean flying;
    public boolean onGround;
    public float bodyXRot;
    public float soarProgress;
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState flyAnimationState = new AnimationState();
}
