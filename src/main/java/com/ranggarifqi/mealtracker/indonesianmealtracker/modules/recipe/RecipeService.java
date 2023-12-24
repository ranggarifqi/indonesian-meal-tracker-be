package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Ingredient;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Recipe;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.RecipeNutrition;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.records.Nutrition;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto.CreateIngredientDTO;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto.CreateRecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    Nutrition totalNutrition = ingredientNutritions.stream().reduce(new Nutrition(), (partialNutrition, ingredientNutrition) -> {
      double calories = partialNutrition.calories() + ingredientNutrition.calories();
      double totalFat = partialNutrition.totalFat() + ingredientNutrition.totalFat();
      double saturatedFat = partialNutrition.saturatedFat() + ingredientNutrition.saturatedFat();
      double cholesterol = partialNutrition.cholesterol() + ingredientNutrition.cholesterol();
      double sodium = partialNutrition.sodium() + ingredientNutrition.sodium();
      double totalCarbohydrate = partialNutrition.totalCarbohydrate() + ingredientNutrition.totalCarbohydrate();
      double dietaryFiber = partialNutrition.dietaryFiber() + ingredientNutrition.dietaryFiber();
      double sugars = partialNutrition.sugars() + ingredientNutrition.sugars();
      double protein = partialNutrition.protein() + ingredientNutrition.protein();
      double potassium = partialNutrition.potassium() + ingredientNutrition.potassium();
      double phosphorus = partialNutrition.phosphorus() + ingredientNutrition.phosphorus();

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
