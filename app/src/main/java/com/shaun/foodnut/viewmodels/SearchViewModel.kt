package com.shaun.foodnut.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shaun.foodnut.models.recipes.RecipeResponse
import com.shaun.foodnut.network.Resource
import com.shaun.foodnut.repository.SearchRepository
import com.shaun.foodnut.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val searchRepository: SearchRepository
) : ViewModel() {


    var searchQuery = mutableStateOf("")

    val recipeResponse = MutableLiveData<Resource<RecipeResponse>>(Resource.idle())


    var itemsAdded = mutableStateOf(arrayListOf<String>())
    var currentType = mutableStateOf(Constants.category[0])
    var checkedDiet = mutableStateOf(MutableList(Constants.DIET.size) {
        false
    })
    val checkedHealth =
        mutableStateOf(MutableList(Constants.HEALTH_LABELS.size) {
            false
        })

    val checkedCuisine =
        mutableStateOf(MutableList(Constants.CUISINE_TYPE.size) {
            false
        })

    val checkedMeal =
        mutableStateOf(MutableList(Constants.MEAL_TYPE.size) {
            false
        })

    val checkedDishType =
        mutableStateOf(MutableList(Constants.DISH_TYPE.size) {
            false
        })

    fun search() {
        val healthLabels = checkedHealth.value.mapIndexedNotNull { index, b ->
            Constants.HEALTH_LABELS[index].takeIf {
                b
            }
        }
        val cuisine = checkedCuisine.value.mapIndexedNotNull { index, b ->
            Constants.CUISINE_TYPE[index].takeIf {
                b
            }
        }
        val meal = checkedMeal.value.mapIndexedNotNull { index, b ->
            Constants.MEAL_TYPE[index].takeIf {
                b
            }
        }
        val dishType = checkedDishType.value.mapIndexedNotNull { index, b ->
            Constants.DISH_TYPE[index].takeIf {
                b
            }
        }





        recipeResponse.value= Resource.loading()

        viewModelScope.launch {

            try {
                val result =
                    searchRepository.searchRecipe(
                        healthLabels,
                        cuisine,
                        meal,
                        dishType,
                        searchQuery.value
                    )

                recipeResponse.value = Resource.success(result)
                Log.d("SearchViewModel", result.toString())

            } catch (e: Exception) {

                Log.d(TAG, "search: ${e.message}")
                recipeResponse.value= Resource.error(e.message)
            }

        }

    }


    companion object {
        private const val TAG = "SearchViewModel"
    }
}
