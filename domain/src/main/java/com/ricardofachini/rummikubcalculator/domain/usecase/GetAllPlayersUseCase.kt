package com.ricardofachini.rummikubcalculator.domain.usecase

import com.ricardofachini.rummikubcalculator.domain.model.Player
import com.ricardofachini.rummikubcalculator.domain.repository.PlayerLocalRepositoryInterface
import javax.inject.Inject

class GetAllPlayersUseCase @Inject constructor(private val localRepositoryInterface: PlayerLocalRepositoryInterface) {

    suspend fun getAllPlayersFromLocal(): List<Player> {
        return localRepositoryInterface.getAllPlayers()
    }
}