package com.ricardofachini.rummikubcalculator.match

import androidx.lifecycle.ViewModel
import com.ricardofachini.rummikubcalculator.domain.model.Player
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor():
    ViewModel() {

    private val lista = mutableListOf(
        Player(0, "nome1", listOf(1, 2, 3)),
        Player(1, "nome2", listOf(15, 25, 35)),
        Player(2, "nome1", listOf(12, 22, 31))
    )

    fun getList(): List<Player> {
        return lista
    }
}