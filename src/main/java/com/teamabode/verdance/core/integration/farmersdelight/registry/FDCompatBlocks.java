package com.teamabode.verdance.core.integration.farmersdelight.registry;

import com.teamabode.verdance.Verdance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import vectorwing.farmersdelight.common.block.CabinetBlock;

public class FDCompatBlocks {
    public static final Block MULBERRY_CABINET = register(
            "mulberry_cabinet",
            new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL))
    );
    public static final Block MULBERRY_CRATE = register(
            "mulberry_crate",
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
    );

    public static void register() {}

    // Registry Utils
    private static Block register(String name, BlockBehaviour.Properties properties) {
        return register(name, new Block(properties));
    }

    private static Block register(String name, Block block) {
        var registry = Registry.register(BuiltInRegistries.BLOCK, Verdance.id(name), block);
        Registry.register(BuiltInRegistries.ITEM, Verdance.id(name), new BlockItem(registry, new Item.Properties()));
        return registry;
    }
}
