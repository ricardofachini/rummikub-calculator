package com.ricardofachini.rummikubcalculator.match.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ricardofachini.rummikubcalculator.databinding.ItemRowPointsBinding
import com.ricardofachini.rummikubcalculator.domain.model.Player

class ChildPointsAdapter: ListAdapter<Int, ChildPointsViewHolder>(ChildPointsAdapter) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildPointsViewHolder {
        val binding = ItemRowPointsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildPointsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildPointsViewHolder,position: Int) {
        val item = getItem(position)
        println("ITEM do childadapter getItemId: $item")
        holder.bind(item)
    }

    companion object TodoDiffCallback: DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }
}