package com.bcp.sdk.product.peoplecompose.data.mapper

import com.bcp.sdk.product.peoplecompose.data.model.PeopleDTO
import com.bcp.sdk.product.peoplecompose.data.model.PeopleDataDTO
import com.bcp.sdk.product.peoplecompose.data.model.PeopleListDTO
import com.bcp.sdk.product.peoplecompose.data.model.SupportDTO
import com.bcp.sdk.product.peoplecompose.domain.model.People
import com.bcp.sdk.product.peoplecompose.domain.model.PeopleData
import com.bcp.sdk.product.peoplecompose.domain.model.PeopleList
import com.bcp.sdk.product.peoplecompose.domain.model.Support

fun PeopleListDTO.toDomain() = PeopleList(
    page = page,
    perPage = perPage,
    total = total,
    totalPages = totalPages,
    data = data.map { it.toDomain() },
    support = support.toDomain()
)

fun PeopleDataDTO.toDomain() = PeopleData(
    data = data.toDomain(),
    support = support.toDomain()
)

fun PeopleDTO.toDomain() = People(
    id = id,
    email = email,
    firstName = firstName,
    lastName = lastName,
    avatar = avatar
)

fun SupportDTO.toDomain() = Support(
    url = url,
    text = text
)