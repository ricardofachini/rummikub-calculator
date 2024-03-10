package com.ricardofachini.rummikubcalculator.domain.repository

import com.ricardofachini.rummikubcalculator.domain.model.Player

interface PlayerLocalRepositoryInterface {

    suspend fun getAllPlayers(): List<Player>

    suspend fun updatePoints(playerID: Int, points: Int): Long

    suspend fun addPlayer(player: Player): Boolean
}