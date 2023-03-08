package com.ricardofachini.rummikubcalculator.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "match_local")
data class MatchEntityLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo("players") val players: List<PlayerEntityLocal>,
    @ColumnInfo("max_number_of_points") val maxNumberOfPoints: Int,
    @ColumnInfo("winner") val winner: PlayerEntityLocal?,
)