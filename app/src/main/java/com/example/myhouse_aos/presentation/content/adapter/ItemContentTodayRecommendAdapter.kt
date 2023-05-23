package com.example.myhouse_aos.presentation.content.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ItemContentTodayRecommendBinding
import com.example.myhouse_aos.domain.model.TodayRecommendData
import com.example.myhouse_aos.util.extension.ItemDiffCallback
import com.example.myhouse_aos.util.snackbar.ScrapSnackBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.NonDisposableHandle.parent

class ItemContentTodayRecommendAdapter : ListAdapter<TodayRecommendData, ItemContentTodayRecommendAdapter.ItemContentTodayRecommendViewHolder>(
    ItemDiffCallback<TodayRecommendData>(
        onItemsTheSame = {old, new -> old.todayrecommend_id == new.todayrecommend_id},
        onContentsTheSame = {old, new -> old == new}
    )
) {
    class ItemContentTodayRecommendViewHolder(private val binding: ItemContentTodayRecommendBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun onBind(data: TodayRecommendData){
                binding.data = data

                binding.btnItemContentTodayrecommendBookmark.setOnClickListener {
                    if(binding.btnItemContentTodayrecommendBookmark.isSelected){
                        binding.btnItemContentTodayrecommendBookmark.isSelected = false
                        binding.btnItemContentTodayrecommendBookmark.setImageResource(R.drawable.bookmark)
                    }else{
                        ScrapSnackBar.make(binding.root).show()
                        binding.btnItemContentTodayrecommendBookmark.isSelected = true
                        binding.btnItemContentTodayrecommendBookmark.setImageResource(R.drawable.bookmark_clicked)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemContentTodayRecommendAdapter.ItemContentTodayRecommendViewHolder {
        val binding = ItemContentTodayRecommendBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemContentTodayRecommendAdapter.ItemContentTodayRecommendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemContentTodayRecommendViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

}