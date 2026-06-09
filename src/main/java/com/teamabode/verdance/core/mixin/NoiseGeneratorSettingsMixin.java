package com.teamabode.verdance.core.mixin;

import com.teamabode.verdance.core.level.VerdanceSurfaceRuleRegistry;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin {
    @Unique
    private volatile SurfaceRules.RuleSource verdance$wrappedSurfaceRule;

    @Inject(method = "surfaceRule", at = @At("RETURN"), cancellable = true)
    private void verdance$appendSurfaceRules(CallbackInfoReturnable<SurfaceRules.RuleSource> cir) {
        List<SurfaceRules.RuleSource> extra = VerdanceSurfaceRuleRegistry.rules();
        if (extra.isEmpty()) {
            return;
        }
        SurfaceRules.RuleSource wrapped = this.verdance$wrappedSurfaceRule;
        if (wrapped == null) {
            SurfaceRules.RuleSource[] sequence = new SurfaceRules.RuleSource[extra.size() + 1];
            for (int i = 0; i < extra.size(); i++) {
                sequence[i] = extra.get(i);
            }
            sequence[extra.size()] = cir.getReturnValue();
            wrapped = SurfaceRules.sequence(sequence);
            this.verdance$wrappedSurfaceRule = wrapped;
        }
        cir.setReturnValue(wrapped);
    }
}
