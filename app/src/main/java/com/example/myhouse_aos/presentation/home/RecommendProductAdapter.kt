package com.example.myhouse_aos.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemRecommendProductBinding
import com.example.myhouse_aos.domain.model.BestProductModel
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class RecommendProductAdapter : ListAdapter<BestProductModel, RecommendProductAdapter.ContentViewHolder>(
    ItemDiffCallback<BestProductModel>(
        onItemsTheSame = { old, new -> old.imageUrl == new.imageUrl },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    class ContentViewHolder(
        private val binding: ItemRecommendProductBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: BestProductModel) {
            binding.bestProductModel = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding =
            ItemRecommendProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}