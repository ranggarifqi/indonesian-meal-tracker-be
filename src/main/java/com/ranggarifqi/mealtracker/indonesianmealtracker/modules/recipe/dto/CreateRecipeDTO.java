package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Arrays;
import java.util.List;

public class CreateRecipeDTO {
  @NotBlank(message = "name is mandatory")
  private String name;

  private String slug;

  private String[] steps;

  private List<CreateIngredientDTO> ingredients;

  public CreateRecipeDTO(String name, String[] steps, String slug) {
    this.name = name;
    this.slug = slug;
    this.steps = steps;
  }
  public CreateRecipeDTO(String name, String[] steps) {
    this.name = name;
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

  public List<CreateIngredientDTO> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<CreateIngredientDTO> ingredients) {
    this.ingredients = ingredients;
  }

  @Override
  public String toString() {
    return "CreateRecipeDTO{" +
            "name='" + name + '\'' +
            ", slug='" + slug + '\'' +
            ", steps=" + Arrays.toString(steps) +
            ", ingredients=" + ingredients +
            '}';
  }
}
