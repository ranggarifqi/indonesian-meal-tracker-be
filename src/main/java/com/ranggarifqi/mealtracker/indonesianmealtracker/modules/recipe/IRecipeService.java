package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Recipe;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto.CreateIngredientDTO;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto.CreateRecipeDTO;

import java.util.List;

public interface IRecipeService {
  List<Recipe> findByName(String searchQuery);

  Recipe create(CreateRecipeDTO recipe, List<CreateIngredientDTO> ingredients);
}
