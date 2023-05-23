package com.example.myhouse_aos.presentation.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemHotContentBinding
import com.example.myhouse_aos.domain.model.PostContent
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class HotContentAdapter : ListAdapter<PostContent, HotContentAdapter.HotContentViewHodler>(
    ItemDiffCallback<PostContent>(
        onItemsTheSame = { old, new -> old.postId == new.postId },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    class HotContentViewHodler(
        private val binding: ItemHotContentBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(content: PostContent) {
            binding.content = content
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotContentViewHodler {
        val binding =
            ItemHotContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotContentViewHodler(binding)
    }

    override fun onBindViewHolder(holder: HotContentViewHodler, position: Int) {
        holder.onBind(getItem(position))
    }
}