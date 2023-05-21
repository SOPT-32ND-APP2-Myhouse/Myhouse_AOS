package com.example.myhouse_aos.presentation.content.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemContentDetailBinding
import com.example.myhouse_aos.domain.model.ContentDetailData
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class ItemContentDetailAdapter : ListAdapter<ContentDetailData.Images, ItemContentDetailAdapter.ItemContentDetailViewHolder>(
    ItemDiffCallback<ContentDetailData.Images>(
        onItemsTheSame = {old, new -> old.image_id == new.image_id},
        onContentsTheSame = {old, new -> old == new}
    )
)
{
    class ItemContentDetailViewHolder(private val binding: ItemContentDetailBinding) :
            RecyclerView.ViewHolder(binding.root){
                fun onBind(data: ContentDetailData.Images){
                    binding.data = data
                    if(data.content == null)
                    {
                        binding.tvItemContentdetail.visibility = View.GONE
                    }
                    binding.btnItemContentdetailScrap.setOnClickListener {
                        ItemClickListener.onButtonClick(binding.btnItemContentdetailScrap)
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemContentDetailViewHolder {
        val binding = ItemContentDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemContentDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemContentDetailViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    interface ItemClickListener {
        fun onButtonClick(imageId: Int)

        companion object {
            fun onButtonClick(btnItemContentdetailScrap: ImageButton) {
            }
        }
    }
}