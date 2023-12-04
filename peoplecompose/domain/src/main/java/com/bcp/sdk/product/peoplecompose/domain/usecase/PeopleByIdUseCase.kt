package com.bcp.sdk.product.peoplecompose.domain.usecase

import com.bcp.sdk.product.peoplecompose.domain.model.PeopleData
import com.bcp.sdk.product.peoplecompose.domain.repository.PeopleRepository
import javax.inject.Inject

class PeopleByIdUseCase @Inject constructor(private val peopleRepository: PeopleRepository) {
    suspend operator fun invoke(id:Int): Result<PeopleData> {
        return peopleRepository.getPeopleById(id)
    }
}