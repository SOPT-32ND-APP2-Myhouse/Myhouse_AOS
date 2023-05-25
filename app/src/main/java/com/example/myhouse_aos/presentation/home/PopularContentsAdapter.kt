package com.example.myhouse_aos.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemPopularContentsBinding
import com.example.myhouse_aos.domain.model.PopularContentsModel
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class PopularContentsAdapter() :
    ListAdapter<PopularContentsModel, PopularContentsAdapter.PopularContentsViewHolder>(
        ItemDiffCallback<PopularContentsModel>(
            onItemsTheSame = { old, new -> old.postId == new.postId },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {

    class PopularContentsViewHolder(
        private val binding: ItemPopularContentsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: PopularContentsModel) {
            val tvTitle = data.title
            val tvSubtitle = data.subTitle
            val connectedText = "${tvTitle}\n${tvSubtitle}"
            val connectedTextTruncated = if (connectedText.length > 14) {
                connectedText.substring(0, 14) + "\n" + connectedText.substring(14)
            } else {
                connectedText
            }
            data.title = connectedTextTruncated
            data.subTitle = ""
            binding.popularContentsModel = data
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
