package com.bcp.sdk.product.peoplecompose.presentation.state

import com.bcp.sdk.product.peoplecompose.presentation.model.PeoplePresentation

sealed class PeopleByIdViewState {
    data object ShowShimmer : PeopleByIdViewState()
    data object HideShimmer : PeopleByIdViewState()
    data object Error : PeopleByIdViewState()
    data class FetchPeople(val peopleById: PeoplePresentation) : PeopleByIdViewState()
}