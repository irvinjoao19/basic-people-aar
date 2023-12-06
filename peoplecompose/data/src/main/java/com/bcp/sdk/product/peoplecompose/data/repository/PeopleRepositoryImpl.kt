package com.bcp.sdk.product.peoplecompose.data.repository

import com.bcp.sdk.product.peoplecompose.data.di.NetworkModule.apiService
import com.bcp.sdk.product.peoplecompose.data.di.NetworkModule.gson
import com.bcp.sdk.product.peoplecompose.data.mapper.toDomain
import com.bcp.sdk.product.peoplecompose.data.model.PeopleDataDTO
import com.bcp.sdk.product.peoplecompose.data.model.PeopleListDTO
import com.bcp.sdk.product.peoplecompose.domain.model.PeopleData
import com.bcp.sdk.product.peoplecompose.domain.model.PeopleList
import com.bcp.sdk.product.peoplecompose.domain.repository.PeopleRepository
import retrofit2.HttpException

class PeopleRepositoryImpl : PeopleRepository {

    override suspend fun getPeople(): Result<PeopleList> {
        return try {
            val result = apiService.getPeople()
            if (result.isSuccessful) {
                val json = gson.toJson(result.body())
                val peopleListDTO: PeopleListDTO =
                    gson.fromJson(json, PeopleListDTO::class.java)
                val peopleList = peopleListDTO.toDomain()
                Result.success(peopleList)
            } else {
                Result.failure(HttpException(result))
            }
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    override suspend fun getPeopleById(id: Int): Result<PeopleData> {
        return try {
            val result = apiService.getPeopleById(id)
            if (result.isSuccessful) {
                val json = gson.toJson(result.body())
                val peopleDataDTO: PeopleDataDTO =
                    gson.fromJson(json, PeopleDataDTO::class.java)
                val peopleData = peopleDataDTO.toDomain()
                Result.success(peopleData)
            } else {
                Result.failure(HttpException(result))
            }
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}