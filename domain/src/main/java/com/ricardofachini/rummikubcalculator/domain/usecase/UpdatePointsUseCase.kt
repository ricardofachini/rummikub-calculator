package com.ricardofachini.rummikubcalculator.domain.usecase

import com.ricardofachini.rummikubcalculator.domain.repository.PlayerLocalRepositoryInterface
import javax.inject.Inject

class UpdatePointsUseCase @Inject constructor(
    private val repositoryInterface: PlayerLocalRepositoryInterface
) {

    suspend fun update(points: Int, playerID: Int): Long {
        return repositoryInterface.updatePoints(playerID, points)
    }
}