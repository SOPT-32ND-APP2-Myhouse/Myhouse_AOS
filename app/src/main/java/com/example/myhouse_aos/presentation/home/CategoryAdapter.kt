package com.example.myhouse_aos.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemCategoryProductBinding
import com.example.myhouse_aos.domain.model.ContentsData
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class CategoryAdapter() :
    ListAdapter<ContentsData, CategoryAdapter.CategoryViewHolder>(
        ItemDiffCallback<ContentsData>(
            onItemsTheSame = { old, new -> old.contentId == new.contentId },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {

    class CategoryViewHolder(
        private val binding: ItemCategoryProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ContentsData) {
            binding.contentsData = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

}
