package com.ricardofachini.rummikubcalculator.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ricardofachini.rummikubcalculator.data.local.entity.PlayerEntityLocal

class Converters {
    @TypeConverter
    fun fromStringToList(value: String): List<Int> {
        // Assuming points are stored as a comma-separated string
        return value.split(",").map { it.toInt() }
    }

    @TypeConverter
    fun fromStringToListOfPlayerEntity(value: String): List<PlayerEntityLocal> {
        val listType = object : TypeToken<List<PlayerEntityLocal>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromStringToPlayerEntity(value: String) : PlayerEntityLocal? {
        return if (value != null) {
            Gson().fromJson(value, PlayerEntityLocal::class.java)
        } else {
            null
        }
    }

    @TypeConverter
    fun toStringFromPlayerEntity(playerEntityLocal: PlayerEntityLocal?): String? {
        return playerEntityLocal?.let {
            Gson().toJson(it)
        }
    }

    @TypeConverter
    fun toStringFromListOfPlayerEntity(list: List<PlayerEntityLocal>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun toStringFromListOfInt(list: List<Int>): String {
        // Convert the list of integers to a comma-separated string
        return list.joinToString(",")
    }
}