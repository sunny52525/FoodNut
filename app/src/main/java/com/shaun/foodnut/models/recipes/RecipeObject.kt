package com.shaun.foodnut.models.recipes

import com.shaun.foodnut.models.foodparser.Links
import com.shaun.foodnut.models.nutrients.TotalNutrients

data class Hits(
    val _links: Links,
    val recipe:RecipeObject,
)
data class RecipeObject(
    val uri: String,
    val label: String,
    val image: String,
    val source: String,
    val shareAs: String,
    val yield: String,
    val dietLabels: ArrayList<String>,
    val healthLabels: ArrayList<String>,
    val caution: ArrayList<String>,
    val ingredientLines: ArrayList<String>,
    val ingredients: ArrayList<IngredientObject>,
    val calories:Float,
    val totalWeight:Double,
    val cuisineType:ArrayList<String>,
    val mealType:ArrayList<String>,
    val dishType:ArrayList<String>,
    val totalNutrients:TotalNutrients,
    val totalDaily:TotalNutrients,
    val digest:ArrayList<Digest>,
    ) {
    data class IngredientObject(
        val text: String,
        val weight: Float,
        val foodCategory: String,
        val foodId: String,
        val image: String,
    )
}