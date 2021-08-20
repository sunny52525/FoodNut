package com.shaun.foodnut.di

import com.shaun.foodnut.models.ApiKeys
import com.shaun.foodnut.network.ApiService
import com.shaun.foodnut.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Interactor {

    @Provides
    @Singleton
    fun provideHomeRepository(apiKeys: ApiKeys, apiService: ApiService): HomeRepository {
        return HomeRepository(apiKeys = apiKeys, apiService = apiService)
    }
}