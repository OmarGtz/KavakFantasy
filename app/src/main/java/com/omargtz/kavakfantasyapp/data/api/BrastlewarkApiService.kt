package com.omargtz.kavakfantasyapp.data.api


import com.google.gson.JsonObject
import com.omargtz.kavakfantasyapp.data.model.Brastlewark
import retrofit2.http.GET



interface BrastlewarkApiService {
    @GET("data.json")
    suspend fun getPeople(): Brastlewark
}