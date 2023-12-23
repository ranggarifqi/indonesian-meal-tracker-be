package com.ranggarifqi.mealtracker.indonesianmealtracker.models;

import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.json.JpaConverterStringArray;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "`Recipes`")
public class Recipe extends TimestampAudit{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "`id`", nullable = false)
  private UUID id;

  @Column(name = "`name`", nullable = false)
  private String name;

  @Column(name = "`slug`", nullable = false)
  private String slug;

  @Column(name = "`steps`")
  @Convert(converter = JpaConverterStringArray.class)
  private String[] steps;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  private List<Ingredient> ingredients;

  @OneToOne(fetch = FetchType.EAGER, mappedBy = "recipe")
  private RecipeNutrition recipeNutrition;

  public Recipe(String name, String slug, String[] steps) {
    super();
    this.name = name;
    this.slug = slug;
    this.steps = steps;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public RecipeNutrition getRecipeNutrition() {
    return recipeNutrition;
  }

  public void setRecipeNutrition(RecipeNutrition recipeNutrition) {
    this.recipeNutrition = recipeNutrition;
  }

  public void setSteps(String[] steps) {
    this.steps = steps;
  }

  @Override
  public String toString() {
    return "Recipe{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", slug='" + slug + '\'' +
            ", steps=" + Arrays.toString(steps) +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Recipe recipe = (Recipe) o;
    return Objects.equals(id, recipe.id) && Objects.equals(name, recipe.name) && Objects.equals(slug, recipe.slug) && Arrays.equals(steps, recipe.steps);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(id, name, slug);
    result = 31 * result + Arrays.hashCode(steps);
    return result;
  }
}
