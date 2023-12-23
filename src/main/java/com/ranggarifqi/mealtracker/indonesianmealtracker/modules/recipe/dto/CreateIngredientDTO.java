package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.records.IngredientMetadata;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.records.Nutrition;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class CreateIngredientDTO {
  @NotBlank(message = "name is mandatory")
  private String name;

  @NotBlank(message = "servingQty is mandatory")
  @PositiveOrZero(message = "servingQty must be >= 0")
  private float servingQty;

  @NotBlank(message = "servingQty is mandatory")
  private String servingUnit;

  @PositiveOrZero(message = "servingQty must be >= 0")
  private double servingWeightInGram;

  private Nutrition nutrition;

  private IngredientMetadata metadata;
}
