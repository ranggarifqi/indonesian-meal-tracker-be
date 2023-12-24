package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.exception.InternalServerException;
import jakarta.persistence.AttributeConverter;

import java.io.IOException;

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
      throw new InternalServerException(ex.toString());
    }
  }

  @Override
  public T convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData, type);
    } catch (IOException ex) {
      throw new InternalServerException(ex.toString());
    }
  }
}
