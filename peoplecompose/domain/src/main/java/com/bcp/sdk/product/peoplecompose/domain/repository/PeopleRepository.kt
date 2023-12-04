package com.bcp.sdk.product.peoplecompose.domain.repository

import com.bcp.sdk.product.peoplecompose.domain.model.PeopleData
import com.bcp.sdk.product.peoplecompose.domain.model.PeopleList

interface PeopleRepository {

    suspend fun getPeople(): Result<PeopleList>
    suspend fun getPeopleById(id: Int): Result<PeopleData>

}