package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.recipe;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeRepository implements IRecipeRepository{

  Logger logger = LoggerFactory.getLogger(RecipeRepository.class);

  private final EntityManager entityManager;

  @Autowired
  public RecipeRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Recipe> findByName(String searchQuery) {
    this.logger.info("findByName " + searchQuery);

    String sql = "FROM \"Account\" where \"name\" LIKE '%:searchQuery%'";

    TypedQuery<Recipe> query = this.entityManager.createQuery(sql, Recipe.class);
    query.setParameter("searchQuery", searchQuery);

    return query.getResultList();
  }

  @Transactional()
  @Override
  public void create(Recipe payload) {
    this.logger.info("create " + payload.toString());

    this.entityManager.persist(payload);
  }
}
