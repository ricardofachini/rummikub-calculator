package com.ricardofachini.rummikubcalculator.domain.repository

import com.ricardofachini.rummikubcalculator.domain.model.Player

interface PlayerLocalRepositoryInterface {

    suspend fun getAllPlayers(): List<Player>

    suspend fun addPlayer(player: Player): Long
}