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

    fun bind(item: Player) {
        val childAdapter = ChildPointsAdapter()
        val childLayoutManager = LinearLayoutManager(
            itemView.context, LinearLayoutManager.VERTICAL, false
        )
        val fragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
        with(binding) {
            playerTitle.text = item.name
            childRecyclerview.adapter = childAdapter
            childRecyclerview.layoutManager = childLayoutManager
            insertPointsButton.setOnClickListener {
                AddPointsDialogFragment().show(fragmentManager, "TAG")
            }
        }
        childAdapter.submitList(item.points)
    }
}