package com.teamabode.verdance.impl.platform.neo;

import com.teamabode.verdance.Verdance;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Verdance.MOD_ID)
public class VerdanceNeoMod {
    public VerdanceNeoMod(IEventBus modBus) {
        NeoCommonAbstraction.EVENT_BUS = modBus;
        for (var a : NeoCommonAbstraction.INSTANCE.lateActions()) {
            a.accept(modBus);
        }
        NeoCommonAbstraction.INSTANCE.lateActions().clear();
    }
}
