package com.ricardofachini.rummikubcalculator.data

import android.content.Context
import com.ricardofachini.rummikubcalculator.data.local.AppDatabase
import com.ricardofachini.rummikubcalculator.data.local.dao.MatchDao
import com.ricardofachini.rummikubcalculator.data.local.dao.PlayerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun providesMainAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providesMatchDao(appDatabase: AppDatabase): MatchDao {
        return appDatabase.matchDao()
    }

    @Provides
    fun providesPlayerDao(appDatabase: AppDatabase): PlayerDao {
        return appDatabase.playerDao()
    }
}