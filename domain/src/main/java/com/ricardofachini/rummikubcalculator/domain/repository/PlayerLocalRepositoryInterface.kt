package com.ricardofachini.rummikubcalculator.domain.repository

import com.ricardofachini.rummikubcalculator.domain.model.Player

interface PlayerLocalRepositoryInterface {

    fun getAllPlayers(): List<Player>
}