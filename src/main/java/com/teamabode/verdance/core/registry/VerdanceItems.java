package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.common.item.CantaloupeJuiceItem;
import com.teamabode.verdance.common.item.CantaloupeSliceItem;
import com.teamabode.verdance.core.misc.VerdanceFoodComponents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.DiscFragmentItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.component.Consumables;

import java.util.function.Function;

public class VerdanceItems {
    public static Item CANTALOUPE_SLICE;
    public static Item GRILLED_CANTALOUPE_SLICE;
    public static Item CANTALOUPE_JUICE;
    public static Item CANTALOUPE_SEEDS;
    public static Item MULBERRY;
    public static Item MULBERRY_SIGN;
    public static Item MULBERRY_HANGING_SIGN;
    public static Item MULBERRY_BOAT;
    public static Item MULBERRY_CHEST_BOAT;
    public static Item MUSIC_DISC_RANGE;
    public static Item DISC_FRAGMENT_RANGE;
    public static Item ABODE_POTTERY_SHERD;
    public static Item FRILLS_POTTERY_SHERD;
    public static Item PITCH_POTTERY_SHERD;
    public static Item PRICKLE_POTTERY_SHERD;
    public static Item SPIRIT_POTTERY_SHERD;
    public static Item TRAP_POTTERY_SHERD;
    public static Item HERITAGE_ARMOR_TRIM_SMITHING_TEMPLATE;
    public static Item SILK_MOTH_SPAWN_EGG;
    public static Item SILKWORM_SPAWN_EGG;

    public static void register() {
        CANTALOUPE_SLICE = register("cantaloupe_slice", CantaloupeSliceItem::new, new Item.Properties().food(VerdanceFoodComponents.CANTALOUPE_SLICE));
        GRILLED_CANTALOUPE_SLICE = register("grilled_cantaloupe_slice", CantaloupeSliceItem::new, new Item.Properties().food(VerdanceFoodComponents.GRILLED_CANTALOUPE_SLICE));
        CANTALOUPE_JUICE = register("cantaloupe_juice", CantaloupeJuiceItem::new, new Item.Properties()
                .food(VerdanceFoodComponents.CANTALOUPE_JUICE, Consumables.DEFAULT_DRINK)
                .usingConvertsTo(Items.GLASS_BOTTLE)
                .stacksTo(16));
        CANTALOUPE_SEEDS = register("cantaloupe_seeds", p -> new BlockItem(VerdanceBlocks.CANTALOUPE_STEM, p.useItemDescriptionPrefix()), new Item.Properties());
        MULBERRY = register("mulberry", p -> new BlockItem(VerdanceBlocks.MULBERRY_SAPLING, p.useItemDescriptionPrefix()), new Item.Properties()
                .food(VerdanceFoodComponents.MULBERRY));
        MULBERRY_SIGN = register("mulberry_sign", p -> new SignItem(VerdanceBlocks.MULBERRY_SIGN, VerdanceBlocks.MULBERRY_WALL_SIGN, p), new Item.Properties().useBlockDescriptionPrefix().stacksTo(16));
        MULBERRY_HANGING_SIGN = register("mulberry_hanging_sign", p -> new HangingSignItem(VerdanceBlocks.MULBERRY_HANGING_SIGN, VerdanceBlocks.MULBERRY_WALL_HANGING_SIGN, p), new Item.Properties().useBlockDescriptionPrefix().stacksTo(16));
        MULBERRY_BOAT = register("mulberry_boat", p -> new BoatItem(VerdanceEntityTypes.MULBERRY_BOAT, p), new Item.Properties().stacksTo(1));
        MULBERRY_CHEST_BOAT = register("mulberry_chest_boat", p -> new BoatItem(VerdanceEntityTypes.MULBERRY_CHEST_BOAT, p), new Item.Properties().stacksTo(1));
        MUSIC_DISC_RANGE = register("music_disc_range", new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
                .jukeboxPlayable(VerdanceJukeboxSongs.RANGE));
        DISC_FRAGMENT_RANGE = register("disc_fragment_range", DiscFragmentItem::new, new Item.Properties());
        ABODE_POTTERY_SHERD = register("abode_pottery_sherd");
        FRILLS_POTTERY_SHERD = register("frills_pottery_sherd");
        PITCH_POTTERY_SHERD = register("pitch_pottery_sherd");
        PRICKLE_POTTERY_SHERD = register("prickle_pottery_sherd");
        SPIRIT_POTTERY_SHERD = register("spirit_pottery_sherd");
        TRAP_POTTERY_SHERD = register("trap_pottery_sherd");
        HERITAGE_ARMOR_TRIM_SMITHING_TEMPLATE = register("heritage_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, new Item.Properties());
        SILK_MOTH_SPAWN_EGG = register("silk_moth_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(VerdanceEntityTypes.SILK_MOTH));
        SILKWORM_SPAWN_EGG = register("silkworm_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(VerdanceEntityTypes.SILKWORM));
    }

    private static Item register(String name) {
        return register(name, Item::new, new Item.Properties());
    }

    private static Item register(String name, Item.Properties properties) {
        return register(name, Item::new, properties);
    }

    private static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Verdance.id(name));
        return Registry.register(BuiltInRegistries.ITEM, key, factory.apply(properties.setId(key)));
    }
}
