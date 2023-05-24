package com.example.myhouse_aos.presentation.content.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemContentUserimageBinding
import com.example.myhouse_aos.domain.model.UserimageData
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class ItemContentUserimageAdapter :
    ListAdapter<UserimageData, ItemContentUserimageAdapter.ItemContentUserimageViewHolder>(
        ItemDiffCallback<UserimageData>(
            onItemsTheSame = { old, new -> old.image == new.image },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {
    class ItemContentUserimageViewHolder(private val binding: ItemContentUserimageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: UserimageData) {
            binding.data = data
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ItemContentUserimageViewHolder {
        val binding =
            ItemContentUserimageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemContentUserimageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemContentUserimageViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}