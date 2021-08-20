package com.shaun.foodnut.repository

import com.shaun.foodnut.models.ApiKeys
import com.shaun.foodnut.models.foodparser.FoodParsed
import com.shaun.foodnut.models.recipes.RecipeResponse
import com.shaun.foodnut.network.ApiService

class HomeRepository(
    private val apiKeys: ApiKeys,
    private val apiService: ApiService
) {

    suspend fun getFood(query: String): FoodParsed {
        return apiService.foodSearch(
            appId = apiKeys.foodAppId,
            appKey = apiKeys.foodApiKey,
            q = query
        )
    }

    suspend fun parseFood(query: String): FoodParsed {
        return apiService.parseFood(
            appId = apiKeys.foodAppId,
            appKey = apiKeys.foodApiKey,
            ingr = query
        )
    }

    suspend fun getRecipes(query: String): RecipeResponse {
        return apiService.getRecipe(
            q = query,
            appId = apiKeys.recipeAppId,
            appKey = apiKeys.recipeApiKey
        )
    }
}