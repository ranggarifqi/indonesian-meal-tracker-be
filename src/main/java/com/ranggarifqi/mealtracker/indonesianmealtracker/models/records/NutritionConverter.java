package com.ranggarifqi.mealtracker.indonesianmealtracker.models.records;

import com.ranggarifqi.mealtracker.indonesianmealtracker.commons.json.JpaConverter;

public class NutritionConverter extends JpaConverter<Nutrition> {
  public NutritionConverter() {
    super(Nutrition.class);
  }
}
