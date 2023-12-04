package com.bcp.sdk.product.peoplecompose.presentation.model

data class PeopleListPresentation(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val data: List<PeoplePresentation>,
    val support: SupportPresentation
)

data class PeopleDataPresentation(
    val data: PeoplePresentation,
    val support: SupportPresentation
)

data class PeoplePresentation(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String
)

data class SupportPresentation(
    val url: String,
    val text: String
)