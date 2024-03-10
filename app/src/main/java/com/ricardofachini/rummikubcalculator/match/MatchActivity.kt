package com.ricardofachini.rummikubcalculator.match

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ricardofachini.rummikubcalculator.R
import com.ricardofachini.rummikubcalculator.databinding.ActivityMatchBinding
import com.ricardofachini.rummikubcalculator.domain.model.Player
import com.ricardofachini.rummikubcalculator.match.adapter.ChildPointsAdapter
import com.ricardofachini.rummikubcalculator.match.adapter.ParentPlayersAdapter
import com.ricardofachini.rummikubcalculator.match.adapter.ParentPlayersViewHolder
import com.ricardofachini.rummikubcalculator.match.dialog.AddPlayerDialogFragment
import com.ricardofachini.rummikubcalculator.match.dialog.AddPlayerDialogListener
import com.ricardofachini.rummikubcalculator.match.dialog.AddPointsDialogFragment
import com.ricardofachini.rummikubcalculator.match.dialog.AddPointsDialogListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchActivity: AppCompatActivity(),AddPointsDialogListener, AddPlayerDialogListener, ParentPlayersViewHolder.OnButtonClickListener {
    private lateinit var binding: ActivityMatchBinding
    private lateinit var childPointsAdapter: ChildPointsAdapter
    private lateinit var parentPlayersAdapter: ParentPlayersAdapter
    private val viewModel: MatchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        //viewModel.getList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_match, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.cancel_match -> {
                //CANCELA A PARTIDA SEM SALVAR NADA
                true
            }
            R.id.finish_match -> {
                //TERMINA A PARTIDA, SALVANDO COMO ESTÁ AGORA
                true
            }
            R.id.add_player -> {
                val fragment = AddPlayerDialogFragment()
                fragment.show(supportFragmentManager, "TAG")
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onAddPointsDialogPositiveClick(points: Int, id: Int?) {
        if (id != null) {
            viewModel.updatePoints(points, id)
            //parentPlayersAdapter.submitList(viewModel.updatePoints(points, id)) //USAR algum observable - ESTA ERRADO
            //parentPlayersAdapter.notifyItemChanged(id)
        }
    }

    /**
    Usuário clica no botão para adicionar pontos para determinado player
     */
    override fun onButtonClick(playerId: Int) {
        val name = viewModel.getPlayerFromId(playerId)?.name
        val fragment = AddPointsDialogFragment()
        val playerIdArgs = Bundle().apply {
            putString("player_name", name)
            putInt("player_id", playerId)
        }

        fragment.arguments = playerIdArgs
        fragment.show(supportFragmentManager, "TAG")
    }

    private fun setupView() {
        childPointsAdapter = ChildPointsAdapter()
        parentPlayersAdapter = ParentPlayersAdapter()

        binding.playersList.adapter = parentPlayersAdapter
        binding.playersList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        viewModel.getList().observe(this, Observer { it ->
            parentPlayersAdapter.submitList(it)
        })
    }

    override fun addPlayerNameToCurrentMatch(name: String) {
        viewModel.addNewPlayer(name)
        //parentPlayersAdapter.notifyItemChanged(-1)
    }
}