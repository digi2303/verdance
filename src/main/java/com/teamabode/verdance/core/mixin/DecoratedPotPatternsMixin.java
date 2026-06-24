package com.teamabode.verdance.core.mixin;

import com.teamabode.verdance.core.registry.VerdanceDecoratedPotPatterns;
import com.teamabode.verdance.core.registry.VerdanceItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotPatterns.class)
public class DecoratedPotPatternsMixin {

//? if >=26.2 {
/*@Inject(method = "itemToPatternMappings", at = @At("HEAD"))
    private static void verdance$itemToPatternMappings(java.util.function.BiConsumer<ResourceKey<Item>, ResourceKey<DecoratedPotPattern>> consumer, org.spongepowered.asm.mixin.injection.callback.CallbackInfo ci) {
        consumer.accept(VerdanceItems.ABODE_POTTERY_SHERD.builtInRegistryHolder().key(), VerdanceDecoratedPotPatterns.ABODE);
        consumer.accept(VerdanceItems.FRILLS_POTTERY_SHERD.builtInRegistryHolder().key(), VerdanceDecoratedPotPatterns.FRILLS);
        consumer.accept(VerdanceItems.PITCH_POTTERY_SHERD.builtInRegistryHolder().key(), VerdanceDecoratedPotPatterns.PITCH);
        consumer.accept(VerdanceItems.PRICKLE_POTTERY_SHERD.builtInRegistryHolder().key(), VerdanceDecoratedPotPatterns.PRICKLE);
        consumer.accept(VerdanceItems.SPIRIT_POTTERY_SHERD.builtInRegistryHolder().key(), VerdanceDecoratedPotPatterns.SPIRIT);
        consumer.accept(VerdanceItems.TRAP_POTTERY_SHERD.builtInRegistryHolder().key(), VerdanceDecoratedPotPatterns.TRAP);
    }
*///?} else {
    @Inject(method = "getPatternFromItem", at = @At("HEAD"), cancellable = true)
    private static void verdance$getPatternFromItem(Item item, CallbackInfoReturnable<ResourceKey<DecoratedPotPattern>> cir) {
        if (item == VerdanceItems.ABODE_POTTERY_SHERD) {
            cir.setReturnValue(VerdanceDecoratedPotPatterns.ABODE);
        }
        if (item == VerdanceItems.FRILLS_POTTERY_SHERD) {
            cir.setReturnValue(VerdanceDecoratedPotPatterns.FRILLS);
        }
        if (item == VerdanceItems.PITCH_POTTERY_SHERD) {
            cir.setReturnValue(VerdanceDecoratedPotPatterns.PITCH);
        }
        if (item == VerdanceItems.PRICKLE_POTTERY_SHERD) {
            cir.setReturnValue(VerdanceDecoratedPotPatterns.PRICKLE);
        }
        if (item == VerdanceItems.SPIRIT_POTTERY_SHERD) {
            cir.setReturnValue(VerdanceDecoratedPotPatterns.SPIRIT);
        }
        if (item == VerdanceItems.TRAP_POTTERY_SHERD) {
            cir.setReturnValue(VerdanceDecoratedPotPatterns.TRAP);
        }
    }
//?}
}
