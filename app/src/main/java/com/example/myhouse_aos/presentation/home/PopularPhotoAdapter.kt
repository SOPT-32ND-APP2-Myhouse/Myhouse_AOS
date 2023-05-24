package com.example.myhouse_aos.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemPopularPhotoBinding
import com.example.myhouse_aos.domain.model.PopularContentsModel
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class PopularPhotoAdapter :
    ListAdapter<PopularContentsModel, PopularPhotoAdapter.PopularPhotoViewHolder>(
        ItemDiffCallback<PopularContentsModel>(
            onItemsTheSame = { old, new -> old.postId == new.postId },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {

    class PopularPhotoViewHolder(
        private val binding: ItemPopularPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: PopularContentsModel) {
                binding.popularContentsModel = data
                binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularPhotoViewHolder {
        val binding =
            ItemPopularPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularPhotoAdapter.PopularPhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularPhotoAdapter.PopularPhotoViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}
