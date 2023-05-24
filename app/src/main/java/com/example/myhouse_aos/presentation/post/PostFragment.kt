package com.example.myhouse_aos.presentation.post

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.FragmentPostBinding
import com.example.myhouse_aos.presentation.content.ContentActivity
import com.example.myhouse_aos.util.binding.BindingFragment

class PostFragment : BindingFragment<FragmentPostBinding>(R.layout.fragment_post) {
    private val viewModel: PostViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
    }

    private fun initLayout() {
        val contentAdapterTop = ContentAdapter(::moveToContent)
        val hotAdapter = HotContentAdapter()
        val contentAdapterBottom = ContentAdapter(::moveToContent)

        binding.rvPostContents.adapter = contentAdapterTop
        contentAdapterTop.submitList(viewModel.contentList1)
        binding.rvHotContents.adapter = hotAdapter
        hotAdapter.submitList(viewModel.hotContentList)
        binding.rvPostContents2.adapter = contentAdapterBottom
        contentAdapterBottom.submitList(viewModel.contentList1)
    }

    private fun moveToContent() {
        startActivity(Intent(requireContext(), ContentActivity::class.java))
    }
}