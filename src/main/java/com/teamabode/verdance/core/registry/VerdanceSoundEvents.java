package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class VerdanceSoundEvents {
    public static SoundEvent BLOCK_STUCCO_BREAK;
    public static SoundEvent BLOCK_STUCCO_FALL;
    public static SoundEvent BLOCK_STUCCO_HIT;
    public static SoundEvent BLOCK_STUCCO_STEP;
    public static SoundEvent BLOCK_STUCCO_PLACE;

    public static SoundEvent ENTITY_SILK_MOTH_IDLE;
    public static SoundEvent ENTITY_SILK_MOTH_HURT;
    public static SoundEvent ENTITY_SILK_MOTH_EAT;
    public static SoundEvent ENTITY_SILK_MOTH_EMERGE;
    public static SoundEvent ENTITY_SILK_MOTH_DEATH;

    public static SoundEvent ENTITY_SILKWORM_HURT;
    public static SoundEvent ENTITY_SILKWORM_DEATH;

    public static SoundEvent BLOCK_SILK_COCOON_BREAK;
    public static SoundEvent BLOCK_SILK_COCOON_FALL;
    public static SoundEvent BLOCK_SILK_COCOON_HIT;
    public static SoundEvent BLOCK_SILK_COCOON_PLACE;
    public static SoundEvent BLOCK_SILK_COCOON_STEP;
    public static SoundEvent BLOCK_SILK_COCOON_WOBBLE;

    public static Holder<SoundEvent> MUSIC_DISC_RANGE;

    public static void register() {
        BLOCK_STUCCO_BREAK = register("block.stucco.break");
        BLOCK_STUCCO_FALL = register("block.stucco.fall");
        BLOCK_STUCCO_HIT = register("block.stucco.hit");
        BLOCK_STUCCO_STEP = register("block.stucco.step");
        BLOCK_STUCCO_PLACE = register("block.stucco.place");

        ENTITY_SILK_MOTH_IDLE = register("entity.silk_moth.idle");
        ENTITY_SILK_MOTH_HURT = register("entity.silk_moth.hurt");
        ENTITY_SILK_MOTH_EAT = register("entity.silk_moth.eat");
        ENTITY_SILK_MOTH_EMERGE = register("entity.silk_moth.emerge");
        ENTITY_SILK_MOTH_DEATH = register("entity.silk_moth.death");

        ENTITY_SILKWORM_HURT = register("entity.silkworm.hurt");
        ENTITY_SILKWORM_DEATH = register("entity.silkworm.death");

        BLOCK_SILK_COCOON_BREAK = register("block.silk_cocoon.break");
        BLOCK_SILK_COCOON_FALL = register("block.silk_cocoon.fall");
        BLOCK_SILK_COCOON_HIT = register("block.silk_cocoon.hit");
        BLOCK_SILK_COCOON_PLACE = register("block.silk_cocoon.place");
        BLOCK_SILK_COCOON_STEP = register("block.silk_cocoon.step");
        BLOCK_SILK_COCOON_WOBBLE = register("block.silk_cocoon.wobble");

        MUSIC_DISC_RANGE = registerHolder("music_disc.range");
    }

    private static SoundEvent register(String name) {
        Identifier id = Verdance.id(name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    private static Holder<SoundEvent> registerHolder(String name) {
        Identifier id = Verdance.id(name);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }
}
