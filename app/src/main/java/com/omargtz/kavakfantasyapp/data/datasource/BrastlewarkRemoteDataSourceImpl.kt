package com.omargtz.kavakfantasyapp.data.datasource

import com.google.gson.JsonObject
import com.omargtz.kavakfantasyapp.data.api.BrastlewarkApiService
import com.omargtz.kavakfantasyapp.data.model.Brastlewark
import javax.inject.Inject

class BrastlewarkRemoteDataSourceImpl @Inject constructor(private val apiService: BrastlewarkApiService): BrastlewarkDataSource{
    override suspend fun getPeople(): Brastlewark {
        return apiService.getPeople()
    }
}