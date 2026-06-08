package com.teamabode.verdance.core.event;

import com.teamabode.verdance.common.entity.silkmoth.SilkMoth;
import com.teamabode.verdance.common.entity.silkworm.Silkworm;
import com.teamabode.verdance.core.registry.VerdanceBlocks;
import com.teamabode.verdance.core.registry.VerdanceEntityTypes;
import com.teamabode.verdance.impl.platform.CommonAbstraction;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;

public class VerdanceEntityEvents {

    public static void register() {
        CommonAbstraction abstraction = CommonAbstraction.INSTANCE;

        abstraction.registerAttributes(registry -> {
            registry.register(VerdanceEntityTypes.SILK_MOTH, SilkMoth.createSilkMothAttributes());
            registry.register(VerdanceEntityTypes.SILKWORM, Silkworm.createSilkwormAttributes());
        });

        abstraction.registerSpawnPlacement(
                VerdanceEntityTypes.SILK_MOTH,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING,
                SilkMoth::checkSilkMothSpawnRules
        );

        abstraction.addBlockEntityBlocks(BlockEntityType.SIGN, VerdanceBlocks.MULBERRY_SIGN, VerdanceBlocks.MULBERRY_WALL_SIGN);
        abstraction.addBlockEntityBlocks(BlockEntityType.HANGING_SIGN, VerdanceBlocks.MULBERRY_HANGING_SIGN, VerdanceBlocks.MULBERRY_WALL_HANGING_SIGN);
    }
}
