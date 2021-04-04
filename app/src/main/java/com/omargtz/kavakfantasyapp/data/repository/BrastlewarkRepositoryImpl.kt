package com.omargtz.kavakfantasyapp.data.repository

import com.omargtz.kavakfantasyapp.base.KavakResult
import com.omargtz.kavakfantasyapp.data.datasource.BrastlewarkDataSource
import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BrastlewarkRepositoryImpl(private val remoteDatasource: BrastlewarkDataSource): BrastlewarkRepository {
    override fun getPeople(): Flow<KavakResult<List<PeopleDto>>> = flow {
        emit(KavakResult.Loading)
        val people = remoteDatasource.getPeople()
        emit(KavakResult.Success(people))
    }
}