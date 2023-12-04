package com.bcp.sdk.product.peoplecompose.data.api

import com.bcp.sdk.product.peoplecompose.data.model.PeopleDataDTO
import com.bcp.sdk.product.peoplecompose.data.model.PeopleListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/users?page=1")
    suspend fun getPeople(): Response<PeopleListDTO>

    @GET("api/users/{id}")
    suspend fun getPeopleById(@Path("id") id: Int): Response<PeopleDataDTO>

}