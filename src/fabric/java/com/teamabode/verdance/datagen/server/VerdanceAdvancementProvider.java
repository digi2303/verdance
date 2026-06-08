package com.teamabode.verdance.datagen.server;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.common.trigger.SilkwormEggsDestroyedCriterion;
import com.teamabode.verdance.core.registry.VerdanceBlocks;
import com.teamabode.verdance.core.registry.VerdanceItems;
import com.teamabode.verdance.core.registry.VerdanceTriggerTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.DataComponentMatchers;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.predicates.DataComponentPredicates;
import net.minecraft.core.component.predicates.EnchantmentsPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class VerdanceAdvancementProvider extends FabricAdvancementProvider {

    public VerdanceAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer) {
        silkTouched(registries, consumer);
        feelingFresh(consumer);
    }

    private void silkTouched(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer) {
        Advancement.Builder advancement = Advancement.Builder.advancement();
        advancement.display(
                VerdanceBlocks.SILKWORM_EGGS,
                Component.translatable("advancements.verdance.husbandry.silk_touched.title"),
                Component.translatable("advancements.verdance.husbandry.silk_touched.description"),
                null,
                AdvancementType.TASK,
                true, true, false
        );
        var enchantments = registries.lookupOrThrow(Registries.ENCHANTMENT);
        ItemPredicate.Builder item = ItemPredicate.Builder.item().withComponents(
                DataComponentMatchers.Builder.components()
                        .partial(DataComponentPredicates.ENCHANTMENTS, EnchantmentsPredicate.enchantments(List.of(
                                new EnchantmentPredicate(enchantments.getOrThrow(Enchantments.SILK_TOUCH), MinMaxBounds.Ints.atLeast(1))
                        )))
                        .build()
        );
        advancement.parent(Identifier.withDefaultNamespace("husbandry/root"));
        advancement.addCriterion("silk_touch_silkworm_eggs", SilkwormEggsDestroyedCriterion.TriggerInstance.createCriterion(item));
        advancement.requirements(AdvancementRequirements.Strategy.AND);
        advancement.save(consumer, Verdance.id("husbandry/silk_touched").toString());
    }

    private void feelingFresh(Consumer<AdvancementHolder> consumer) {
        Advancement.Builder advancement = Advancement.Builder.advancement();
        advancement.display(
                VerdanceItems.CANTALOUPE_JUICE,
                Component.translatable("advancements.verdance.husbandry.feeling_fresh.title"),
                Component.translatable("advancements.verdance.husbandry.feeling_fresh.description"),
                null,
                AdvancementType.TASK,
                true, true, false
        );
        advancement.parent(Identifier.withDefaultNamespace("husbandry/root"));
        advancement.addCriterion("extinguished_with_cantaloupe_juice", VerdanceTriggerTypes.EXTINGUISHED_WITH_CANTALOUPE_JUICE.createCriterion(new PlayerTrigger.TriggerInstance(Optional.empty())));
        advancement.requirements(AdvancementRequirements.Strategy.AND);
        advancement.save(consumer, Verdance.id("husbandry/feeling_fresh").toString());
    }
}
