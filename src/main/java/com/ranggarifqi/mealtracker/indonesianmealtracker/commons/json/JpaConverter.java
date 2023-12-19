package com.ranggarifqi.mealtracker.indonesianmealtracker.commons.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;

@Converter(autoApply = true)
public class JpaConverter<T> implements AttributeConverter<T, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  private final Class<T> type;

  public JpaConverter(Class<T> type) {
    this.type = type;
  }

  @Override
  public String convertToDatabaseColumn(T meta) {
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (JsonProcessingException ex) {
      return null;
      // or throw an error
    }
  }

  @Override
  public T convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData, type);
    } catch (IOException ex) {
//       logger.error("Unexpected IOEx decoding json from database: " + dbData);
      return null;
    }
  }
}
