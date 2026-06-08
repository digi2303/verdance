package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.common.block.*;
import com.teamabode.verdance.core.misc.VerdanceBlockSetTypes;
import com.teamabode.verdance.core.misc.VerdanceBlockSoundGroups;
import com.teamabode.verdance.core.misc.VerdanceSaplingGenerators;
import com.teamabode.verdance.core.misc.VerdanceWoodTypes;
import com.teamabode.verdance.core.misc.VerdanceBlockRegistryKeys;
import com.teamabode.verdance.core.misc.VerdanceItemRegistryKeys;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.TintedParticleLeavesBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.OffsetType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class VerdanceBlocks {
    public static Block MULBERRY_LOG;
    public static Block MULBERRY_WOOD;
    public static Block STRIPPED_MULBERRY_LOG;
    public static Block STRIPPED_MULBERRY_WOOD;
    public static Block MULBERRY_PLANKS;
    public static Block MULBERRY_STAIRS;
    public static Block MULBERRY_SLAB;
    public static Block MULBERRY_FENCE;
    public static Block MULBERRY_FENCE_GATE;
    public static Block MULBERRY_DOOR;
    public static Block MULBERRY_TRAPDOOR;
    public static Block MULBERRY_PRESSURE_PLATE;
    public static Block MULBERRY_BUTTON;
    public static Block MULBERRY_SIGN;
    public static Block MULBERRY_WALL_SIGN;
    public static Block MULBERRY_HANGING_SIGN;
    public static Block MULBERRY_WALL_HANGING_SIGN;
    public static Block MULBERRY_LEAVES;
    public static Block FLOWERING_MULBERRY_LEAVES;
    public static Block MULBERRY_SAPLING;
    public static Block POTTED_MULBERRY_SAPLING;
    public static Block CANTALOUPE;
    public static Block ATTACHED_CANTALOUPE_STEM;
    public static Block CANTALOUPE_STEM;
    public static Block WHITE_CUSHION;
    public static Block LIGHT_GRAY_CUSHION;
    public static Block GRAY_CUSHION;
    public static Block BLACK_CUSHION;
    public static Block BROWN_CUSHION;
    public static Block RED_CUSHION;
    public static Block ORANGE_CUSHION;
    public static Block YELLOW_CUSHION;
    public static Block LIME_CUSHION;
    public static Block GREEN_CUSHION;
    public static Block CYAN_CUSHION;
    public static Block LIGHT_BLUE_CUSHION;
    public static Block BLUE_CUSHION;
    public static Block PURPLE_CUSHION;
    public static Block MAGENTA_CUSHION;
    public static Block PINK_CUSHION;
    public static Block WHITE_STUCCO;
    public static Block WHITE_STUCCO_STAIRS;
    public static Block WHITE_STUCCO_SLAB;
    public static Block WHITE_STUCCO_WALL;
    public static Block LIGHT_GRAY_STUCCO;
    public static Block LIGHT_GRAY_STUCCO_STAIRS;
    public static Block LIGHT_GRAY_STUCCO_SLAB;
    public static Block LIGHT_GRAY_STUCCO_WALL;
    public static Block GRAY_STUCCO;
    public static Block GRAY_STUCCO_STAIRS;
    public static Block GRAY_STUCCO_SLAB;
    public static Block GRAY_STUCCO_WALL;
    public static Block BLACK_STUCCO;
    public static Block BLACK_STUCCO_STAIRS;
    public static Block BLACK_STUCCO_SLAB;
    public static Block BLACK_STUCCO_WALL;
    public static Block BROWN_STUCCO;
    public static Block BROWN_STUCCO_STAIRS;
    public static Block BROWN_STUCCO_SLAB;
    public static Block BROWN_STUCCO_WALL;
    public static Block RED_STUCCO;
    public static Block RED_STUCCO_STAIRS;
    public static Block RED_STUCCO_SLAB;
    public static Block RED_STUCCO_WALL;
    public static Block ORANGE_STUCCO;
    public static Block ORANGE_STUCCO_STAIRS;
    public static Block ORANGE_STUCCO_SLAB;
    public static Block ORANGE_STUCCO_WALL;
    public static Block YELLOW_STUCCO;
    public static Block YELLOW_STUCCO_STAIRS;
    public static Block YELLOW_STUCCO_SLAB;
    public static Block YELLOW_STUCCO_WALL;
    public static Block LIME_STUCCO;
    public static Block LIME_STUCCO_STAIRS;
    public static Block LIME_STUCCO_SLAB;
    public static Block LIME_STUCCO_WALL;
    public static Block GREEN_STUCCO;
    public static Block GREEN_STUCCO_STAIRS;
    public static Block GREEN_STUCCO_SLAB;
    public static Block GREEN_STUCCO_WALL;
    public static Block CYAN_STUCCO;
    public static Block CYAN_STUCCO_STAIRS;
    public static Block CYAN_STUCCO_SLAB;
    public static Block CYAN_STUCCO_WALL;
    public static Block LIGHT_BLUE_STUCCO;
    public static Block LIGHT_BLUE_STUCCO_STAIRS;
    public static Block LIGHT_BLUE_STUCCO_SLAB;
    public static Block LIGHT_BLUE_STUCCO_WALL;
    public static Block BLUE_STUCCO;
    public static Block BLUE_STUCCO_STAIRS;
    public static Block BLUE_STUCCO_SLAB;
    public static Block BLUE_STUCCO_WALL;
    public static Block PURPLE_STUCCO;
    public static Block PURPLE_STUCCO_STAIRS;
    public static Block PURPLE_STUCCO_SLAB;
    public static Block PURPLE_STUCCO_WALL;
    public static Block MAGENTA_STUCCO;
    public static Block MAGENTA_STUCCO_STAIRS;
    public static Block MAGENTA_STUCCO_SLAB;
    public static Block MAGENTA_STUCCO_WALL;
    public static Block PINK_STUCCO;
    public static Block PINK_STUCCO_STAIRS;
    public static Block PINK_STUCCO_SLAB;
    public static Block PINK_STUCCO_WALL;
    public static Block SILKWORM_EGGS;
    public static Block SILK_COCOON;
    public static Block VIOLET;
    public static Block POTTED_VIOLET;
    public static Block SHRUB;
    public static Block POTTED_SHRUB;
    public static Block YELLOW_FLOWERING_SHRUB;
    public static Block POTTED_YELLOW_FLOWERING_SHRUB;
    public static Block PINK_FLOWERING_SHRUB;
    public static Block POTTED_PINK_FLOWERING_SHRUB;

    public static void register() {
        MULBERRY_LOG = registerWithItem("mulberry_log", RotatedPillarBlock::new, Blocks.logProperties(MapColor.TERRACOTTA_YELLOW, MapColor.TERRACOTTA_GRAY, SoundType.WOOD));
        MULBERRY_WOOD = registerWithItem("mulberry_wood", RotatedPillarBlock::new, Blocks.logProperties(MapColor.TERRACOTTA_YELLOW, MapColor.TERRACOTTA_GRAY, SoundType.WOOD));
        STRIPPED_MULBERRY_LOG = registerWithItem("stripped_mulberry_log", RotatedPillarBlock::new, Blocks.logProperties(MapColor.TERRACOTTA_YELLOW, MapColor.TERRACOTTA_YELLOW, SoundType.WOOD));
        STRIPPED_MULBERRY_WOOD = registerWithItem("stripped_mulberry_wood", RotatedPillarBlock::new, Blocks.logProperties(MapColor.TERRACOTTA_YELLOW, MapColor.TERRACOTTA_YELLOW, SoundType.WOOD));
        MULBERRY_PLANKS = registerWithItem("mulberry_planks", Block::new, Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .strength(2.0F, 3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .sound(SoundType.WOOD)
                .ignitedByLava());
        MULBERRY_STAIRS = registerWithItem("mulberry_stairs", p -> new StairBlock(MULBERRY_PLANKS.defaultBlockState(), p), Properties.ofFullCopy(MULBERRY_PLANKS));
        MULBERRY_SLAB = registerWithItem("mulberry_slab", SlabBlock::new, Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .strength(2.0F, 3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .sound(SoundType.WOOD)
                .ignitedByLava());
        MULBERRY_FENCE = registerWithItem("mulberry_fence", FenceBlock::new, Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .strength(2.0F, 3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .sound(SoundType.WOOD)
                .ignitedByLava());
        MULBERRY_FENCE_GATE = registerWithItem("mulberry_fence_gate", p -> new FenceGateBlock(VerdanceWoodTypes.MULBERRY, p), Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .forceSolidOn()
                .strength(2.0F, 3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .ignitedByLava());
        MULBERRY_DOOR = registerWithItem("mulberry_door", p -> new DoorBlock(VerdanceBlockSetTypes.MULBERRY, p), Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .strength(3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .noOcclusion()
                .pushReaction(PushReaction.DESTROY)
                .ignitedByLava());
        MULBERRY_TRAPDOOR = registerWithItem("mulberry_trapdoor", p -> new TrapDoorBlock(VerdanceBlockSetTypes.MULBERRY, p), Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .strength(3.0F)
                .instrument(NoteBlockInstrument.BASS)
                .isValidSpawn((state, getter, pos, type) -> false)
                .noOcclusion()
                .ignitedByLava());
        MULBERRY_PRESSURE_PLATE = registerWithItem("mulberry_pressure_plate", p -> new PressurePlateBlock(VerdanceBlockSetTypes.MULBERRY, p), Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .forceSolidOn()
                .strength(0.5f)
                .instrument(NoteBlockInstrument.BASS)
                .noCollision()
                .pushReaction(PushReaction.DESTROY)
                .ignitedByLava());
        MULBERRY_BUTTON = registerWithItem("mulberry_button", p -> new ButtonBlock(VerdanceBlockSetTypes.MULBERRY, 30, p), Blocks.buttonProperties());
        MULBERRY_SIGN = register("mulberry_sign", p -> new StandingSignBlock(VerdanceWoodTypes.MULBERRY, p), Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollision()
                .strength(1.0F)
                .ignitedByLava());
        MULBERRY_WALL_SIGN = register("mulberry_wall_sign", p -> new WallSignBlock(VerdanceWoodTypes.MULBERRY, p), Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollision()
                .strength(1.0F)
                .overrideLootTable(MULBERRY_SIGN.getLootTable())
                .ignitedByLava());
        MULBERRY_HANGING_SIGN = register("mulberry_hanging_sign", p -> new CeilingHangingSignBlock(VerdanceWoodTypes.MULBERRY, p), Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollision()
                .strength(1.0F)
                .ignitedByLava());
        MULBERRY_WALL_HANGING_SIGN = register("mulberry_wall_hanging_sign", p -> new WallHangingSignBlock(VerdanceWoodTypes.MULBERRY, p), Properties.of()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.BASS)
                .noCollision()
                .strength(1.0F)
                .overrideLootTable(MULBERRY_HANGING_SIGN.getLootTable())
                .ignitedByLava());
        MULBERRY_LEAVES = registerWithItem("mulberry_leaves", p -> new TintedParticleLeavesBlock(0.01f, p), Blocks.leavesProperties(SoundType.GRASS));
        FLOWERING_MULBERRY_LEAVES = registerWithItem("flowering_mulberry_leaves", p -> new TintedParticleLeavesBlock(0.01f, p), Blocks.leavesProperties(SoundType.GRASS));
        MULBERRY_SAPLING = register("mulberry_sapling", p -> new SaplingBlock(VerdanceSaplingGenerators.MULBERRY, p), Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollision()
                .randomTicks()
                .instabreak()
                .sound(SoundType.CROP)
                .pushReaction(PushReaction.DESTROY));
        POTTED_MULBERRY_SAPLING = register("potted_mulberry_sapling", p -> new FlowerPotBlock(MULBERRY_SAPLING, p), Blocks.flowerPotProperties());
        CANTALOUPE = registerWithItem("cantaloupe", Block::new, Properties.of()
                .mapColor(MapColor.COLOR_LIGHT_GREEN)
                .strength(1.0F)
                .sound(SoundType.WOOD));
        ATTACHED_CANTALOUPE_STEM = register("attached_cantaloupe_stem", p -> new AttachedStemBlock(
                VerdanceBlockRegistryKeys.CANTALOUPE_STEM,
                VerdanceBlockRegistryKeys.CANTALOUPE,
                VerdanceItemRegistryKeys.CANTALOUPE_SEEDS,
                BlockTags.SUPPORTS_MELON_STEM,
                p), Properties.of()
                .noCollision()
                .randomTicks()
                .instabreak()
                .sound(SoundType.HARD_CROP)
                .pushReaction(PushReaction.DESTROY));
        CANTALOUPE_STEM = register("cantaloupe_stem", p -> new StemBlock(
                VerdanceBlockRegistryKeys.CANTALOUPE,
                VerdanceBlockRegistryKeys.ATTACHED_CANTALOUPE_STEM,
                VerdanceItemRegistryKeys.CANTALOUPE_SEEDS,
                BlockTags.SUPPORTS_MELON_STEM,
                BlockTags.SUPPORTS_MELON_STEM_FRUIT,
                p), Properties.of()
                .noCollision()
                .randomTicks()
                .instabreak()
                .sound(SoundType.HARD_CROP)
                .pushReaction(PushReaction.DESTROY));
        WHITE_CUSHION = registerWithItem("white_cushion", CushionBlock::new, cushionProperties(DyeColor.WHITE));
        LIGHT_GRAY_CUSHION = registerWithItem("light_gray_cushion", CushionBlock::new, cushionProperties(DyeColor.LIGHT_GRAY));
        GRAY_CUSHION = registerWithItem("gray_cushion", CushionBlock::new, cushionProperties(DyeColor.GRAY));
        BLACK_CUSHION = registerWithItem("black_cushion", CushionBlock::new, cushionProperties(DyeColor.BLACK));
        BROWN_CUSHION = registerWithItem("brown_cushion", CushionBlock::new, cushionProperties(DyeColor.BROWN));
        RED_CUSHION = registerWithItem("red_cushion", CushionBlock::new, cushionProperties(DyeColor.RED));
        ORANGE_CUSHION = registerWithItem("orange_cushion", CushionBlock::new, cushionProperties(DyeColor.ORANGE));
        YELLOW_CUSHION = registerWithItem("yellow_cushion", CushionBlock::new, cushionProperties(DyeColor.YELLOW));
        LIME_CUSHION = registerWithItem("lime_cushion", CushionBlock::new, cushionProperties(DyeColor.LIME));
        GREEN_CUSHION = registerWithItem("green_cushion", CushionBlock::new, cushionProperties(DyeColor.GREEN));
        CYAN_CUSHION = registerWithItem("cyan_cushion", CushionBlock::new, cushionProperties(DyeColor.CYAN));
        LIGHT_BLUE_CUSHION = registerWithItem("light_blue_cushion", CushionBlock::new, cushionProperties(DyeColor.LIGHT_BLUE));
        BLUE_CUSHION = registerWithItem("blue_cushion", CushionBlock::new, cushionProperties(DyeColor.BLUE));
        PURPLE_CUSHION = registerWithItem("purple_cushion", CushionBlock::new, cushionProperties(DyeColor.PURPLE));
        MAGENTA_CUSHION = registerWithItem("magenta_cushion", CushionBlock::new, cushionProperties(DyeColor.MAGENTA));
        PINK_CUSHION = registerWithItem("pink_cushion", CushionBlock::new, cushionProperties(DyeColor.PINK));
        WHITE_STUCCO = registerStucco("white_stucco", DyeColor.WHITE);
        WHITE_STUCCO_STAIRS = registerStuccoStairs("white_stucco_stairs", WHITE_STUCCO);
        WHITE_STUCCO_SLAB = registerStuccoSlab("white_stucco_slab", WHITE_STUCCO);
        WHITE_STUCCO_WALL = registerStuccoWall("white_stucco_wall", WHITE_STUCCO);
        LIGHT_GRAY_STUCCO = registerStucco("light_gray_stucco", DyeColor.LIGHT_GRAY);
        LIGHT_GRAY_STUCCO_STAIRS = registerStuccoStairs("light_gray_stucco_stairs", LIGHT_GRAY_STUCCO);
        LIGHT_GRAY_STUCCO_SLAB = registerStuccoSlab("light_gray_stucco_slab", LIGHT_GRAY_STUCCO);
        LIGHT_GRAY_STUCCO_WALL = registerStuccoWall("light_gray_stucco_wall", LIGHT_GRAY_STUCCO);
        GRAY_STUCCO = registerStucco("gray_stucco", DyeColor.GRAY);
        GRAY_STUCCO_STAIRS = registerStuccoStairs("gray_stucco_stairs", GRAY_STUCCO);
        GRAY_STUCCO_SLAB = registerStuccoSlab("gray_stucco_slab", GRAY_STUCCO);
        GRAY_STUCCO_WALL = registerStuccoWall("gray_stucco_wall", GRAY_STUCCO);
        BLACK_STUCCO = registerStucco("black_stucco", DyeColor.BLACK);
        BLACK_STUCCO_STAIRS = registerStuccoStairs("black_stucco_stairs", BLACK_STUCCO);
        BLACK_STUCCO_SLAB = registerStuccoSlab("black_stucco_slab", BLACK_STUCCO);
        BLACK_STUCCO_WALL = registerStuccoWall("black_stucco_wall", BLACK_STUCCO);
        BROWN_STUCCO = registerStucco("brown_stucco", DyeColor.BROWN);
        BROWN_STUCCO_STAIRS = registerStuccoStairs("brown_stucco_stairs", BROWN_STUCCO);
        BROWN_STUCCO_SLAB = registerStuccoSlab("brown_stucco_slab", BROWN_STUCCO);
        BROWN_STUCCO_WALL = registerStuccoWall("brown_stucco_wall", BROWN_STUCCO);
        RED_STUCCO = registerStucco("red_stucco", DyeColor.RED);
        RED_STUCCO_STAIRS = registerStuccoStairs("red_stucco_stairs", RED_STUCCO);
        RED_STUCCO_SLAB = registerStuccoSlab("red_stucco_slab", RED_STUCCO);
        RED_STUCCO_WALL = registerStuccoWall("red_stucco_wall", RED_STUCCO);
        ORANGE_STUCCO = registerStucco("orange_stucco", DyeColor.ORANGE);
        ORANGE_STUCCO_STAIRS = registerStuccoStairs("orange_stucco_stairs", ORANGE_STUCCO);
        ORANGE_STUCCO_SLAB = registerStuccoSlab("orange_stucco_slab", ORANGE_STUCCO);
        ORANGE_STUCCO_WALL = registerStuccoWall("orange_stucco_wall", ORANGE_STUCCO);
        YELLOW_STUCCO = registerStucco("yellow_stucco", DyeColor.YELLOW);
        YELLOW_STUCCO_STAIRS = registerStuccoStairs("yellow_stucco_stairs", YELLOW_STUCCO);
        YELLOW_STUCCO_SLAB = registerStuccoSlab("yellow_stucco_slab", YELLOW_STUCCO);
        YELLOW_STUCCO_WALL = registerStuccoWall("yellow_stucco_wall", YELLOW_STUCCO);
        LIME_STUCCO = registerStucco("lime_stucco", DyeColor.LIME);
        LIME_STUCCO_STAIRS = registerStuccoStairs("lime_stucco_stairs", LIME_STUCCO);
        LIME_STUCCO_SLAB = registerStuccoSlab("lime_stucco_slab", LIME_STUCCO);
        LIME_STUCCO_WALL = registerStuccoWall("lime_stucco_wall", LIME_STUCCO);
        GREEN_STUCCO = registerStucco("green_stucco", DyeColor.GREEN);
        GREEN_STUCCO_STAIRS = registerStuccoStairs("green_stucco_stairs", GREEN_STUCCO);
        GREEN_STUCCO_SLAB = registerStuccoSlab("green_stucco_slab", GREEN_STUCCO);
        GREEN_STUCCO_WALL = registerStuccoWall("green_stucco_wall", GREEN_STUCCO);
        CYAN_STUCCO = registerStucco("cyan_stucco", DyeColor.CYAN);
        CYAN_STUCCO_STAIRS = registerStuccoStairs("cyan_stucco_stairs", CYAN_STUCCO);
        CYAN_STUCCO_SLAB = registerStuccoSlab("cyan_stucco_slab", CYAN_STUCCO);
        CYAN_STUCCO_WALL = registerStuccoWall("cyan_stucco_wall", CYAN_STUCCO);
        LIGHT_BLUE_STUCCO = registerStucco("light_blue_stucco", DyeColor.LIGHT_BLUE);
        LIGHT_BLUE_STUCCO_STAIRS = registerStuccoStairs("light_blue_stucco_stairs", LIGHT_BLUE_STUCCO);
        LIGHT_BLUE_STUCCO_SLAB = registerStuccoSlab("light_blue_stucco_slab", LIGHT_BLUE_STUCCO);
        LIGHT_BLUE_STUCCO_WALL = registerStuccoWall("light_blue_stucco_wall", LIGHT_BLUE_STUCCO);
        BLUE_STUCCO = registerStucco("blue_stucco", DyeColor.BLUE);
        BLUE_STUCCO_STAIRS = registerStuccoStairs("blue_stucco_stairs", BLUE_STUCCO);
        BLUE_STUCCO_SLAB = registerStuccoSlab("blue_stucco_slab", BLUE_STUCCO);
        BLUE_STUCCO_WALL = registerStuccoWall("blue_stucco_wall", BLUE_STUCCO);
        PURPLE_STUCCO = registerStucco("purple_stucco", DyeColor.PURPLE);
        PURPLE_STUCCO_STAIRS = registerStuccoStairs("purple_stucco_stairs", PURPLE_STUCCO);
        PURPLE_STUCCO_SLAB = registerStuccoSlab("purple_stucco_slab", PURPLE_STUCCO);
        PURPLE_STUCCO_WALL = registerStuccoWall("purple_stucco_wall", PURPLE_STUCCO);
        MAGENTA_STUCCO = registerStucco("magenta_stucco", DyeColor.MAGENTA);
        MAGENTA_STUCCO_STAIRS = registerStuccoStairs("magenta_stucco_stairs", MAGENTA_STUCCO);
        MAGENTA_STUCCO_SLAB = registerStuccoSlab("magenta_stucco_slab", MAGENTA_STUCCO);
        MAGENTA_STUCCO_WALL = registerStuccoWall("magenta_stucco_wall", MAGENTA_STUCCO);
        PINK_STUCCO = registerStucco("pink_stucco", DyeColor.PINK);
        PINK_STUCCO_STAIRS = registerStuccoStairs("pink_stucco_stairs", PINK_STUCCO);
        PINK_STUCCO_SLAB = registerStuccoSlab("pink_stucco_slab", PINK_STUCCO);
        PINK_STUCCO_WALL = registerStuccoWall("pink_stucco_wall", PINK_STUCCO);
        SILKWORM_EGGS = registerWithItem("silkworm_eggs", SilkWormEggsBlock::new, Properties.of()
                .mapColor(MapColor.COLOR_YELLOW)
                .sound(SoundType.FROGSPAWN)
                .instabreak()
                .noOcclusion()
                .noCollision()
                .pushReaction(PushReaction.DESTROY));
        SILK_COCOON = register("silk_cocoon", SilkCocoonBlock::new, Properties.of()
                .strength(0.8F)
                .sound(VerdanceBlockSoundGroups.silkCocoon()));
        VIOLET = registerWithItem("violet", p -> new FlowerBlock(MobEffects.REGENERATION, 8.0f, p), Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollision()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY));
        POTTED_VIOLET = register("potted_violet", p -> new FlowerPotBlock(VIOLET, p), Blocks.flowerPotProperties());
        SHRUB = registerWithItem("shrub", ShrubBlock::new, Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollision()
                .instabreak()
                .sound(SoundType.AZALEA)
                .ignitedByLava()
                .offsetType(OffsetType.XYZ)
                .pushReaction(PushReaction.DESTROY));
        POTTED_SHRUB = register("potted_shrub", p -> new FlowerPotBlock(SHRUB, p), Blocks.flowerPotProperties());
        YELLOW_FLOWERING_SHRUB = registerWithItem("yellow_flowering_shrub", p -> new FloweringShrubBlock(VerdanceConfiguredFeatures.PATCH_YELLOW_FLOWERING_SHRUB_BONEMEAL, p), Properties.ofFullCopy(SHRUB));
        POTTED_YELLOW_FLOWERING_SHRUB = register("potted_yellow_flowering_shrub", p -> new FlowerPotBlock(YELLOW_FLOWERING_SHRUB, p), Blocks.flowerPotProperties());
        PINK_FLOWERING_SHRUB = registerWithItem("pink_flowering_shrub", p -> new FloweringShrubBlock(VerdanceConfiguredFeatures.PATCH_PINK_FLOWERING_SHRUB_BONEMEAL, p), Properties.ofFullCopy(SHRUB));
        POTTED_PINK_FLOWERING_SHRUB = register("potted_pink_flowering_shrub", p -> new FlowerPotBlock(PINK_FLOWERING_SHRUB, p), Blocks.flowerPotProperties());

        for (Block block : BuiltInRegistries.BLOCK) {
            if (BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(Verdance.MOD_ID)) {
                for (BlockState state : block.getStateDefinition().getPossibleStates()) {
                    state.initCache();
                }
            }
        }
    }

    private static Block registerStucco(String name, DyeColor color) {
        return registerWithItem(name, Block::new, stuccoProperties(color));
    }

    private static Block registerStuccoStairs(String name, Block base) {
        return registerWithItem(name, p -> new StairBlock(base.defaultBlockState(), p), Properties.ofFullCopy(base));
    }

    private static Block registerStuccoSlab(String name, Block base) {
        return registerWithItem(name, SlabBlock::new, Properties.ofFullCopy(base));
    }

    private static Block registerStuccoWall(String name, Block base) {
        return registerWithItem(name, WallBlock::new, Properties.ofFullCopy(base));
    }

    private static Properties stuccoProperties(DyeColor color) {
        return Properties.of()
                .mapColor(color)
                .sound(VerdanceBlockSoundGroups.stucco())
                .requiresCorrectToolForDrops()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .strength(1.5F, 5.5F);
    }

    private static Properties cushionProperties(DyeColor color) {
        return Properties.of()
                .mapColor(color)
                .sound(SoundType.WOOD)
                .strength(0.2f)
                .noCollision()
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY);
    }

    private static Block registerWithItem(String name, Function<Properties, Block> factory, Properties props) {
        Block block = register(name, factory, props);
        registerBlockItem(name, block);
        return block;
    }

    private static Block register(String name, Function<Properties, Block> factory, Properties props) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Verdance.id(name));
        Block block = factory.apply(props.setId(key));
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Verdance.id(name));
        BlockItem item = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(key));
        item.registerBlocks(Item.BY_BLOCK, item);
        Registry.register(BuiltInRegistries.ITEM, key, item);
    }
}
