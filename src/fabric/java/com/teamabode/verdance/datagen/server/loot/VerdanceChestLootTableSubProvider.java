package com.teamabode.verdance.datagen.server.loot;

import com.teamabode.verdance.core.registry.VerdanceItems;
import com.teamabode.verdance.core.registry.VerdanceLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class VerdanceChestLootTableSubProvider implements LootTableSubProvider {
    private final HolderLookup.Provider registries;

    public VerdanceChestLootTableSubProvider(HolderLookup.Provider registries) {
        this.registries = registries;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> exporter) {
        exporter.accept(VerdanceLootTables.CHESTS_CANTALOUPE_SEEDS, this.createCantaloupeSeeds());
    }

    private LootTable.Builder createCantaloupeSeeds() {
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0f))
                .add(LootItem.lootTableItem(VerdanceItems.CANTALOUPE_SEEDS)
                        .setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 5.0f), false)))
                .add(EmptyLootItem.emptyItem().setWeight(5)));
    }
}
