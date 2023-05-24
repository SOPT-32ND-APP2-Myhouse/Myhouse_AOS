package com.example.myhouse_aos.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemCategoryProductBinding
import com.example.myhouse_aos.domain.model.ContentsData
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class TodayPlanAdapter :
    ListAdapter<ContentsData, TodayPlanAdapter.PlanViewHolder>(
        ItemDiffCallback<ContentsData>(
            onItemsTheSame = { old, new -> old.contentId == new.contentId },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {

    class PlanViewHolder(
        private val binding: ItemCategoryProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ContentsData) {
            binding.contentsData = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val binding =
            ItemCategoryProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodayPlanAdapter.PlanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}
