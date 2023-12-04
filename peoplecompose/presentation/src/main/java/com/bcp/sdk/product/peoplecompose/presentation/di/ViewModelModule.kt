package com.bcp.sdk.product.peoplecompose.presentation.di

import com.bcp.sdk.product.peoplecompose.domain.usecase.PeopleByIdUseCase
import com.bcp.sdk.product.peoplecompose.domain.usecase.PeopleUseCase
import com.bcp.sdk.product.peoplecompose.presentation.viewmodel.PeopleByIdViewModel
import com.bcp.sdk.product.peoplecompose.presentation.viewmodel.PeopleViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class ViewModelModule {
    @Provides
    fun providePeopleViewModel(peopleUseCase: PeopleUseCase) = PeopleViewModel(peopleUseCase)

    @Provides
    fun providePeopleByIdViewModel(peopleByIdUseCase: PeopleByIdUseCase) = PeopleByIdViewModel(peopleByIdUseCase)
}