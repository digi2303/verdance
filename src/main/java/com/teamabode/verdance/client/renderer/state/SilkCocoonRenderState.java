package com.teamabode.verdance.client.renderer.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.Direction;

@Environment(EnvType.CLIENT)
public class SilkCocoonRenderState extends BlockEntityRenderState {
    public boolean wobbling;
    public float wobbleTicks;
    public Direction facing = Direction.NORTH;
}
