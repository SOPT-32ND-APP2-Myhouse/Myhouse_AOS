package com.example.myhouse_aos.presentation.content.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myhouse_aos.data.model.response.ResponseContentDetailDto
import com.example.myhouse_aos.databinding.ItemContentDetailBinding
import com.example.myhouse_aos.util.extension.ItemDiffCallback
import kotlin.reflect.KFunction0
import com.example.myhouse_aos.presentation.content.ContentViewModel as ContentViewModel

class ItemContentDetailAdapter(
    val showScrapSnackBar: (String) -> Unit,
    val contentViewModel: ContentViewModel
) :
    ListAdapter<ResponseContentDetailDto.Data.Image, ItemContentDetailAdapter.ItemContentDetailViewHolder>(
        ItemDiffCallback<ResponseContentDetailDto.Data.Image>(
            onItemsTheSame = { old, new -> old.image_id == new.image_id },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {
    var recentScrapId = 1
    class ItemContentDetailViewHolder(private val binding: ItemContentDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(
            data: ResponseContentDetailDto.Data.Image,
            showScrapSnackBar: (String) -> Unit,
            contentViewModel: ContentViewModel,
        ) {
            binding.data = data
            Glide.with(binding.root.context).load(data.image_url).into(binding.ivItemContentdetail)
            if (data.content == null) {
                binding.tvItemContentdetail.visibility = View.GONE
            }

            binding.btnItemContentdetailScrap.setOnClickListener {
                if (binding.btnItemContentdetailScrap.isSelected) {
                    binding.btnItemContentdetailScrap.isSelected = false
                } else {
                    contentViewModel.scrap(data.image_url)
                    contentViewModel.imageUrl = data.image_url
                    binding.btnItemContentdetailScrap.isSelected = true
                }
            }

            contentViewModel.scrapResult.observeForever { scrapResult->
                showScrapSnackBar(data.image_url)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemContentDetailViewHolder {
        val binding =
            ItemContentDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemContentDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemContentDetailViewHolder, position: Int) {
        holder.onBind(getItem(position), showScrapSnackBar, contentViewModel)
    }
}