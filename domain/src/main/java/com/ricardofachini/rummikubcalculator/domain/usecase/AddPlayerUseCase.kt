package com.ricardofachini.rummikubcalculator.domain.usecase

import com.ricardofachini.rummikubcalculator.domain.model.Player
import com.ricardofachini.rummikubcalculator.domain.repository.PlayerLocalRepositoryInterface

class AddPlayerUseCase(private val localRepositoryInterface: PlayerLocalRepositoryInterface) {

    suspend fun addPlayerToLocalDomain(player: Player): Boolean {
        return localRepositoryInterface.addPlayer(player)
    }
}