package com.example.myhouse_aos.presentation.scrap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemScrapBinding
import com.example.myhouse_aos.domain.model.Scrap
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class ScrapAdapter :
    ListAdapter<Scrap, ScrapAdapter.ScrapViewHolder>(
        ItemDiffCallback<Scrap>(
            onItemsTheSame = { old, new -> old.scrapId == new.scrapId },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {

    class ScrapViewHolder(
        private val binding: ItemScrapBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(scrapData: Scrap) {
            binding.scrap = scrapData
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScrapViewHolder {
        val binding =
            ItemScrapBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScrapViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScrapViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


    override fun getItemCount(): Int {
        return minOf(super.getItemCount(), 4)
    }
}