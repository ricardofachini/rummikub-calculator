package com.ricardofachini.rummikubcalculator.match

import androidx.lifecycle.ViewModel
import com.ricardofachini.rummikubcalculator.domain.model.Player
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor():
    ViewModel() {

    val lista = mutableListOf(
        Player(0, "nome1", mutableListOf(1, 2, 3)),
        Player(1, "nome2", mutableListOf(-15, 25, 35)),
        Player(2, "nome1", mutableListOf(12, 22, -31))
    )

    fun getList(): List<Player> {
        return lista
    }

    fun getPlayerFromId(playerId: Int): Player {
        return lista[playerId]
    }

    fun addPoints(points: Int, playerId: Int): List<Player> {
        lista[playerId].points.add(points)
        println("lista: $lista")
        return lista
    }

    fun observe() {

    }
}