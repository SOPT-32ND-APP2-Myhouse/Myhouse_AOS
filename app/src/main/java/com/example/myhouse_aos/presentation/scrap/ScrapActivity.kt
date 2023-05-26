package com.example.myhouse_aos.presentation.scrap

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ActivityScrapBinding
import com.example.myhouse_aos.presentation.common.ViewModelFactory
import com.example.myhouse_aos.util.binding.BindingActivity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ScrapActivity : BindingActivity<ActivityScrapBinding>(R.layout.activity_scrap) {

    private val viewModel: ScrapViewModel by viewModels { ViewModelFactory(this) }
    private lateinit var folderAdapter: FolderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        collectData()
        initLayout()
        addListeners()
    }

    private fun initLayout() {
        folderAdapter = FolderAdapter()
        binding.rvScrapFolders.adapter = folderAdapter
    }

    private fun addListeners() {
        binding.ivScrapBack.setOnClickListener {
            moveToBack()
        }
    }

    private fun collectData() {
        viewModel.scrapFolderLists.flowWithLifecycle(lifecycle).onEach { scrapFolderLists ->
            if (scrapFolderLists.isNotEmpty()) {
                folderAdapter.submitList(scrapFolderLists.toMutableList())
            }
        }.launchIn(lifecycleScope)
    }

    private fun moveToBack() {
        finish()
    }
}