package com.teamabode.verdance.core.mixin;

import com.teamabode.verdance.core.level.VerdanceBiomeReplacements;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.stream.Stream;

@Mixin(MultiNoiseBiomeSource.class)
public class MultiNoiseBiomeSourceMixin {

    @Inject(method = "getNoiseBiome(IIILnet/minecraft/world/level/biome/Climate$Sampler;)Lnet/minecraft/core/Holder;", at = @At("RETURN"), cancellable = true)
    private void verdance$replaceBiome(int quartX, int quartY, int quartZ, Climate.Sampler sampler, CallbackInfoReturnable<Holder<Biome>> cir) {
        Holder<Biome> original = cir.getReturnValue();
        Holder<Biome> replacement = VerdanceBiomeReplacements.replace(original, quartX, quartZ);
        if (replacement != original) {
            cir.setReturnValue(replacement);
        }
    }

    @Inject(method = "collectPossibleBiomes", at = @At("RETURN"), cancellable = true)
    private void verdance$addReplacementBiomes(CallbackInfoReturnable<Stream<Holder<Biome>>> cir) {
        List<Holder<Biome>> base = cir.getReturnValue().toList();
        List<Holder<Biome>> additions = VerdanceBiomeReplacements.additionsFor(base);
        if (additions.isEmpty()) {
            cir.setReturnValue(base.stream());
        } else {
            cir.setReturnValue(Stream.concat(base.stream(), additions.stream()));
        }
    }
}
