package com.bcp.sdk.product.peoplecompose.presentation.state

import com.bcp.sdk.product.peoplecompose.presentation.model.PeoplePresentation

sealed class PeopleViewState {
    data object ShowShimmer : PeopleViewState()
    data object HideShimmer : PeopleViewState()
    data object ErrorPeople : PeopleViewState()
    data class FetchPeople(val peopleList: List<PeoplePresentation>) : PeopleViewState()
}