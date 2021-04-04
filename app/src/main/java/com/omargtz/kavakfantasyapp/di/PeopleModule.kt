package com.omargtz.kavakfantasyapp.di

import com.omargtz.kavakfantasyapp.data.datasource.BrastlewarkDataSource
import com.omargtz.kavakfantasyapp.data.datasource.BrastlewarkRemoteDataSourceImpl
import com.omargtz.kavakfantasyapp.data.repository.BrastlewarkRepository
import com.omargtz.kavakfantasyapp.data.repository.BrastlewarkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class PeopleModule {

    @Singleton
    @Binds
    abstract fun bindsRepository(impl: BrastlewarkRepositoryImpl): BrastlewarkRepository

    @Binds
    abstract fun bindsDataSource(impl: BrastlewarkRemoteDataSourceImpl): BrastlewarkDataSource

}