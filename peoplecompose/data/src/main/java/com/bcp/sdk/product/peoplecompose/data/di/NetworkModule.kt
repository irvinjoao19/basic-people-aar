package com.bcp.sdk.product.peoplecompose.data.di

import com.bcp.sdk.product.peoplecompose.data.api.ApiService
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object NetworkModule {


    private const val BASE_URL = "https://reqres.in/"
    private val retrofitInstance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService = retrofitInstance.create(ApiService::class.java)
    val gson = Gson()
}