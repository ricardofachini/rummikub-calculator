package com.ricardofachini.rummikubcalculator.domain.usecase

import com.ricardofachini.rummikubcalculator.domain.model.Player
import com.ricardofachini.rummikubcalculator.domain.repository.PlayerLocalRepositoryInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllPlayersUseCase @Inject constructor(private val localRepositoryInterface: PlayerLocalRepositoryInterface) {

    fun getAllPlayersFromLocal(): Flow<List<Player>> {
        return localRepositoryInterface.getAllPlayers()
    }
}