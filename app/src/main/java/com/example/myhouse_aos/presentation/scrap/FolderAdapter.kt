package com.example.myhouse_aos.presentation.scrap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemFolderBinding
import com.example.myhouse_aos.domain.model.Folder
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class FolderAdapter :
    ListAdapter<Folder, FolderAdapter.FolderViewHolder>(
        ItemDiffCallback<Folder>(
            onItemsTheSame = { old, new -> old.folderId == new.folderId },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {

    class FolderViewHolder(
        private val binding: ItemFolderBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(folder: Folder) {
            binding.folder = folder
            val adapter = ScrapAdapter()
            binding.layoutScraps.adapter = adapter
            adapter.submitList(folder.scraps.toMutableList())
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder {
        val binding =
            ItemFolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FolderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}