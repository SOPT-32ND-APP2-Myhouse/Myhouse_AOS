package com.example.myhouse_aos.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemRecommendProductBinding
import com.example.myhouse_aos.databinding.ItemSummerContentsBinding
import com.example.myhouse_aos.domain.model.ContentsData
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class SummerContentsAdapter : ListAdapter<ContentsData, SummerContentsAdapter.ContentViewHolder>(
    ItemDiffCallback<ContentsData>(
        onItemsTheSame = { old, new -> old.contentId == new.contentId },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    class ContentViewHolder(
        private val binding: ItemSummerContentsBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ContentsData) {
            val tvTitle = data.description
            val tvSubtitle = data.subDescription
            val connectedText = "${tvTitle}${tvSubtitle}"
            data.subDescription = connectedText
            data.description = ""
            binding.contentsData = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding =
            ItemSummerContentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}