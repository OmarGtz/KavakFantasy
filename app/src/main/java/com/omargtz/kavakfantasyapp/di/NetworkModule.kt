package com.omargtz.kavakfantasyapp.di

import android.app.Application
import com.google.gson.GsonBuilder
import com.omargtz.kavakfantasyapp.data.api.BrastlewarkApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideBrastleWarkApiService(): BrastlewarkApiService {
        val builder = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/rrafols/mobile_test/master/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(BrastlewarkApiService::class.java)
    }
}