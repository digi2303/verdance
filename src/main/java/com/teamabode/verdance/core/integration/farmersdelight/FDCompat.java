package com.teamabode.verdance.core.integration.farmersdelight;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.impl.platform.CommonAbstraction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Set;
import java.util.function.Function;

public class FDCompat {
    public static Block MULBERRY_CABINET;
    public static Block MULBERRY_CRATE;
    public static BlockEntityType<MulberryCabinetBlockEntity> CABINET_BLOCK_ENTITY;

    public static void register() {
        MULBERRY_CABINET = registerBlock("mulberry_cabinet", key -> new MulberryCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).setId(key)));
        MULBERRY_CRATE = registerBlock("mulberry_crate", key -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(key)));
        CABINET_BLOCK_ENTITY = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Verdance.id("cabinet"),
                new BlockEntityType<>(MulberryCabinetBlockEntity::new, Set.of(MULBERRY_CABINET))
        );
        CommonAbstraction.INSTANCE.modifyCreativeTab(CreativeModeTabs.FUNCTIONAL_BLOCKS, entries ->
                entries.addAfter(Items.BARREL, MULBERRY_CABINET, MULBERRY_CRATE));
    }

    private static Block registerBlock(String name, Function<ResourceKey<Block>, Block> factory) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Verdance.id(name));
        Block block = factory.apply(blockKey);
        Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Verdance.id(name));
        Registry.register(BuiltInRegistries.ITEM, itemKey, new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(itemKey)));
        return block;
    }
}
