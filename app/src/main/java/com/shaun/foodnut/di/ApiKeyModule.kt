package com.shaun.foodnut.di

import com.shaun.foodnut.BaseApplication
import com.shaun.foodnut.models.ApiKeys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiKeyModule {

    @Singleton
    @Provides
    @Named("recipe_app_id")
    fun providesRecipeApplicationId(baseApplication: BaseApplication): String =
        baseApplication.getRecipeApplicationId()

    @Singleton
    @Provides
    @Named("recipe_api_key")
    fun providesRecipeApiKey(baseApplication: BaseApplication): String =
        baseApplication.getRecipeApiKey()

    @Singleton
    @Provides
    @Named("nutrition_app_id")
    fun providesNutritionAppId(baseApplication: BaseApplication) =
        baseApplication.getNutritionAnalysisApplicationId()

    @Singleton
    @Provides
    @Named("nutrition_api_key")
    fun providesNutritionApiKey(baseApplication: BaseApplication) =
        baseApplication.getNutritionAnalysisApiKey()

    @Singleton
    @Provides
    @Named("food_api_key")
    fun providesFoodApiKey(baseApplication: BaseApplication) =
        baseApplication.getFoodApiKey()

    @Singleton
    @Provides
    @Named("food_app_id")
    fun providesFoodAppId(baseApplication: BaseApplication) =
        baseApplication.getFoodApplicationId()


    @Provides
    @Singleton
    fun providesApiKeys(
        @Named("recipe_app_id") recipe_app_id: String,
        @Named("recipe_api_key") recipe_api_key: String,
        @Named("nutrition_app_id") nutrition_app_id: String,
        @Named("nutrition_api_key") nutrition_api_key: String,
        @Named("food_api_key") food_api_key: String,
        @Named("food_app_id") food_app_id: String,

        ): ApiKeys = ApiKeys(
        recipeApiKey = recipe_api_key,
        recipeAppId = recipe_app_id,
        nutritionApiKey = nutrition_api_key,
        nutritionAppId = nutrition_app_id,
        foodApiKey = food_api_key,
        foodAppId = food_app_id
    )
}