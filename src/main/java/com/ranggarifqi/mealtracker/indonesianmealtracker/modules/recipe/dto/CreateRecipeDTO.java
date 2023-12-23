package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Arrays;

public class CreateRecipeDTO {
  @NotBlank(message = "name is mandatory")
  private String name;

  private String slug;

  private String[] steps;

  public CreateRecipeDTO(String name, String slug, String[] steps) {
    this.name = name;
    this.slug = slug;
    this.steps = steps;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String[] getSteps() {
    return steps;
  }

  public void setSteps(String[] steps) {
    this.steps = steps;
  }

  @Override
  public String toString() {
    return "CreateRecipeDTO{" +
            "name='" + name + '\'' +
            ", slug='" + slug + '\'' +
            ", steps=" + Arrays.toString(steps) +
            '}';
  }
}
