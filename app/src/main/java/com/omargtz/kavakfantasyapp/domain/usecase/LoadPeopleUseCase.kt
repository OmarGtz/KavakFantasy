package com.omargtz.kavakfantasyapp.domain.usecase

import com.omargtz.kavakfantasyapp.base.FlowUseCase
import com.omargtz.kavakfantasyapp.base.KavakResult
import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import com.omargtz.kavakfantasyapp.data.repository.BrastlewarkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class LoadPeopleUseCase(private val repository: BrastlewarkRepository) : FlowUseCase<Unit, List<PeopleDto>>(Dispatchers.IO) {
    override fun execute(parameters: Unit): Flow<KavakResult<List<PeopleDto>>> {
        return repository.getPeople()
    }

}