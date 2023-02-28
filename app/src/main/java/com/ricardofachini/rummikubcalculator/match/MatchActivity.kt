package com.ricardofachini.rummikubcalculator.match

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ricardofachini.rummikubcalculator.R
import com.ricardofachini.rummikubcalculator.databinding.ActivityMatchBinding
import com.ricardofachini.rummikubcalculator.match.adapter.ChildPointsAdapter
import com.ricardofachini.rummikubcalculator.match.adapter.ParentPlayersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMatchBinding
    private lateinit var childPointsAdapter: ChildPointsAdapter
    private lateinit var parentPlayersAdapter: ParentPlayersAdapter
    private val viewModel: MatchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
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
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setupView() {
        childPointsAdapter = ChildPointsAdapter()
        parentPlayersAdapter = ParentPlayersAdapter()

        binding.playersList.adapter = parentPlayersAdapter
        binding.playersList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        parentPlayersAdapter.submitList(viewModel.getList())
    }
}