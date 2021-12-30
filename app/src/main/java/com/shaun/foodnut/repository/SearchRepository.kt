package com.shaun.foodnut.repository

import com.shaun.foodnut.models.ApiKeys
import com.shaun.foodnut.models.recipes.RecipeResponse
import com.shaun.foodnut.network.ApiService

class SearchRepository(
    private val apiKeys: ApiKeys,
    private val apiService: ApiService
) {
    suspend fun searchRecipe(
        healthLabels: List<String>,
        cuisine: List<String>,
        meal: List<String>,
        dishType: List<String>,
        searchQuery: String
    ): RecipeResponse {


    return  apiService.getRecipe(
            q = searchQuery,
            appId = apiKeys.recipeAppId,
            appKey = apiKeys.recipeApiKey,
            diet = healthLabels
        )
    }
}