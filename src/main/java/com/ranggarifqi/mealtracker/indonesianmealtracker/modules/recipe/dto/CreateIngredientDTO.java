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

  public CreateIngredientDTO(String name, float servingQty, String servingUnit, double servingWeightInGram, Nutrition nutrition, IngredientMetadata metadata) {
    this.name = name;
    this.servingQty = servingQty;
    this.servingUnit = servingUnit;
    this.servingWeightInGram = servingWeightInGram;
    this.nutrition = nutrition;
    this.metadata = metadata;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getServingQty() {
    return servingQty;
  }

  public void setServingQty(float servingQty) {
    this.servingQty = servingQty;
  }

  public String getServingUnit() {
    return servingUnit;
  }

  public void setServingUnit(String servingUnit) {
    this.servingUnit = servingUnit;
  }

  public double getServingWeightInGram() {
    return servingWeightInGram;
  }

  public void setServingWeightInGram(double servingWeightInGram) {
    this.servingWeightInGram = servingWeightInGram;
  }

  public Nutrition getNutrition() {
    return nutrition;
  }

  public void setNutrition(Nutrition nutrition) {
    this.nutrition = nutrition;
  }

  public IngredientMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(IngredientMetadata metadata) {
    this.metadata = metadata;
  }
}
