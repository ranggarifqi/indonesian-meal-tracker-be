package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Ingredient;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Recipe;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.RecipeNutrition;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.records.Nutrition;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto.CreateIngredientDTO;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto.CreateRecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecipeService implements IRecipeService{

  private final IRecipeRepository recipeRepository;

  @Autowired
  public RecipeService(IRecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public List<Recipe> findByName(String searchQuery) {
    return this.recipeRepository.findByName(searchQuery);
  }

  @Override
  public Recipe create(CreateRecipeDTO recipeDTO, List<CreateIngredientDTO> ingredientDTOS) {
    List<Nutrition> ingredientNutritions = ingredientDTOS.stream().map(CreateIngredientDTO::getNutrition).toList();

    Nutrition totalNutrition = ingredientNutritions.stream().reduce(new Nutrition(), (partialNutrition, ingredient) -> {
      double calories = partialNutrition.calories() + ingredient.calories();
      double totalFat = partialNutrition.totalFat() + ingredient.totalFat();
      double saturatedFat = partialNutrition.saturatedFat() + ingredient.saturatedFat();
      double cholesterol = partialNutrition.cholesterol() + ingredient.cholesterol();
      double sodium = partialNutrition.sodium() + ingredient.sodium();
      double totalCarbohydrate = partialNutrition.totalCarbohydrate() + ingredient.totalCarbohydrate();
      double dietaryFiber = partialNutrition.dietaryFiber() + ingredient.dietaryFiber();
      double sugars = partialNutrition.sugars() + ingredient.sugars();
      double protein = partialNutrition.protein() + ingredient.protein();
      double potassium = partialNutrition.potassium() + ingredient.potassium();
      double phosphorus = partialNutrition.phosphorus() + ingredient.phosphorus();

      return new Nutrition(calories, totalFat, saturatedFat, cholesterol, sodium, totalCarbohydrate, dietaryFiber, sugars, protein, potassium, phosphorus);
    });

    RecipeNutrition recipeNutrition = new RecipeNutrition(totalNutrition);

    List<Ingredient> ingredients = ingredientDTOS.stream().map(ingredient -> {
      return new Ingredient(ingredient.getName(), ingredient.getServingQty(), ingredient.getServingUnit(), ingredient.getServingWeightInGram(), ingredient.getNutrition(), ingredient.getMetadata());
    }).toList();

    Recipe recipe = new Recipe(recipeDTO.getName(), recipeDTO.getSteps(), recipeDTO.getSlug());
    recipe.setIngredients(ingredients);
    recipe.setRecipeNutrition(recipeNutrition);

    this.recipeRepository.create(recipe);

    return recipe;
  }
}
