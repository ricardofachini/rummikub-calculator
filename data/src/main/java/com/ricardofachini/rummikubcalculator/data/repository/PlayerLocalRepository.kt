package com.ricardofachini.rummikubcalculator.data.repository

import com.ricardofachini.rummikubcalculator.data.local.AppDatabase
import com.ricardofachini.rummikubcalculator.data.local.entity.PlayerEntityLocal
import com.ricardofachini.rummikubcalculator.domain.model.Player
import com.ricardofachini.rummikubcalculator.domain.repository.PlayerLocalRepositoryInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerLocalRepository @Inject constructor(
    private val database: AppDatabase
): PlayerLocalRepositoryInterface {

    override fun getAllPlayers(): Flow<List<Player>> {
        val teste = database.playerDao().getAll()
        println("teste = $teste")
        return database.playerDao().getAll().map { data ->
            println("player from dao: $data")
            data.map {entity ->
                entity.toDomain()
            }
        }
    }

    override suspend fun updatePoints(playerID: Int, points: Int): Boolean {
        return try {
            database.playerDao().updatePlayer(playerID, points)
            true
        }   catch (error: Throwable) {
            false
        }
    }

    override suspend fun addPlayer(player: Player): Boolean {
        return try {
            database.playerDao().insertPlayer(player.toData())
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
            points = points.toList()
        )
    }

}