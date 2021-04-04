package com.omargtz.kavakfantasyapp.data.repository

import com.omargtz.kavakfantasyapp.base.KavakResult
import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import kotlinx.coroutines.flow.Flow

interface BrastlewarkRepository {
    fun getPeople(): Flow<KavakResult<List<PeopleDto>>>
}