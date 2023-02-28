package com.ricardofachini.rummikubcalculator.match.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ricardofachini.rummikubcalculator.databinding.ItemRowPointsBinding

class ChildPointsViewHolder(
    private val binding: ItemRowPointsBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(actualMatchPoints: Int) {
        with(binding) {
            points.text = "$actualMatchPoints pontos"
        }
    }
}