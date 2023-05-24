package com.example.myhouse_aos.presentation.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemPostContentBinding
import com.example.myhouse_aos.domain.model.PostContent
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class ContentAdapter(
    private val moveToContent: () -> Unit,
) : ListAdapter<PostContent, ContentAdapter.ContentViewHolder>(
    ItemDiffCallback<PostContent>(
        onItemsTheSame = { old, new -> old.postId == new.postId },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    class ContentViewHolder(
        private val binding: ItemPostContentBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(
            content: PostContent,
            moveToContent: () -> Unit,
        ) {
            binding.content = content
            binding.executePendingBindings()

            binding.ivContentImage.setOnClickListener {
                moveToContent()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding =
            ItemPostContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.onBind(getItem(position), moveToContent)
    }
}