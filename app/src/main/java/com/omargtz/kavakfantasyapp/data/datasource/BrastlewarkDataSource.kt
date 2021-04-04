package com.omargtz.kavakfantasyapp.data.datasource

import com.omargtz.kavakfantasyapp.data.model.PeopleDto

interface BrastlewarkDataSource {
    suspend fun getPeople(): List<PeopleDto>
}