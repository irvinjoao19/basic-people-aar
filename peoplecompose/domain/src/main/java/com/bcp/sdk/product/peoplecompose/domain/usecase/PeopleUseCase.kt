package com.bcp.sdk.product.peoplecompose.domain.usecase

import com.bcp.sdk.product.peoplecompose.domain.model.PeopleList
import com.bcp.sdk.product.peoplecompose.domain.repository.PeopleRepository
import javax.inject.Inject

class PeopleUseCase @Inject constructor(private val peopleRepository: PeopleRepository) {
    suspend operator fun invoke(): Result<PeopleList> {
        return peopleRepository.getPeople()
    }
}