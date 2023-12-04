package com.bcp.sdk.product.peoplecompose.presentation.mapper

import com.bcp.sdk.product.peoplecompose.domain.model.People
import com.bcp.sdk.product.peoplecompose.domain.model.PeopleData
import com.bcp.sdk.product.peoplecompose.domain.model.PeopleList
import com.bcp.sdk.product.peoplecompose.domain.model.Support
import com.bcp.sdk.product.peoplecompose.presentation.model.PeopleDataPresentation
import com.bcp.sdk.product.peoplecompose.presentation.model.PeopleListPresentation
import com.bcp.sdk.product.peoplecompose.presentation.model.PeoplePresentation
import com.bcp.sdk.product.peoplecompose.presentation.model.SupportPresentation

fun PeopleList.toPresentation() = PeopleListPresentation(
    page = page,
    perPage = perPage,
    total = total,
    totalPages = totalPages,
    data = data.map { it.toPresentation() },
    support = support.toPresentation()
)

fun PeopleData.toPresentation() = PeopleDataPresentation(
    data = data.toPresentation(),
    support = support.toPresentation()
)

fun People.toPresentation() = PeoplePresentation(
    id = id,
    email = email,
    firstName = firstName,
    lastName = lastName,
    avatar = avatar
)

fun Support.toPresentation() = SupportPresentation(
    url = url,
    text = text
)