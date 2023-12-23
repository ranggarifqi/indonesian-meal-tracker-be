package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.json;

import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class JpaConverterStringArray extends JpaConverter<String[]>{
  public JpaConverterStringArray() {
    super(String[].class);
  }
}
