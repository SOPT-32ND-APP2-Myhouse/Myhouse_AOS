package com.example.myhouse_aos.presentation.post

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.FragmentPostBinding
import com.example.myhouse_aos.presentation.common.ViewModelFactory
import com.example.myhouse_aos.presentation.content.ContentActivity
import com.example.myhouse_aos.util.binding.BindingFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PostFragment : BindingFragment<FragmentPostBinding>(R.layout.fragment_post) {

    private val viewModel: PostViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var contentAdapterTop: ContentAdapter
    private lateinit var contentAdapterBottom: ContentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collectData()
        initLayout()
    }

    private fun initLayout() {
        contentAdapterTop = ContentAdapter(::moveToContent)
        contentAdapterBottom = ContentAdapter(::moveToContent)
        binding.rvPostContents.adapter = contentAdapterTop
        binding.rvPostContents2.adapter = contentAdapterBottom

        val hotAdapter = HotContentAdapter()
        binding.rvHotContents.adapter = hotAdapter
        hotAdapter.submitList(viewModel.hotContentList)
    }

    private fun collectData() {
        viewModel.postContentLists.flowWithLifecycle(lifecycle).onEach { postContentLists ->
            contentAdapterTop.submitList(postContentLists.toMutableList())
            contentAdapterBottom.submitList(postContentLists.toMutableList())
        }.launchIn(lifecycleScope)
    }

    private fun moveToContent() {
        startActivity(Intent(requireContext(), ContentActivity::class.java))
    }
}