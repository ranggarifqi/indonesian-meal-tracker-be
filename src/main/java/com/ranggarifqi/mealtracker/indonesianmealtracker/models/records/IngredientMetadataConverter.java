package com.ranggarifqi.mealtracker.indonesianmealtracker.models.records;

import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.json.JpaConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class IngredientMetadataConverter extends JpaConverter<IngredientMetadata> {
  public IngredientMetadataConverter() {
    super(IngredientMetadata.class);
  }
}
