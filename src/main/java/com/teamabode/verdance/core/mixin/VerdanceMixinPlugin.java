package com.teamabode.verdance.core.mixin;

import com.teamabode.verdance.Verdance;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class VerdanceMixinPlugin implements IMixinConfigPlugin {
    public void onLoad(String mixinPackage) {}

    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains("SugarCaneBlock")) {
            boolean isEnabled = Verdance.CONFIG.getGroup("general").getBooleanProperty("bonemealable_sugar_cane");

            return isEnabled;
        }
        return true;
    }

    public String getRefMapperConfig() { return null; }

    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    public List<String> getMixins() {
        return null;
    }

    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
