package com.ricardofachini.rummikubcalculator.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_local")
data class PlayerEntityLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo("name")val name: String,
    @ColumnInfo("points") val points: List<Int>,
)