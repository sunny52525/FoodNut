package com.shaun.foodnut.viewmodels

import androidx.lifecycle.ViewModel
import com.shaun.foodnut.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val searchRepository: SearchRepository
) : ViewModel() {


}