package com.shaun.foodnut.network

import com.shaun.foodnut.models.Ingr
import com.shaun.foodnut.models.foodparser.FoodParsed
import com.shaun.foodnut.models.nutrients.Nutrients
import com.shaun.foodnut.models.requestobject.IngredientsRequestObject
import retrofit2.http.*

interface Api {

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
        /**
         * @Constants.HEALTH_LABELS
         */
        @QueryMap health: HashMap<String, String>,

        @QueryMap calories: HashMap<String, String> = HashMap(),
        /**
         * @Constants.FOOD_CATEGORIES
         */
        @QueryMap category: HashMap<String, String>,
        /**
         * @Constants.NUTRIENT_TYPES
         */
        @QueryMap nutrients: HashMap<String, String>
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
        /**
         * @Constants.HEALTH_LABELS
         */
        @QueryMap health: HashMap<String, String>,

        ): FoodParsed
}