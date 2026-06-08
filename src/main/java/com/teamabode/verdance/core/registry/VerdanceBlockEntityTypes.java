package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.common.block.entity.SilkCocoonBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;

public class VerdanceBlockEntityTypes {
    public static BlockEntityType<SilkCocoonBlockEntity> SILK_COCOON;

    public static void register() {
        SILK_COCOON = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Verdance.id("silk_cocoon"),
                new BlockEntityType<>(SilkCocoonBlockEntity::new, Set.of(VerdanceBlocks.SILK_COCOON))
        );
    }
}
