package com.ricardofachini.rummikubcalculator.match.adapter

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.ricardofachini.rummikubcalculator.databinding.ItemRowPointsBinding

class ChildPointsViewHolder(
    private val binding: ItemRowPointsBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(actualMatchPoints: Int) {
        with(binding) {
            points.text = "$actualMatchPoints pontos"
            if (actualMatchPoints < 0) {
                points.setTextColor(Color.parseColor("#bf5f82"))
            } else {
                points.setTextColor(Color.parseColor("#43a047"))
            }
        }
    }
}