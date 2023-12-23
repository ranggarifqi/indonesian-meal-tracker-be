package com.ranggarifqi.mealtracker.indonesianmealtracker.models.records;

public record IngredientMetadata(
  float originalServingQty,
  String originalServingUnit,
  double originalServingWeightInGram,
  Nutrition originalNutrients,
  AltMeasurement[] altMeasurements
) {}

