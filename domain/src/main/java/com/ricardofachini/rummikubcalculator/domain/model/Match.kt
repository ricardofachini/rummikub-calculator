package com.ricardofachini.rummikubcalculator.domain.model

data class Match(
    val id: Int,
    val players: List<Player>,
    val maxNumberOfPoints: Int,
    val winner: Player?
)
