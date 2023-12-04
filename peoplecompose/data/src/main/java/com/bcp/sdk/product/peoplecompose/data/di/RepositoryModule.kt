package com.bcp.sdk.product.peoplecompose.data.di

import com.bcp.sdk.product.peoplecompose.data.api.ApiService
import com.bcp.sdk.product.peoplecompose.data.repository.PeopleRepositoryImpl
import com.bcp.sdk.product.peoplecompose.domain.repository.PeopleRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun provideRestRepository(apiService: ApiService, gson: Gson): PeopleRepository =
        PeopleRepositoryImpl(apiService = apiService, gson = gson)

}