package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Recipe;

import java.util.List;

public interface IRecipeRepository {
  List<Recipe> findByName(String searchQuery);
  void create(Recipe payload);
}