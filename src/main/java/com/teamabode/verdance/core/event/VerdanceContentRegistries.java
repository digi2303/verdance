package com.teamabode.verdance.core.event;

import com.teamabode.verdance.core.registry.VerdanceBlocks;
import com.teamabode.verdance.core.registry.VerdanceItems;
import com.teamabode.verdance.impl.platform.CommonAbstraction;

public class VerdanceContentRegistries {

    public static void register() {
        CommonAbstraction abstraction = CommonAbstraction.INSTANCE;

        abstraction.registerStrippable(VerdanceBlocks.MULBERRY_LOG, VerdanceBlocks.STRIPPED_MULBERRY_LOG);
        abstraction.registerStrippable(VerdanceBlocks.MULBERRY_WOOD, VerdanceBlocks.STRIPPED_MULBERRY_WOOD);

        abstraction.registerCompostable(VerdanceBlocks.CANTALOUPE, 0.65f);
        abstraction.registerCompostable(VerdanceItems.CANTALOUPE_SEEDS, 0.3f);
        abstraction.registerCompostable(VerdanceItems.CANTALOUPE_SLICE, 0.5f);
        abstraction.registerCompostable(VerdanceBlocks.FLOWERING_MULBERRY_LEAVES, 0.5f);
        abstraction.registerCompostable(VerdanceItems.GRILLED_CANTALOUPE_SLICE, 0.65f);
        abstraction.registerCompostable(VerdanceItems.MULBERRY, 0.3f);
        abstraction.registerCompostable(VerdanceBlocks.MULBERRY_LEAVES, 0.3f);
        abstraction.registerCompostable(VerdanceBlocks.VIOLET, 0.65f);
        abstraction.registerCompostable(VerdanceBlocks.SHRUB, 0.3f);
        abstraction.registerCompostable(VerdanceBlocks.PINK_FLOWERING_SHRUB, 0.3f);
        abstraction.registerCompostable(VerdanceBlocks.YELLOW_FLOWERING_SHRUB, 0.3f);
    }
}
