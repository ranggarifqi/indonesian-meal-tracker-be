package com.ranggarifqi.mealtracker.indonesianmealtracker.models;

import com.ranggarifqi.mealtracker.indonesianmealtracker.models.records.IngredientMetadata;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.records.IngredientMetadataConverter;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.records.Nutrition;
import com.ranggarifqi.mealtracker.indonesianmealtracker.models.records.NutritionConverter;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "`Ingredients`")
public class Ingredient extends TimestampAudit{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "`id`", nullable = false)
  private UUID id;

  @Column(name = "`recipeId`", nullable = false, insertable = false, updatable = false)
  private UUID recipeId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "`recipeId`")
  private Recipe recipe;

  @Column(name = "`name`", nullable = false)
  private String name;

  @Column(name = "`servingQty`", nullable = false)
  private float servingQty;

  @Column(name = "`servingUnit`", nullable = false)
  private String servingUnit;

  @Column(name = "`servingWeightInGram`", nullable = true)
  private double servingWeightInGram;

  @Column(name = "`nutritions`", nullable = true)
  @Convert(converter = NutritionConverter.class)
  private Nutrition nutrition;

  @Column(name = "`metadata`", nullable = true)
  @Convert(converter = IngredientMetadataConverter.class)
  private IngredientMetadata metadata;

  public Ingredient(UUID recipeId, String name, float servingQty, String servingUnit, double servingWeightInGram, Nutrition nutrition, IngredientMetadata metadata) {
    this.recipeId = recipeId;
    this.name = name;
    this.servingQty = servingQty;
    this.servingUnit = servingUnit;
    this.servingWeightInGram = servingWeightInGram;
    this.nutrition = nutrition;
    this.metadata = metadata;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(UUID recipeId) {
    this.recipeId = recipeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getServingQty() {
    return servingQty;
  }

  public void setServingQty(float servingQty) {
    this.servingQty = servingQty;
  }

  public String getServingUnit() {
    return servingUnit;
  }

  public void setServingUnit(String servingUnit) {
    this.servingUnit = servingUnit;
  }

  public double getServingWeightInGram() {
    return servingWeightInGram;
  }

  public void setServingWeightInGram(double servingWeightInGram) {
    this.servingWeightInGram = servingWeightInGram;
  }

  public Nutrition getNutrition() {
    return nutrition;
  }

  public void setNutrition(Nutrition nutrition) {
    this.nutrition = nutrition;
  }

  public IngredientMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(IngredientMetadata metadata) {
    this.metadata = metadata;
  }

  public Recipe getRecipe() {
    return recipe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ingredient that = (Ingredient) o;
    return Float.compare(that.servingQty, servingQty) == 0 && Double.compare(that.servingWeightInGram, servingWeightInGram) == 0 && Objects.equals(id, that.id) && Objects.equals(recipeId, that.recipeId) && Objects.equals(name, that.name) && Objects.equals(servingUnit, that.servingUnit) && Objects.equals(nutrition, that.nutrition) && Objects.equals(metadata, that.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, recipeId, name, servingQty, servingUnit, servingWeightInGram, nutrition, metadata);
  }

  @Override
  public String toString() {
    return "Ingredient{" +
            "id=" + id +
            ", recipeId=" + recipeId +
            ", name='" + name + '\'' +
            ", servingQty=" + servingQty +
            ", servingUnit='" + servingUnit + '\'' +
            ", servingWeightInGram=" + servingWeightInGram +
            ", nutrition=" + nutrition +
            ", metadata=" + metadata +
            '}';
  }
}
