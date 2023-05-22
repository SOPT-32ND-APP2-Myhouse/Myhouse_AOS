package com.example.myhouse_aos.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemRecommendHomeBinding
import com.example.myhouse_aos.databinding.ItemRecommendProductBinding
import com.example.myhouse_aos.domain.model.ContentsData
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class RecommendProductAdapter : ListAdapter<ContentsData, RecommendProductAdapter.ContentViewHolder>(
    ItemDiffCallback<ContentsData>(
        onItemsTheSame = { old, new -> old.contentId == new.contentId },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    class ContentViewHolder(
        private val binding: ItemRecommendProductBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ContentsData) {
            binding.contentsData = data
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