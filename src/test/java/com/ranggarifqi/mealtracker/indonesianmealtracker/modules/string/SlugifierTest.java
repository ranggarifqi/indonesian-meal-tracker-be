package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SlugifierTest {

  @Test
  public void shouldLowerCase() {
    String result = Slugifier.toSlug("SOME-STRING-YO");
    Assertions.assertEquals("some-string-yo", result);
  }

  @Test
  public void shouldReplaceWhitespaceWithDash() {
    String result = Slugifier.toSlug("Some String Yo");
    Assertions.assertEquals("some-string-yo", result);
  }

  @Test
  public void shouldReplaceNonLatinCharactersWithEmpty() {
    String result = Slugifier.toSlug("So#!@me-Str$!ing Y@!$%o");
    Assertions.assertEquals("some-string-yo", result);
  }
}
