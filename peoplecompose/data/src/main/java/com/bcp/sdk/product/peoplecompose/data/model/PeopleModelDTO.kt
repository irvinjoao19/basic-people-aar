package com.bcp.sdk.product.peoplecompose.data.model

import com.google.gson.annotations.SerializedName

data class PeopleListDTO(
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val data: List<PeopleDTO>,
    val support: SupportDTO
)

data class PeopleDataDTO(
    val data: PeopleDTO,
    val support: SupportDTO
)

data class PeopleDTO(
    val id: Int,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String
)

data class SupportDTO(
    val url: String,
    val text: String
)