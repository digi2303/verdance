package com.teamabode.verdance.core.misc;

import com.teamabode.verdance.core.registry.VerdanceSoundEvents;
import net.minecraft.world.level.block.SoundType;

public class VerdanceBlockSoundGroups {
    public static SoundType silkCocoon() {
        return new SoundType(
                1.0f,
                1.0f,
                VerdanceSoundEvents.BLOCK_SILK_COCOON_BREAK,
                VerdanceSoundEvents.BLOCK_SILK_COCOON_STEP,
                VerdanceSoundEvents.BLOCK_SILK_COCOON_PLACE,
                VerdanceSoundEvents.BLOCK_SILK_COCOON_HIT,
                VerdanceSoundEvents.BLOCK_SILK_COCOON_FALL
        );
    }

    public static SoundType stucco() {
        return new SoundType(
                0.4f,
                1.1f,
                VerdanceSoundEvents.BLOCK_STUCCO_BREAK,
                VerdanceSoundEvents.BLOCK_STUCCO_STEP,
                VerdanceSoundEvents.BLOCK_STUCCO_PLACE,
                VerdanceSoundEvents.BLOCK_STUCCO_HIT,
                VerdanceSoundEvents.BLOCK_STUCCO_FALL
        );
    }
}
