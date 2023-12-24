package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.service;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Ingredient;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Recipe;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.RecipeNutrition;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.records.Nutrition;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.IRecipeRepository;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.IRecipeService;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.RecipeService;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto.CreateIngredientDTO;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto.CreateRecipeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CreateTest {
  @Mock
  private IRecipeRepository recipeRepository;

  private IRecipeService recipeService;

  private final CreateRecipeDTO recipeDTO = new CreateRecipeDTO("Test name", new String[]{"1", "2"});

  private CreateIngredientDTO ingredient1;

  @BeforeEach
  void beforeEach() {
    recipeService = new RecipeService(this.recipeRepository);

    this.ingredient1 = new CreateIngredientDTO();
    ingredient1.setNutrition(new Nutrition(1,2,3,4,5,6,7,8,9,10,11));
  }

  @Test
  void shouldAttachIngredientsAndRecipeNutritionToRecipeObj() {
    List<CreateIngredientDTO> ingredientDTOS = new ArrayList<>();
    ingredientDTOS.add(ingredient1);

    this.recipeService.create(recipeDTO, ingredientDTOS);

    ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);
    Mockito.verify(this.recipeRepository, Mockito.times(1)).create(argumentCaptor.capture());

    Recipe capturedArg = argumentCaptor.getValue();

    Assertions.assertNotNull(capturedArg.getIngredients());
    Assertions.assertNotNull(capturedArg.getRecipeNutrition());
  }

  @Test
  public void shouldCalculateTotalNutrition() {
    CreateIngredientDTO ingredient2 = new CreateIngredientDTO();
    ingredient2.setNutrition(new Nutrition(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1));

    List<CreateIngredientDTO> ingredientDTOS = new ArrayList<>();
    ingredientDTOS.add(ingredient1);
    ingredientDTOS.add(ingredient2);

    this.recipeService.create(recipeDTO, ingredientDTOS);

    ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);
    Mockito.verify(this.recipeRepository, Mockito.times(1)).create(argumentCaptor.capture());

    Recipe capturedArg = argumentCaptor.getValue();
    RecipeNutrition nutrition = capturedArg.getRecipeNutrition();

    RecipeNutrition expected = new RecipeNutrition(12,12,12,12,12,12,12,12,12,12,12);
    Assertions.assertEquals(expected, nutrition);
  }

  @Test
  public void shouldInsertTheSameAmountOfIngredients() {
    CreateIngredientDTO ingredient2 = new CreateIngredientDTO();
    ingredient2.setNutrition(new Nutrition(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1));

    List<CreateIngredientDTO> ingredientDTOS = new ArrayList<>();
    ingredientDTOS.add(ingredient1);
    ingredientDTOS.add(ingredient2);

    this.recipeService.create(recipeDTO, ingredientDTOS);

    ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);
    Mockito.verify(this.recipeRepository, Mockito.times(1)).create(argumentCaptor.capture());

    Recipe capturedArg = argumentCaptor.getValue();

    List<Ingredient> ingredients = capturedArg.getIngredients();

    Assertions.assertEquals(2, ingredients.size());
  }
}
