package com.ranggarifqi.mealtracker.indonesianmealtracker.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecipeTest {
  private final String[] steps = {"1", "2", "3"};

  @Test
  public void shouldSlugifyNameIfSlugIsNotProvided() {
    Recipe recipe = new Recipe("SoMe R3CipE", steps);
    Assertions.assertEquals("some-r3cipe", recipe.getSlug());
  }

  @Test
  public void shouldSlugifyTheSlugIfSlugIsProvided() {
    Recipe recipe = new Recipe("SoMe R3CipE", steps, "S0ME SLUGZ");
    Assertions.assertEquals("s0me-slugz", recipe.getSlug());
    Assertions.assertEquals("SoMe R3CipE", recipe.getName());
  }
}
