package com.ricardofachini.rummikubcalculator.match.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ricardofachini.rummikubcalculator.databinding.ItemRowPlayersBinding
import com.ricardofachini.rummikubcalculator.domain.model.Player

class ParentPlayersViewHolder(
    private val binding: ItemRowPlayersBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Player) {
        val childAdapter = ChildPointsAdapter()
        val childLayoutManager = LinearLayoutManager(
            itemView.context, LinearLayoutManager.VERTICAL, false
        )
        with(binding) {
            playerTitle.text = item.name
            childRecyclerview.adapter = childAdapter
            childRecyclerview.layoutManager = childLayoutManager
        }
        childAdapter.submitList(item.points)
    }
}