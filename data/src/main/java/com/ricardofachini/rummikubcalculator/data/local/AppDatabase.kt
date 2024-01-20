package com.ricardofachini.rummikubcalculator.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ricardofachini.rummikubcalculator.data.local.dao.MatchDao
import com.ricardofachini.rummikubcalculator.data.local.dao.PlayerDao
import com.ricardofachini.rummikubcalculator.data.local.entity.MatchEntityLocal
import com.ricardofachini.rummikubcalculator.data.local.entity.PlayerEntityLocal

@Database(entities = [PlayerEntityLocal::class, MatchEntityLocal::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun matchDao(): MatchDao

    abstract fun playerDao(): PlayerDao

    companion object {
        @Volatile
        var databaseInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return databaseInstance ?: synchronized(this) {
                databaseInstance ?: buildDatabase(context).also {
                    databaseInstance = it
                }
            }

        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "RummikubCalcDatabase.db")
                .addCallback(
                    object : RoomDatabase.Callback() {
                    }
                )
                .build()
        }
    }
}