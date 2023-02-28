package com.ricardofachini.rummikubcalculator.match

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
        return super.onCreateOptionsMenu(menu)
    }

    private fun setupView() {
        childPointsAdapter = ChildPointsAdapter()
        parentPlayersAdapter = ParentPlayersAdapter()

        binding.playersList.adapter = parentPlayersAdapter
        binding.playersList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        parentPlayersAdapter.submitList(viewModel.getList())
    }
}