package com.omargtz.kavakfantasyapp.data.datasource

import com.omargtz.kavakfantasyapp.data.api.BrastlewarkApiService
import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import com.omargtz.kavakfantasyapp.data.repository.BrastlewarkRepository

class BrastlewarkRemoteDataSourceImp(private val apiService: BrastlewarkApiService): BrastlewarkDataSource{
    override suspend fun getPeople(): List<PeopleDto> {
        return apiService.getPeople()
    }
}