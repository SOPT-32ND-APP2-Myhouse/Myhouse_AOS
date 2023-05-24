package com.example.myhouse_aos.presentation.content.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myhouse_aos.data.model.response.ResponseContentDetailDto
import com.example.myhouse_aos.databinding.ItemContentDetailBinding
import com.example.myhouse_aos.domain.model.ContentDetailData
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class ItemContentDetailAdapter(
    val showScrapSnackBar: () -> Unit,
) :
    ListAdapter<ResponseContentDetailDto.Data.Image, ItemContentDetailAdapter.ItemContentDetailViewHolder>(
        ItemDiffCallback<ResponseContentDetailDto.Data.Image>(
            onItemsTheSame = { old, new -> old.image_id == new.image_id },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {
    class ItemContentDetailViewHolder(private val binding: ItemContentDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(
            data: ResponseContentDetailDto.Data.Image,
            showScrapSnackBar: () -> Unit,) {
            binding.data = data
            Glide.with(binding.root.context).load(data.image_url).into(binding.ivItemContentdetail)
            if (data.content == null) {
                binding.tvItemContentdetail.visibility = View.GONE
            }

            binding.btnItemContentdetailScrap.setOnClickListener {
                if (binding.btnItemContentdetailScrap.isSelected) {
                    binding.btnItemContentdetailScrap.isSelected = false
                } else {
                    binding.btnItemContentdetailScrap.isSelected = true
                    showScrapSnackBar()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemContentDetailViewHolder {
        val binding =
            ItemContentDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemContentDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemContentDetailViewHolder, position: Int) {
        holder.onBind(getItem(position), showScrapSnackBar)
    }
}