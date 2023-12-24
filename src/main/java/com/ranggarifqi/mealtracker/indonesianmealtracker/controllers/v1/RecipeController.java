package com.ranggarifqi.mealtracker.indonesianmealtracker.controllers.v1;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Recipe;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.IRecipeService;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe.dto.CreateRecipeDTO;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.response.APIResponse;
import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.response.ErrorResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/recipes")
public class RecipeController {
  Logger logger = LoggerFactory.getLogger(RecipeController.class);

  private final IRecipeService recipeService;

  @Autowired
  public RecipeController(IRecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping(value = "/search")
  @ResponseBody
  public ResponseEntity<APIResponse<List<Recipe>>> search(@RequestParam String query) {
    this.logger.info("Search recipes: " + query);

    try {
      List<Recipe> response = this.recipeService.findByName(query);
      return APIResponse.constructResponse(response);
    } catch (Exception e) {
      throw ErrorResponse.construct(e);
    }
  }

  @PostMapping(value = "")
  @ResponseBody
  public ResponseEntity<APIResponse<Recipe>> create(@Valid @RequestBody CreateRecipeDTO recipeDTO) {
    this.logger.info("Search recipes: " + recipeDTO.toString());

    try {
      Recipe response = this.recipeService.create(recipeDTO, recipeDTO.getIngredients());
      return APIResponse.constructResponse(response);
    } catch (Exception e) {
      throw ErrorResponse.construct(e);
    }
  }
}
