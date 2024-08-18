package com.teamabode.verdance.core.misc;

import net.minecraft.world.food.FoodConstants;
import net.minecraft.world.food.FoodProperties;

public class VerdanceFoods {
    public static final FoodProperties CANTALOUPE_SLICE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(FoodConstants.FOOD_SATURATION_POOR)
            .alwaysEdible()
            .build();

    public static final FoodProperties GRILLED_CANTALOUPE_SLICE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(FoodConstants.FOOD_SATURATION_LOW)
            .build();

    public static final FoodProperties CANTALOUPE_JUICE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(FoodConstants.FOOD_SATURATION_POOR)
            .build();

    public static final FoodProperties MULBERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(FoodConstants.FOOD_SATURATION_POOR)
            .build();
}
