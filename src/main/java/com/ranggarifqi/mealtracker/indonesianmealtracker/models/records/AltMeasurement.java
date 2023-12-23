package com.ranggarifqi.mealtracker.indonesianmealtracker.models.records;

public record AltMeasurement(
  float servingWeight,
  String measure,
  int seq,
  int qty
) {}
