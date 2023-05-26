package com.example.myhouse_aos.presentation.content.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.data.model.response.ResponseContentDetailDto
import com.example.myhouse_aos.databinding.ItemContentDetailBinding
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class ItemContentDetailAdapter(
    private val showScrapSnackBar: (String) -> Unit,
    private val scrapContent: (String) -> Unit,
    private val addFolder: (Int, String) -> Unit,
) :
    ListAdapter<ResponseContentDetailDto.Data.Image, ItemContentDetailAdapter.ItemContentDetailViewHolder>(
        ItemDiffCallback<ResponseContentDetailDto.Data.Image>(
            onItemsTheSame = { old, new -> old.imageId == new.imageId },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {

    class ItemContentDetailViewHolder(private val binding: ItemContentDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(
            data: ResponseContentDetailDto.Data.Image,
            showScrapSnackBar: (String) -> Unit,
            scrapContent: (String) -> Unit,
            addFolder: (Int, String) -> Unit,
        ) {
            binding.data = data

            if (data.content == null) {
                binding.tvItemContentdetail.visibility = View.GONE
            }

            binding.btnItemContentdetailScrap.setOnClickListener {
                if (binding.btnItemContentdetailScrap.isSelected) {
                    binding.btnItemContentdetailScrap.isSelected = false
                } else {
                    scrapContent(data.imageUrl)
                    showScrapSnackBar(data.imageUrl)
                    addFolder(1, data.imageUrl)
                    binding.btnItemContentdetailScrap.isSelected = true
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
        holder.onBind(getItem(position), showScrapSnackBar, scrapContent, addFolder)
    }
}