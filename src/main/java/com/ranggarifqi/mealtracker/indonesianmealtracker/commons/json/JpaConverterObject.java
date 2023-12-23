package com.ranggarifqi.mealtracker.indonesianmealtracker.commons.json;

import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class JpaConverterObject extends JpaConverter<Object>{
  public JpaConverterObject() {
    super(Object.class);
  }
}
