package com.ranggarifqi.mealtracker.indonesianmealtracker.models.records;

import com.ranggarifqi.mealtracker.indonesianmealtracker.commons.json.JpaConverter;

public class IngredientMetadataConverter extends JpaConverter<IngredientMetadata> {
  public IngredientMetadataConverter() {
    super(IngredientMetadata.class);
  }
}
