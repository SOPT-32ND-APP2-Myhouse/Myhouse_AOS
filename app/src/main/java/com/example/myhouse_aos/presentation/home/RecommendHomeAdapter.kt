package com.example.myhouse_aos.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemRecommendHomeBinding
import com.example.myhouse_aos.domain.model.RecommendHomeModel
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class RecommendHomeAdapter : ListAdapter<RecommendHomeModel, RecommendHomeAdapter.ContentViewHolder>(
    ItemDiffCallback<RecommendHomeModel>(
        onItemsTheSame = { old, new -> old.postId == new.postId },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    class ContentViewHolder(
        private val binding: ItemRecommendHomeBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RecommendHomeModel) {
            binding.recommendHomeModel = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding =
            ItemRecommendHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}