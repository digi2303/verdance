package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.core.registry.misc.VerdanceFoods;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class VerdanceItems {
    public static final Item CANTALOUPE_SLICE = register("cantaloupe_slice", new Item((new Item.Properties()).food(VerdanceFoods.CANTALOUPE_SLICE)));
    public static final Item CANTALOUPE_SEEDS = register("cantaloupe_seeds", new ItemNameBlockItem(VerdanceBlocks.CANTALOUPE_STEM, new Item.Properties()));

    public static final Item MUSIC_DISC_RANGE = register("music_disc_range", new RecordItem(1, VerdanceSounds.MUSIC_DISC_RANGE, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 87));
    public static final Item DISC_FRAGMENT_RANGE = register("disc_fragment_range", new DiscFragmentItem(new Item.Properties()));

    private static <T extends Item> T register(String name, T item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Verdance.MOD_ID, name), item);
    }

    public static void register() {

    }
}
