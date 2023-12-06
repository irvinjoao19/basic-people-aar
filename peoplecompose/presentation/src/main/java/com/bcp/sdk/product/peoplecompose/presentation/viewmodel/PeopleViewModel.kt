package com.bcp.sdk.product.peoplecompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bcp.sdk.product.peoplecompose.domain.usecase.PeopleUseCase
import com.bcp.sdk.product.peoplecompose.presentation.mapper.toPresentation
import com.bcp.sdk.product.peoplecompose.presentation.state.PeopleViewState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
class PeopleViewModel(
    private val peopleUseCase: PeopleUseCase,
) : ViewModel() {

    private val _people =
        MutableStateFlow<PeopleViewState?>(null)
    val people: StateFlow<PeopleViewState?> =
        _people

    fun fetchPeople() {
        viewModelScope.launch {
            _people.value = PeopleViewState.ShowShimmer

            peopleUseCase.invoke().onSuccess {
                _people.value = PeopleViewState.FetchPeople(it.toPresentation().data)
            }.onFailure {
                _people.value = PeopleViewState.ErrorPeople
            }

            delay(1000)
            _people.value = PeopleViewState.HideShimmer
        }
    }
}