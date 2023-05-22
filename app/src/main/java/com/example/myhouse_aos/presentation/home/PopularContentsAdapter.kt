package com.example.myhouse_aos.presentation.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemPopularContentsBinding
import com.example.myhouse_aos.domain.model.ContentsData
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class PopularContentsAdapter() :
    ListAdapter<ContentsData, PopularContentsAdapter.PopularContentsViewHolder>(
        ItemDiffCallback<ContentsData>(
            onItemsTheSame = { old, new -> old.contentId == new.contentId },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {

    class PopularContentsViewHolder(
        private val binding: ItemPopularContentsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ContentsData) {
            binding.contentsData = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularContentsViewHolder {
        val binding =
            ItemPopularContentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularContentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularContentsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

}
