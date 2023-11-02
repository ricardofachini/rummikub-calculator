package com.ricardofachini.rummikubcalculator.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ricardofachini.rummikubcalculator.data.local.entity.PlayerEntityLocal

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player_local")
    suspend fun getAll(): List<PlayerEntityLocal>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlayer(player: PlayerEntityLocal): Boolean
}