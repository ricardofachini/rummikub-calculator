package com.ricardofachini.rummikubcalculator.domain.usecase

import com.ricardofachini.rummikubcalculator.domain.model.Player
import com.ricardofachini.rummikubcalculator.domain.repository.PlayerLocalRepositoryInterface
import javax.inject.Inject

class AddPlayerUseCase @Inject constructor(private val localRepositoryInterface: PlayerLocalRepositoryInterface) {

    suspend fun addPlayerToLocalDomain(player: Player): Long {
        return localRepositoryInterface.addPlayer(player)
    }
}