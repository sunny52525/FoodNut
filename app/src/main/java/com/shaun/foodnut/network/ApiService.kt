package com.shaun.foodnut.network

import com.shaun.foodnut.models.Ingr
import com.shaun.foodnut.models.foodparser.FoodParsed
import com.shaun.foodnut.models.nutrients.Nutrients
import com.shaun.foodnut.models.recipes.RecipeResponse
import com.shaun.foodnut.models.requestobject.IngredientsRequestObject
import com.shaun.foodnut.utils.Constants
import retrofit2.http.*

interface ApiService {

    @GET("api/nutrition-data/")
    suspend fun getNutritionData(
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Body ingr: Ingr
    ): Nutrients

    @GET("api/food-database/v2/parser")
    suspend fun parseFood(
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Query("ingr") ingr: String,
        @Query("nutrition-type") nutrition_type: String = "cooking",
        /**
         * [Constants.HEALTH_LABELS]
         */
        @QueryMap health: HashMap<String, String> = HashMap(),

        @Query("calories") calories: String = "0+",
        /**
         *  [Constants.FOOD_CATEGORIES]
         */
        @QueryMap category: HashMap<String, String> = HashMap(),
        /**
         * [Constants.NUTRIENT_TYPES]
         */
        @QueryMap nutrients: HashMap<String, String> = HashMap()
    ): FoodParsed

    @POST("api/food-database/v2/nutrients")
    suspend fun getNutrients(
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Body ingredient: IngredientsRequestObject
    ): Nutrients

    @GET("auto-complete")
    suspend fun autoComplete(
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Query("q") q: String,
    ): ArrayList<String>

    @GET("api/menu-items/v2/search")
    suspend fun foodSearch(
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Query("q") q: String,
        /**
         * [Constants.HEALTH_LABELS]
         */
        @QueryMap health: HashMap<String, String> = HashMap(),

        ): FoodParsed

    @GET("/api/recipes/v2")
    suspend fun getRecipe(
        @Query("q") q: String,
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Query("ingr") ingrCount: String = "0+",

        /**
         * [Constants.DIET]
         */
        @QueryMap diet: HashMap<String, String> = HashMap(),

        /**
         * [Constants.HEALTH_LABELS]
         */
        @QueryMap health: HashMap<String, String> = HashMap(),

        /**
         * [Constants.CUISINE_TYPE]
         */
        @QueryMap cuisineType: HashMap<String, String> = HashMap(),

        /**
         * [Constants.MEAL_TYPE]
         */
        @QueryMap mealType: HashMap<String, String> = HashMap(),

        /**
         * [Constants.DISH_TYPE]
         */
        @QueryMap dishType: HashMap<String, String> = HashMap(),

        @Query("calories") calories: String = "0+",

        /**
         * [Constants.IMAGE_SIZE]
         */
        @QueryMap imageSize: HashMap<String, String> = HashMap(),

        @QueryMap excluded: HashMap<String, String> = HashMap(),
        /**
         * [Constants.NUTRIENT_TYPES]
         */
        @QueryMap nutrients: HashMap<String, String> = HashMap()

    ): RecipeResponse

    @GET("api/recipes/v2/{id}")
    suspend fun getARecipe(
        @Query("id") recipeId: String,
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        ): RecipeResponse
}