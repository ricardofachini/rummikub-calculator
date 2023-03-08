package com.ricardofachini.rummikubcalculator.data.local

import androidx.room.Database
import com.ricardofachini.rummikubcalculator.data.local.dao.MatchDao
import com.ricardofachini.rummikubcalculator.data.local.dao.PlayerDao
import com.ricardofachini.rummikubcalculator.data.local.entity.MatchEntityLocal
import com.ricardofachini.rummikubcalculator.data.local.entity.PlayerEntityLocal

@Database(entities = [PlayerEntityLocal::class, MatchEntityLocal::class], version = 1)
abstract class AppDatabase {
    abstract fun matchDao(): MatchDao

    abstract fun playerDao(): PlayerDao
}