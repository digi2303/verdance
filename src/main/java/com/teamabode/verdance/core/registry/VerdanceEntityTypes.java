package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.common.entity.CushionEntity;
import com.teamabode.verdance.common.entity.silkmoth.SilkMoth;
import com.teamabode.verdance.common.entity.silkworm.Silkworm;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;

public class VerdanceEntityTypes {
    public static EntityType<SilkMoth> SILK_MOTH;
    public static EntityType<Silkworm> SILKWORM;
    public static EntityType<CushionEntity> CUSHION;
    public static EntityType<Boat> MULBERRY_BOAT;
    public static EntityType<ChestBoat> MULBERRY_CHEST_BOAT;

    public static void register() {
        SILK_MOTH = register(
                "silk_moth",
                EntityType.Builder.of(SilkMoth::new, MobCategory.CREATURE).sized(0.7f, 0.7f).eyeHeight(0.35f)
        );
        SILKWORM = register(
                "silkworm",
                EntityType.Builder.of(Silkworm::new, MobCategory.CREATURE).sized(0.6f, 0.25f)
        );
        CUSHION = register(
                "cushion",
                EntityType.Builder.<CushionEntity>of(CushionEntity::new, MobCategory.MISC).noSummon().sized(0.6f, 0.25f)
        );
        MULBERRY_BOAT = register(
                "mulberry_boat",
                EntityType.Builder.<Boat>of((type, level) -> new Boat(type, level, () -> VerdanceItems.MULBERRY_BOAT), MobCategory.MISC)
                        .noLootTable().sized(1.375f, 0.5625f).eyeHeight(0.5625f).clientTrackingRange(10)
        );
        MULBERRY_CHEST_BOAT = register(
                "mulberry_chest_boat",
                EntityType.Builder.<ChestBoat>of((type, level) -> new ChestBoat(type, level, () -> VerdanceItems.MULBERRY_CHEST_BOAT), MobCategory.MISC)
                        .noLootTable().sized(1.375f, 0.5625f).eyeHeight(0.5625f).clientTrackingRange(10)
        );
    }

    private static <E extends Entity> EntityType<E> register(String name, EntityType.Builder<E> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Verdance.id(name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }
}
