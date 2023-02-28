package com.ricardofachini.rummikubcalculator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.ricardofachini.rummikubcalculator.databinding.ActivityHomeBinding
import com.ricardofachini.rummikubcalculator.match.MatchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    private fun setupView() {
        binding.newMatchButton.setOnClickListener {
            val switchActivityIntent = Intent(this, MatchActivity::class.java)
            startActivity(switchActivityIntent)
        }
    }
}