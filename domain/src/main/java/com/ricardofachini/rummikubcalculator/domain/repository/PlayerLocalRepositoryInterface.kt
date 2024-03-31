package com.ricardofachini.rummikubcalculator.domain.repository

import com.ricardofachini.rummikubcalculator.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerLocalRepositoryInterface {

    fun getAllPlayers():  Flow<List<Player>>

    suspend fun updatePoints(playerID: Int, points: Int): Boolean

    suspend fun addPlayer(player: Player): Boolean
}