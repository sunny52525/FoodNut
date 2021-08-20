package com.shaun.foodnut.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shaun.foodnut.models.foodparser.FoodParsed
import com.shaun.foodnut.models.recipes.RecipeResponse
import com.shaun.foodnut.network.Resource
import com.shaun.foodnut.network.Status
import com.shaun.foodnut.repository.HomeRepository
import com.shaun.foodnut.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {


    var selectedItem by mutableStateOf(Constants.CHIPS[0].label)

    var foodItems = MutableLiveData(Resource<FoodParsed>(Status.IDLE, null, null))
    var recipes = MutableLiveData(Resource<RecipeResponse>(Status.IDLE, null, null))

    init {
        updateHomeScreen()
    }

    private fun searchFood() {
        foodItems.value = Resource.loading()
        viewModelScope.launch {
            try {
                val result = homeRepository.parseFood(selectedItem)
                foodItems.postValue(Resource.success(result))
            } catch (e: Exception) {
                foodItems.postValue(Resource.error(e.message))
                Log.d(TAG, "searchFood: ${e.message}")

            }

        }
    }

    private fun searchRecipes() {
        recipes.value = Resource.loading()
        viewModelScope.launch {
            try {
                val result = homeRepository.getRecipes(selectedItem)
                Log.d(TAG, "searchRecipes: $result")
                recipes.postValue(Resource.success(result))

            } catch (e: Exception) {
                recipes.postValue(Resource.error(e.message))
                Log.d(TAG, "searchFood: ${e.message}")
            }
        }

    }

    fun updateHomeScreen(){
        searchFood()
        searchRecipes()
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }
}