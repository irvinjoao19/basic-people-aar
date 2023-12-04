package com.bcp.sdk.product.peoplecompose.data.di

import com.bcp.sdk.product.peoplecompose.domain.repository.PeopleRepository
import com.bcp.sdk.product.peoplecompose.domain.usecase.PeopleByIdUseCase
import com.bcp.sdk.product.peoplecompose.domain.usecase.PeopleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun providePeopleUseCase(peopleRepository: PeopleRepository) =
        PeopleUseCase(peopleRepository)
    @Provides
    fun providePeopleByIdUseCase(peopleRepository: PeopleRepository) =
        PeopleByIdUseCase(peopleRepository)
}