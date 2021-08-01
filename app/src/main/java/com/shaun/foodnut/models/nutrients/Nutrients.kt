package com.shaun.foodnut.models.nutrients

data class Nutrients(
    val uri: String,
    val calories: Int,
    val totalWeight: Double,
    val dietLabels: ArrayList<String>,
    val healthLabels: ArrayList<String>,
    val cautions: ArrayList<String>,
    val totalNutrients: TotalNutrients,
    val totalDaily: TotalNutrients,
    val ingredients: ArrayList<Ingredient>,

    )