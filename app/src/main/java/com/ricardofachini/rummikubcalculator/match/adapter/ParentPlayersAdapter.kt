package com.ricardofachini.rummikubcalculator.match.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ricardofachini.rummikubcalculator.databinding.ItemRowPlayersBinding
import com.ricardofachini.rummikubcalculator.domain.model.Player

class ParentPlayersAdapter: ListAdapter<Player, ParentPlayersViewHolder>(ParentPlayersAdapter) {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ParentPlayersViewHolder {
        val binding = ItemRowPlayersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ParentPlayersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParentPlayersViewHolder,position: Int) {
        val item = getItem(position)
        println("item do parent viewholder: $item")
        holder.bind(item)
    }

    fun addData(pointsList: List<Int>) {
        
    }

    companion object TodoDiffCallback: DiffUtil.ItemCallback<Player>() {
        override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem == newItem
        }
    }
}