package com.teamabode.verdance.core.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.common.entity.silkmoth.SilkMothAi;
import com.teamabode.verdance.common.entity.silkmoth.sensor.SilkMothSpecificSensor;
import com.teamabode.verdance.common.entity.silkworm.SilkwormBrain;
import com.teamabode.verdance.common.entity.silkworm.sensor.SilkwormSpecificSensor;
import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.ai.sensing.TemptingSensor;

public class VerdanceSensorTypes {
    public static SensorType<SilkMothSpecificSensor> SILK_MOTH_SPECIFIC_SENSOR;
    public static SensorType<SilkwormSpecificSensor> SILKWORM_SPECIFIC_SENSOR;
    public static SensorType<TemptingSensor> SILK_MOTH_TEMPTATIONS;
    public static SensorType<TemptingSensor> SILKWORM_TEMPTATIONS;

    public static void register() {
        SILK_MOTH_SPECIFIC_SENSOR = register("silk_moth_specific_sensor", SilkMothSpecificSensor::new);
        SILKWORM_SPECIFIC_SENSOR = register("silkworm_specific_sensor", SilkwormSpecificSensor::new);
        SILK_MOTH_TEMPTATIONS = register("silk_moth_temptations", () -> new TemptingSensor(SilkMothAi.getTemptations()));
        SILKWORM_TEMPTATIONS = register("silkworm_temptations", () -> new TemptingSensor(SilkwormBrain.getTemptations()));
    }

    private static <U extends Sensor<?>> SensorType<U> register(String name, Supplier<U> factory) {
        return Registry.register(BuiltInRegistries.SENSOR_TYPE, Verdance.id(name), new SensorType<>(factory));
    }
}
