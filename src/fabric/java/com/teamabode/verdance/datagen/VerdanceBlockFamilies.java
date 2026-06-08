package com.teamabode.verdance.datagen;

import com.google.common.collect.Maps;
import com.teamabode.verdance.core.registry.VerdanceBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.stream.Stream;

public class VerdanceBlockFamilies {
    private static final Map<Block, BlockFamily> BLOCK_FAMILIES = Maps.newHashMap();

    public static final BlockFamily MULBERRY = create(VerdanceBlocks.MULBERRY_PLANKS)
            .stairs(VerdanceBlocks.MULBERRY_STAIRS)
            .slab(VerdanceBlocks.MULBERRY_SLAB)
            .fence(VerdanceBlocks.MULBERRY_FENCE)
            .fenceGate(VerdanceBlocks.MULBERRY_FENCE_GATE)
            .door(VerdanceBlocks.MULBERRY_DOOR)
            .trapdoor(VerdanceBlocks.MULBERRY_TRAPDOOR)
            .pressurePlate(VerdanceBlocks.MULBERRY_PRESSURE_PLATE)
            .button(VerdanceBlocks.MULBERRY_BUTTON)
            .sign(VerdanceBlocks.MULBERRY_SIGN, VerdanceBlocks.MULBERRY_WALL_SIGN)
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .dontGenerateModel()
            .getFamily();
    public static final BlockFamily WHITE_STUCCO = stucco(VerdanceBlocks.WHITE_STUCCO, VerdanceBlocks.WHITE_STUCCO_STAIRS, VerdanceBlocks.WHITE_STUCCO_SLAB, VerdanceBlocks.WHITE_STUCCO_WALL);
    public static final BlockFamily LIGHT_GRAY_STUCCO = stucco(VerdanceBlocks.LIGHT_GRAY_STUCCO, VerdanceBlocks.LIGHT_GRAY_STUCCO_STAIRS, VerdanceBlocks.LIGHT_GRAY_STUCCO_SLAB, VerdanceBlocks.LIGHT_GRAY_STUCCO_WALL);
    public static final BlockFamily GRAY_STUCCO = stucco(VerdanceBlocks.GRAY_STUCCO, VerdanceBlocks.GRAY_STUCCO_STAIRS, VerdanceBlocks.GRAY_STUCCO_SLAB, VerdanceBlocks.GRAY_STUCCO_WALL);
    public static final BlockFamily BLACK_STUCCO = stucco(VerdanceBlocks.BLACK_STUCCO, VerdanceBlocks.BLACK_STUCCO_STAIRS, VerdanceBlocks.BLACK_STUCCO_SLAB, VerdanceBlocks.BLACK_STUCCO_WALL);
    public static final BlockFamily BROWN_STUCCO = stucco(VerdanceBlocks.BROWN_STUCCO, VerdanceBlocks.BROWN_STUCCO_STAIRS, VerdanceBlocks.BROWN_STUCCO_SLAB, VerdanceBlocks.BROWN_STUCCO_WALL);
    public static final BlockFamily RED_STUCCO = stucco(VerdanceBlocks.RED_STUCCO, VerdanceBlocks.RED_STUCCO_STAIRS, VerdanceBlocks.RED_STUCCO_SLAB, VerdanceBlocks.RED_STUCCO_WALL);
    public static final BlockFamily ORANGE_STUCCO = stucco(VerdanceBlocks.ORANGE_STUCCO, VerdanceBlocks.ORANGE_STUCCO_STAIRS, VerdanceBlocks.ORANGE_STUCCO_SLAB, VerdanceBlocks.ORANGE_STUCCO_WALL);
    public static final BlockFamily YELLOW_STUCCO = stucco(VerdanceBlocks.YELLOW_STUCCO, VerdanceBlocks.YELLOW_STUCCO_STAIRS, VerdanceBlocks.YELLOW_STUCCO_SLAB, VerdanceBlocks.YELLOW_STUCCO_WALL);
    public static final BlockFamily LIME_STUCCO = stucco(VerdanceBlocks.LIME_STUCCO, VerdanceBlocks.LIME_STUCCO_STAIRS, VerdanceBlocks.LIME_STUCCO_SLAB, VerdanceBlocks.LIME_STUCCO_WALL);
    public static final BlockFamily GREEN_STUCCO = stucco(VerdanceBlocks.GREEN_STUCCO, VerdanceBlocks.GREEN_STUCCO_STAIRS, VerdanceBlocks.GREEN_STUCCO_SLAB, VerdanceBlocks.GREEN_STUCCO_WALL);
    public static final BlockFamily CYAN_STUCCO = stucco(VerdanceBlocks.CYAN_STUCCO, VerdanceBlocks.CYAN_STUCCO_STAIRS, VerdanceBlocks.CYAN_STUCCO_SLAB, VerdanceBlocks.CYAN_STUCCO_WALL);
    public static final BlockFamily LIGHT_BLUE_STUCCO = stucco(VerdanceBlocks.LIGHT_BLUE_STUCCO, VerdanceBlocks.LIGHT_BLUE_STUCCO_STAIRS, VerdanceBlocks.LIGHT_BLUE_STUCCO_SLAB, VerdanceBlocks.LIGHT_BLUE_STUCCO_WALL);
    public static final BlockFamily BLUE_STUCCO = stucco(VerdanceBlocks.BLUE_STUCCO, VerdanceBlocks.BLUE_STUCCO_STAIRS, VerdanceBlocks.BLUE_STUCCO_SLAB, VerdanceBlocks.BLUE_STUCCO_WALL);
    public static final BlockFamily PURPLE_STUCCO = stucco(VerdanceBlocks.PURPLE_STUCCO, VerdanceBlocks.PURPLE_STUCCO_STAIRS, VerdanceBlocks.PURPLE_STUCCO_SLAB, VerdanceBlocks.PURPLE_STUCCO_WALL);
    public static final BlockFamily MAGENTA_STUCCO = stucco(VerdanceBlocks.MAGENTA_STUCCO, VerdanceBlocks.MAGENTA_STUCCO_STAIRS, VerdanceBlocks.MAGENTA_STUCCO_SLAB, VerdanceBlocks.MAGENTA_STUCCO_WALL);
    public static final BlockFamily PINK_STUCCO = stucco(VerdanceBlocks.PINK_STUCCO, VerdanceBlocks.PINK_STUCCO_STAIRS, VerdanceBlocks.PINK_STUCCO_SLAB, VerdanceBlocks.PINK_STUCCO_WALL);

    private static BlockFamily stucco(Block base, Block stairs, Block slab, Block wall) {
        return create(base)
                .stairs(stairs)
                .slab(slab)
                .wall(wall)
                .recipeGroupPrefix("stucco")
                .recipeUnlockedBy("has_stucco")
                .getFamily();
    }

    private static BlockFamily.Builder create(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = BLOCK_FAMILIES.put(baseBlock, builder.getFamily());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(baseBlock));
        }
        return builder;
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return BLOCK_FAMILIES.values().stream();
    }
}
