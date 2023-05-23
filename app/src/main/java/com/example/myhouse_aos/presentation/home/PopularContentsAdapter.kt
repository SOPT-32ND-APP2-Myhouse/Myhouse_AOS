package com.example.myhouse_aos.presentation.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ItemPopularContentsBinding
import com.example.myhouse_aos.domain.model.ContentsData
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
            val connectedText = "${tvTitle}${tvSubtitle}"
            data.title = connectedText
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
