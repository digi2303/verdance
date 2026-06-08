package com.teamabode.verdance;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;

public class Verdance {
    public static final String MOD_ID = "verdance";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }
}
