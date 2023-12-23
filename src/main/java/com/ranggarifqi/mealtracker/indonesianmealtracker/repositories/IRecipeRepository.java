package com.ranggarifqi.mealtracker.indonesianmealtracker.repositories;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Recipe;

public interface IRecipeRepository {
  Recipe findByName(String searchQuery);
  void create(Recipe payload);
}
