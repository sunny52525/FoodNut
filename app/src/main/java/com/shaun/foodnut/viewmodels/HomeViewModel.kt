package com.shaun.foodnut.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shaun.foodnut.models.ApiKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    apiKeys: ApiKeys
) : ViewModel() {
    init {
        Log.d(TAG, "$apiKeys: ")
    }

    val key = MutableLiveData(apiKeys)

    companion object {
        private const val TAG = "HomeViewModel"
    }
}