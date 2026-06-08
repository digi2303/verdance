package com.teamabode.verdance.core.event;

import com.teamabode.verdance.core.registry.VerdanceEntityTypes;
import com.teamabode.verdance.core.registry.VerdanceItems;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.world.level.block.DispenserBlock;

public class VerdanceDispenserBehaviors {

    public static void register() {
        DispenserBlock.registerBehavior(VerdanceItems.MULBERRY_BOAT, new BoatDispenseItemBehavior(VerdanceEntityTypes.MULBERRY_BOAT));
        DispenserBlock.registerBehavior(VerdanceItems.MULBERRY_CHEST_BOAT, new BoatDispenseItemBehavior(VerdanceEntityTypes.MULBERRY_CHEST_BOAT));
    }
}
