package com.teamabode.verdance.core.registry;

import com.teamabode.sketch.common.item.SketchBoatItem;
import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.common.item.CantaloupeJuiceItem;
import com.teamabode.verdance.core.misc.VerdanceFoods;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;

public class VerdanceItems {
    public static final Item CANTALOUPE_SLICE = register(
            "cantaloupe_slice",
            new Properties()
                    .food(VerdanceFoods.CANTALOUPE_SLICE)
    );
    public static final Item GRILLED_CANTALOUPE_SLICE = register(
            "grilled_cantaloupe_slice",
            new Properties()
                    .food(VerdanceFoods.GRILLED_CANTALOUPE_SLICE)
    );
    public static final Item CANTALOUPE_JUICE = register(
            "cantaloupe_juice",
            new CantaloupeJuiceItem(new Properties()
                    .food(VerdanceFoods.CANTALOUPE_JUICE)
                    .stacksTo(16))
    );
    public static final Item CANTALOUPE_SEEDS = register(
            "cantaloupe_seeds",
            new ItemNameBlockItem(VerdanceBlocks.CANTALOUPE_STEM, new Properties())
    );
    public static final Item MULBERRY = register(
            "mulberry",
            new ItemNameBlockItem(VerdanceBlocks.MULBERRY_SAPLING, new Properties()
                    .food(VerdanceFoods.MULBERRY))
    );
    public static final Item MULBERRY_SIGN = register(
            "mulberry_sign",
            new SignItem(
                    new Properties().stacksTo(16),
                    VerdanceBlocks.MULBERRY_SIGN,
                    VerdanceBlocks.MULBERRY_WALL_SIGN)
    );
    public static final Item MULBERRY_HANGING_SIGN = register(
            "mulberry_hanging_sign",
            new HangingSignItem(VerdanceBlocks.MULBERRY_HANGING_SIGN, VerdanceBlocks.MULBERRY_WALL_HANGING_SIGN, new Properties()
                    .stacksTo(16))
    );
    public static final Item MULBERRY_BOAT = register(
            "mulberry_boat", new SketchBoatItem(
                    new Properties().stacksTo(1),
                    VerdanceBoatTypes.MULBERRY,
                    false)
    );
    public static final Item MULBERRY_CHEST_BOAT = register(
            "mulberry_chest_boat",
            new SketchBoatItem(
                    new Properties().stacksTo(1),
                    VerdanceBoatTypes.MULBERRY,
                    true)
    );
    public static final Item MUSIC_DISC_RANGE = register(
            "music_disc_range",
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(VerdanceJukeboxSongs.RANGE)
    );
    public static final Item DISC_FRAGMENT_RANGE = register("disc_fragment_range");
    public static final Item ABODE_POTTERY_SHERD = register("abode_pottery_sherd");
    public static final Item PITCH_POTTERY_SHERD = register("pitch_pottery_sherd");
    public static final Item PRICKLE_POTTERY_SHERD = register("prickle_pottery_sherd");
    public static final Item SPIRIT_POTTERY_SHERD = register("spirit_pottery_sherd");
    public static final Item TRAP_POTTERY_SHERD = register("trap_pottery_sherd");

    public static final Item SILK_MOTH_SPAWN_EGG = register(
            "silk_moth_spawn_egg",
            new SpawnEggItem(VerdanceEntityTypes.SILK_MOTH, 13542773, 16383172, new Properties())
    );
    public static final Item SILKWORM_SPAWN_EGG = register(
            "silkworm_spawn_egg",
            new SpawnEggItem(VerdanceEntityTypes.SILKWORM, 0xEBEDE6, 0x75665D, new Properties())
    );

    public static void register() {
        CompostingChanceRegistry.INSTANCE.add(VerdanceBlocks.CANTALOUPE, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(CANTALOUPE_SEEDS, 0.30F);
        CompostingChanceRegistry.INSTANCE.add(CANTALOUPE_SLICE, 0.50F);
        CompostingChanceRegistry.INSTANCE.add(VerdanceBlocks.FLOWERING_MULBERRY_LEAVES, 0.50F);
        CompostingChanceRegistry.INSTANCE.add(GRILLED_CANTALOUPE_SLICE, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(MULBERRY, 0.30F);
        CompostingChanceRegistry.INSTANCE.add(VerdanceBlocks.MULBERRY_LEAVES, 0.30F);
    }

    // Utils
    private static Item register(String name) {
        return register(name, new Properties());
    }

    private static Item register(String name, Properties properties) {
        return register(name, new Item(properties));
    }

    private static <T extends Item> T register(String name, T item) {
        return Registry.register(BuiltInRegistries.ITEM, Verdance.id(name), item);
    }
}
