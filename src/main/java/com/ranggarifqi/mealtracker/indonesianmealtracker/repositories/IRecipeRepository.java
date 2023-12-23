package com.ranggarifqi.mealtracker.indonesianmealtracker.repositories;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Recipe;

public interface IRecipeRepository {
  void create(Recipe payload);
}
