package com.ricardofachini.rummikubcalculator.match.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ricardofachini.rummikubcalculator.databinding.ItemRowPlayersBinding
import com.ricardofachini.rummikubcalculator.domain.model.Player
import com.ricardofachini.rummikubcalculator.match.AddPointsDialogFragment

class ParentPlayersViewHolder(
    private val binding: ItemRowPlayersBinding
): RecyclerView.ViewHolder(binding.root) {

    interface OnButtonClickListener {
        fun onButtonClick(playerId: Int)
    }

    fun bind(item: Player) {
        val childAdapter = ChildPointsAdapter()
        val childLayoutManager = LinearLayoutManager(
            itemView.context, LinearLayoutManager.VERTICAL, false
        )
        val fragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
        val listener = itemView.context as OnButtonClickListener
        with(binding) {
            playerTitle.text = item.name
            childRecyclerview.adapter = childAdapter
            childRecyclerview.layoutManager = childLayoutManager
            insertPointsButton.setOnClickListener {
                listener.onButtonClick(item.id)
            }
        }
        childAdapter.submitList(item.points)
    }
}