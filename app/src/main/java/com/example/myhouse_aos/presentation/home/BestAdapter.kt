package com.example.myhouse_aos.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemBestBinding
import com.example.myhouse_aos.domain.model.BestProductModel
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class BestAdapter : ListAdapter<BestProductModel, BestAdapter.ContentViewHolder>(
    ItemDiffCallback<BestProductModel>(
        onItemsTheSame = { old, new -> old.imageUrl == new.imageUrl },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    class ContentViewHolder(
        private val binding: ItemBestBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: BestProductModel) {
            binding.bestProductModel = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding =
            ItemBestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestAdapter.ContentViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

}