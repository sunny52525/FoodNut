package com.shaun.foodnut.models.foodparser

data class FoodX(
    val category: String,
    val categoryLabel: String,
    val foodId: String,
    val image: String,
    val label: String,
    val nutrients: NutrientsX
)