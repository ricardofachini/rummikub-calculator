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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val addPlayerUseCase: AddPlayerUseCase,
    private val getAllPlayersUseCase: GetAllPlayersUseCase,
    private val updatePointsUseCase: UpdatePointsUseCase,
):  ViewModel() {

//    private val currentMatch = Match(
//        id = -1,
//        players = MutableList(1),
//        maxNumberOfPoints = 2,
//        winner = null,
//    )

//    private val lista = mutableListOf(
//        Player(0, "nome1", mutableListOf(1, 2, 3)),
//        Player(1, "nome2", mutableListOf(-15, 25, 35)),
//        Player(2, "nome1", mutableListOf(12, 22, -31))
//    )
    val lista: MutableLiveData<List<Player>> by lazy {
        MutableLiveData<List<Player>>()
    }


    fun getList(): LiveData<List<Player>> {
        val result = MutableLiveData<List<Player>>()
        viewModelScope.launch {
            val list = getAllPlayersUseCase.getAllPlayersFromLocal()
            result.postValue(list)
        }
        return result
    }

    fun getPlayerFromId(playerId: Int): Player? {
        var player: Player? = null
        viewModelScope.launch {
            player = getAllPlayersUseCase.getAllPlayersFromLocal().find {
                    id -> playerId.equals(id)
            }
        }
        return player
    }

    fun updatePoints(points: Int, playerId: Int): LiveData<List<Player>> {
        viewModelScope.launch {
            updatePointsUseCase.update(points, playerId)
        }
        return getList()
    }

    fun addNewPlayer(name: String) {
        val player = Player(
            id = 0,
            name = name,
            mutableListOf()
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

    fun observe() {

    }
}