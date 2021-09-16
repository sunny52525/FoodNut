package com.shaun.foodnut.repository

import com.shaun.foodnut.models.ApiKeys
import com.shaun.foodnut.network.ApiService

class SearchRepository(
    private val apiKeys: ApiKeys,
    private val apiService: ApiService
) {
}