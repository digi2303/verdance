package com.teamabode.verdance.core.event;

import com.teamabode.verdance.core.registry.VerdanceBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

public class VerdanceFlammability {

    public static void register() {
        FireBlock fire = (FireBlock) Blocks.FIRE;

        setFlammable(fire, VerdanceBlocks.MULBERRY_PLANKS, 5, 20);
        setFlammable(fire, VerdanceBlocks.MULBERRY_STAIRS, 5, 20);
        setFlammable(fire, VerdanceBlocks.MULBERRY_SLAB, 5, 20);
        setFlammable(fire, VerdanceBlocks.MULBERRY_FENCE, 5, 20);
        setFlammable(fire, VerdanceBlocks.MULBERRY_FENCE_GATE, 5, 20);
        setFlammable(fire, VerdanceBlocks.MULBERRY_LOG, 5, 5);
        setFlammable(fire, VerdanceBlocks.STRIPPED_MULBERRY_LOG, 5, 5);
        setFlammable(fire, VerdanceBlocks.MULBERRY_WOOD, 5, 5);
        setFlammable(fire, VerdanceBlocks.STRIPPED_MULBERRY_WOOD, 5, 5);
        setFlammable(fire, VerdanceBlocks.MULBERRY_LEAVES, 30, 60);
        setFlammable(fire, VerdanceBlocks.FLOWERING_MULBERRY_LEAVES, 30, 60);
        setFlammable(fire, VerdanceBlocks.VIOLET, 60, 100);
        setFlammable(fire, VerdanceBlocks.SHRUB, 60, 100);
        setFlammable(fire, VerdanceBlocks.YELLOW_FLOWERING_SHRUB, 60, 100);
        setFlammable(fire, VerdanceBlocks.PINK_FLOWERING_SHRUB, 60, 100);
    }

    private static void setFlammable(FireBlock fire, Block block, int igniteOdds, int burnOdds) {
        fire.setFlammable(block, igniteOdds, burnOdds);
    }
}
