package com.ricardofachini.rummikubcalculator.utils

import com.ricardofachini.rummikubcalculator.data.local.AppDatabase
import com.ricardofachini.rummikubcalculator.data.repository.PlayerLocalRepository
import com.ricardofachini.rummikubcalculator.domain.repository.PlayerLocalRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesLocalPlayerRepository(database: AppDatabase): PlayerLocalRepositoryInterface {
        return PlayerLocalRepository(database)
    }

}