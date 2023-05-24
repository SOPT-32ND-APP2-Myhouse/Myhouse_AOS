package com.example.myhouse_aos.presentation.content.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemContentHashtagBinding
import com.example.myhouse_aos.domain.model.HashTagData
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class ItemContentHashtagAdapter :
    ListAdapter<HashTagData, ItemContentHashtagAdapter.ItemContentHashtagViewHolder>(
        ItemDiffCallback<HashTagData>(
            onItemsTheSame = { old, new -> old.hash_tag == new.hash_tag },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {
    class ItemContentHashtagViewHolder(private val binding: ItemContentHashtagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HashTagData) {
            binding.data = data
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemContentHashtagViewHolder {
        val binding =
            ItemContentHashtagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemContentHashtagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemContentHashtagViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}