package com.shaun.foodnut.models.recipes

import com.shaun.foodnut.models.foodparser.Links

data class RecipeResponse(
    val from:Int,
    val to:Int,
    val count:Long,
    val _links:Links,
    val hits:ArrayList<RecipeObject>,
)
