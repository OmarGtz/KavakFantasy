package com.omargtz.kavakfantasyapp.data.repository

import com.omargtz.kavakfantasyapp.base.KavakResult
import com.omargtz.kavakfantasyapp.data.datasource.BrastlewarkDataSource
import com.omargtz.kavakfantasyapp.data.model.Brastlewark
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BrastlewarkRepositoryImpl @Inject constructor(private val remoteDatasource: BrastlewarkDataSource): BrastlewarkRepository {
    override fun getPeople(): Flow<KavakResult<Brastlewark>> = flow {
        emit(KavakResult.Loading)
        val people = remoteDatasource.getPeople()
        emit(KavakResult.Success(people))
    }
}