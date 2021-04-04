package com.omargtz.kavakfantasyapp.data.api

import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import retrofit2.http.GET

interface BrastlewarkApiService {
    @GET("https://raw.githubusercontent.com/rrafols/mobile_test/master/data.json")
    suspend fun getPeople(): List<PeopleDto>
}