package com.shaun.foodnut.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.shaun.foodnut.repository.SearchRepository
import com.shaun.foodnut.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val searchRepository: SearchRepository
) : ViewModel() {

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
        TODO("Not yet implemented")
    }
}
