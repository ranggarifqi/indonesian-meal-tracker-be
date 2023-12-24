package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.json;

import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.exception.InternalServerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JpaConverterTest {

  /*
  * Parse JSON String
  * */
  @Test
  public void shouldBeAbleToConvertJsonStringIntoArray() {
    String jsonStr = "[\"str 1\", \"str 2\"]";
    JpaConverter<String[]> converter = new JpaConverter<>(String[].class);

    String[] result = converter.convertToEntityAttribute(jsonStr);

    Assertions.assertEquals(2, result.length);
  }

  @Test
  public void shouldBeAbleToConvertJsonStringIntoObject() {
    String jsonStr = "{\"name\": \"Some Name\", \"value\": 10}";
    JpaConverter<MockJsonRecord> converter = new JpaConverter<>(MockJsonRecord.class);

    MockJsonRecord result = converter.convertToEntityAttribute(jsonStr);

    Assertions.assertEquals("Some Name", result.name());
    Assertions.assertEquals(10, result.value());
  }

  @Test()
  public void shouldThrowErrorIfNotAbleToConvert() {
    String jsonStr = "{\"name\": \"Some Name\", \"value\": 10}";
    JpaConverter<String[]> converter = new JpaConverter<>(String[].class);

    InternalServerException ex = Assertions.assertThrows(InternalServerException.class, () -> converter.convertToEntityAttribute(jsonStr));

    Assertions.assertTrue(ex.getMessage().contains("Cannot deserialize value"));
  }

  /*
  *  JSON Stringify Object
  */
  @Test
  public void shouldStringifyCorrectly() {
    MockJsonRecord input = new MockJsonRecord("Some Name", 10);
    JpaConverter<MockJsonRecord> converter = new JpaConverter<>(MockJsonRecord.class);

    String result = converter.convertToDatabaseColumn(input);

    Assertions.assertEquals("{\"name\":\"Some Name\",\"value\":10}", result);
  }
}
