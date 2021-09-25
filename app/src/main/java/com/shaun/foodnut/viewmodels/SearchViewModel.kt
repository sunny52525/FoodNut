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

}