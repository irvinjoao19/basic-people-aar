package com.bcp.sdk.product.peoplecompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bcp.sdk.product.peoplecompose.domain.usecase.PeopleByIdUseCase
import com.bcp.sdk.product.peoplecompose.presentation.mapper.toPresentation
import com.bcp.sdk.product.peoplecompose.presentation.state.PeopleByIdViewState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
class PeopleByIdViewModel(
    private val peopleByIdUseCase: PeopleByIdUseCase,
) : ViewModel() {

    private val _peopleById =
        MutableStateFlow<PeopleByIdViewState?>(null)
    val peopleById: StateFlow<PeopleByIdViewState?> =
        _peopleById

    fun peopleById(id: Int) {
        viewModelScope.launch {
            _peopleById.value = PeopleByIdViewState.ShowShimmer

            peopleByIdUseCase.invoke(id).onSuccess {
                _peopleById.value = PeopleByIdViewState.FetchPeople(it.toPresentation().data)
            }.onFailure {
                _peopleById.value = PeopleByIdViewState.Error
            }
            delay(1000)
            _peopleById.value = PeopleByIdViewState.HideShimmer
        }
    }
}