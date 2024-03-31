package com.ricardofachini.rummikubcalculator.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardofachini.rummikubcalculator.domain.model.Match
import com.ricardofachini.rummikubcalculator.domain.model.Player
import com.ricardofachini.rummikubcalculator.domain.usecase.AddPlayerUseCase
import com.ricardofachini.rummikubcalculator.domain.usecase.GetAllPlayersUseCase
import com.ricardofachini.rummikubcalculator.domain.usecase.UpdatePointsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val addPlayerUseCase: AddPlayerUseCase,
    private val getAllPlayersUseCase: GetAllPlayersUseCase,
    private val updatePointsUseCase: UpdatePointsUseCase,
):  ViewModel() {

    val playersList = MutableLiveData<List<Player>>()


    fun getList() {
        getAllPlayersUseCase.getAllPlayersFromLocal().onEach { data ->
            this.playersList.value = data
        }.launchIn(viewModelScope)
    }

    fun getPlayerFromId(playerId: Int): Player? {
        var player: Player? = null
        viewModelScope.launch {
            getAllPlayersUseCase.getAllPlayersFromLocal().onEach { data ->
                player = data.find { id ->
                    playerId.equals(id)
                }
            }
        }
        println(" ----- Player encontrado:  $player ------")
        return player
    }

    fun updatePoints(points: Int, playerId: Int) {
        viewModelScope.launch {
            updatePointsUseCase.update(points, playerId)
        }
    }

    fun addNewPlayer(name: String) {
        val player = Player(
            id = 0,
            name = name,
            mutableListOf(0)
        )
        //lista.add(player)
        viewModelScope.launch {
            val result = addPlayerUseCase.addPlayerToLocalDomain(player)
            println("resultado add player: $result")
            if (!result) {
                println("erro ao adicionar novo Player")
            }
        }
    }

}