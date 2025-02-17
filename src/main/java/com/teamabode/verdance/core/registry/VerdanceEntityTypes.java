package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.common.entity.CushionEntity;
import com.teamabode.verdance.common.entity.silkmoth.SilkMoth;
import com.teamabode.verdance.common.entity.silkworm.Silkworm;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.levelgen.Heightmap;

public class VerdanceEntityTypes {

    public static final EntityType<SilkMoth> SILK_MOTH = register(
            "silk_moth",
            EntityType.Builder.of(SilkMoth::new, MobCategory.CREATURE).sized(0.7f, 0.7f).eyeHeight(0.35f).build("silk_moth")
    );

    public static final EntityType<Silkworm> SILKWORM = register(
            "silkworm",
            EntityType.Builder.of(Silkworm::new, MobCategory.CREATURE).sized(0.6f, 0.25f).build("silkworm")
    );

    public static final EntityType<CushionEntity> CUSHION = register(
            "cushion",
            EntityType.Builder.of(CushionEntity::new, MobCategory.MISC).noSummon().sized(0.6f, 0.25f).build("cushion")
    );

    private static <E extends Entity, T extends EntityType<E>> EntityType<E> register(String name, T entity) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, Verdance.id(name), entity);
    }

    public static void register() {
        SpawnPlacements.register(SILK_MOTH, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, SilkMoth::checkSilkMothSpawnRules);
        FabricDefaultAttributeRegistry.register(SILK_MOTH, SilkMoth.createSilkMothAttributes());
        FabricDefaultAttributeRegistry.register(SILKWORM, Silkworm.createSilkwormAttributes());
    }
}
