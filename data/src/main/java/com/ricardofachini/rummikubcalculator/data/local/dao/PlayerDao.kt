package com.ricardofachini.rummikubcalculator.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import com.ricardofachini.rummikubcalculator.data.local.entity.PlayerEntityLocal

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player_local")
    fun getAll(): Flow<List<PlayerEntityLocal>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlayer(player: PlayerEntityLocal): Long

    @Query(" UPDATE player_local SET points=:points WHERE id=:id")
    suspend fun updatePlayer(id: Int, points: Int)
}