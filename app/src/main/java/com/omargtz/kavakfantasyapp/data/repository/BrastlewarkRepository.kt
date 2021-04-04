package com.omargtz.kavakfantasyapp.data.repository

import com.omargtz.kavakfantasyapp.base.KavakResult
import com.omargtz.kavakfantasyapp.data.model.Brastlewark
import kotlinx.coroutines.flow.Flow

interface BrastlewarkRepository {
    fun getPeople(): Flow<KavakResult<Brastlewark>>
}