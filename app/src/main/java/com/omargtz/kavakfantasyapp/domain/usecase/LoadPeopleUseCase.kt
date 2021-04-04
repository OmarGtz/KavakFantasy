package com.omargtz.kavakfantasyapp.domain.usecase

import com.google.gson.JsonObject
import com.omargtz.kavakfantasyapp.base.FlowUseCase
import com.omargtz.kavakfantasyapp.base.KavakResult
import com.omargtz.kavakfantasyapp.data.model.Brastlewark
import com.omargtz.kavakfantasyapp.data.repository.BrastlewarkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadPeopleUseCase @Inject constructor(private val repository: BrastlewarkRepository) : FlowUseCase<Unit, Brastlewark>(Dispatchers.IO) {
    override fun execute(parameters: Unit): Flow<KavakResult<Brastlewark>> {
        return repository.getPeople()
    }
}