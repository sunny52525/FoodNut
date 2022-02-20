package com.shaun.foodnut

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {
    init {
        System.loadLibrary("keys")
    }

	
    external fun getRecipeApplicationId(): String
    external fun getNutritionAnalysisApplicationId(): String
    external fun getNutritionAnalysisApiKey(): String
    external fun getFoodApplicationId(): String
    external fun getFoodApiKey(): String
    external fun getRecipeApiKey(): String
}