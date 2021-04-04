package com.omargtz.kavakfantasyapp.data.datasource

import com.google.gson.JsonObject
import com.omargtz.kavakfantasyapp.data.model.Brastlewark


interface BrastlewarkDataSource {
    suspend fun getPeople(): Brastlewark
}