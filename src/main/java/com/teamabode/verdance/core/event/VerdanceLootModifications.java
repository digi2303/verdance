package com.teamabode.verdance.core.event;

import com.teamabode.verdance.impl.platform.CommonAbstraction;

public class VerdanceLootModifications {
    public static void register() {
        CommonAbstraction.INSTANCE.injectChestLoot();
    }
}
