package com.ranggarifqi.mealtracker.indonesianmealtracker.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "`RecipeNutritions`")
public class RecipeNutrition extends TimestampAudit {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "`id`", nullable = false)
  private UUID id;

  @Column(name = "`recipeId`", nullable = false)
  private UUID recipeId;

  @Column(name = "`calories`", nullable = true)
  private double calories;

  @Column(name = "`totalFat`", nullable = true)
  private double totalFat;

  @Column(name = "`saturatedFat`", nullable = true)
  private double saturatedFat;

  @Column(name = "`cholesterol`", nullable = true)
  private double cholesterol;

  @Column(name = "`sodium`", nullable = true)
  private double sodium;

  @Column(name = "`totalCarbohydrate`", nullable = true)
  private double totalCarbohydrate;

  @Column(name = "`dietaryFiber`", nullable = true)
  private double dietaryFiber;

  @Column(name = "`sugars`", nullable = true)
  private double sugars;

  @Column(name = "`protein`", nullable = true)
  private double protein;

  @Column(name = "`potassium`", nullable = true)
  private double potassium;

  @Column(name = "`phosphorus`", nullable = true)
  private double phosphorus;

  public RecipeNutrition(UUID recipeId, double calories, double totalFat, double saturatedFat, double cholesterol, double sodium, double totalCarbohydrate, double dietaryFiber, double sugars, double protein, double potassium, double phosphorus) {
    this.recipeId = recipeId;
    this.calories = calories;
    this.totalFat = totalFat;
    this.saturatedFat = saturatedFat;
    this.cholesterol = cholesterol;
    this.sodium = sodium;
    this.totalCarbohydrate = totalCarbohydrate;
    this.dietaryFiber = dietaryFiber;
    this.sugars = sugars;
    this.protein = protein;
    this.potassium = potassium;
    this.phosphorus = phosphorus;
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

  public double getCalories() {
    return calories;
  }

  public void setCalories(double calories) {
    this.calories = calories;
  }

  public double getTotalFat() {
    return totalFat;
  }

  public void setTotalFat(double totalFat) {
    this.totalFat = totalFat;
  }

  public double getSaturatedFat() {
    return saturatedFat;
  }

  public void setSaturatedFat(double saturatedFat) {
    this.saturatedFat = saturatedFat;
  }

  public double getCholesterol() {
    return cholesterol;
  }

  public void setCholesterol(double cholesterol) {
    this.cholesterol = cholesterol;
  }

  public double getSodium() {
    return sodium;
  }

  public void setSodium(double sodium) {
    this.sodium = sodium;
  }

  public double getTotalCarbohydrate() {
    return totalCarbohydrate;
  }

  public void setTotalCarbohydrate(double totalCarbohydrate) {
    this.totalCarbohydrate = totalCarbohydrate;
  }

  public double getDietaryFiber() {
    return dietaryFiber;
  }

  public void setDietaryFiber(double dietaryFiber) {
    this.dietaryFiber = dietaryFiber;
  }

  public double getSugars() {
    return sugars;
  }

  public void setSugars(double sugars) {
    this.sugars = sugars;
  }

  public double getProtein() {
    return protein;
  }

  public void setProtein(double protein) {
    this.protein = protein;
  }

  public double getPotassium() {
    return potassium;
  }

  public void setPotassium(double potassium) {
    this.potassium = potassium;
  }

  public double getPhosphorus() {
    return phosphorus;
  }

  public void setPhosphorus(double phosphorus) {
    this.phosphorus = phosphorus;
  }

  @Override
  public String toString() {
    return "RecipeNutrition{" +
            "id=" + id +
            ", recipeId=" + recipeId +
            ", calories=" + calories +
            ", totalFat=" + totalFat +
            ", saturatedFat=" + saturatedFat +
            ", cholesterol=" + cholesterol +
            ", sodium=" + sodium +
            ", totalCarbohydrate=" + totalCarbohydrate +
            ", dietaryFiber=" + dietaryFiber +
            ", sugars=" + sugars +
            ", protein=" + protein +
            ", potassium=" + potassium +
            ", phosphorus=" + phosphorus +
            '}';
  }
}
