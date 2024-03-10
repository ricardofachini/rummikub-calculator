package com.ricardofachini.rummikubcalculator.data.repository

import com.ricardofachini.rummikubcalculator.data.local.AppDatabase
import com.ricardofachini.rummikubcalculator.data.local.entity.PlayerEntityLocal
import com.ricardofachini.rummikubcalculator.domain.model.Player
import com.ricardofachini.rummikubcalculator.domain.repository.PlayerLocalRepositoryInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerLocalRepository @Inject constructor(
    private val database: AppDatabase
): PlayerLocalRepositoryInterface {

    override suspend fun getAllPlayers(): List<Player> {
        return database.playerDao().getAll().map {
            it.toDomain()
        }
    }

    override suspend fun updatePoints(playerID: Int, points: Int): Long {
        TODO("Not yet implemented")
    }

    override suspend fun addPlayer(player: Player): Boolean {
        return try {
            database.playerDao().insertPlayer(player = player.toData())
            true
        } catch (error: Throwable) {
            println("erro: $error")
            false
        }
    }

    private fun PlayerEntityLocal.toDomain(): Player {
        return Player(
            id = id,
            name = name,
            points = points as MutableList<Int>
        )
    }

    private fun Player.toData(): PlayerEntityLocal {
        return PlayerEntityLocal(
            id = id,
            name = name,
            points = points
        )
    }

}