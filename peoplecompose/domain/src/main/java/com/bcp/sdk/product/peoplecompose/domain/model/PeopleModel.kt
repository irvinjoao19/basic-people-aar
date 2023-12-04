package com.bcp.sdk.product.peoplecompose.domain.model

data class PeopleList (
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val data: List<People>,
    val support: Support
)

data class PeopleData(
    val data: People,
    val support: Support
)

data class People (
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String
)

data class Support (
    val url: String,
    val text: String
)