package com.teamabode.verdance.common.item;

import com.teamabode.verdance.core.registry.VerdanceTriggerTypes;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CantaloupeJuiceItem extends Item {

    public CantaloupeJuiceItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        boolean wasOnFire = user.isOnFire();
        ItemStack result = super.finishUsingItem(stack, world, user);

        if (user instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            if (wasOnFire) {
                VerdanceTriggerTypes.EXTINGUISHED_WITH_CANTALOUPE_JUICE.trigger(serverPlayer);
            }
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }
        if (!world.isClientSide() && wasOnFire) {
            world.playSound(null, user.blockPosition(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.25f, 1.0f);
            CantaloupeSliceItem.addCoolingParticles((ServerLevel) world, user);
            user.clearFire();
        }
        return result;
    }
}
