package com.ricardofachini.rummikubcalculator.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.ricardofachini.rummikubcalculator.data.local.entity.MatchEntityLocal

@Dao
interface MatchDao {

    @Query("SELECT * FROM match_local")
    fun getAll(): List<MatchEntityLocal>
}