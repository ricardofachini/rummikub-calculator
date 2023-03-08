package com.ricardofachini.rummikubcalculator.domain.model

data class Player(
    val id: Int,
    val name: String,
    val points: MutableList<Int>
)
