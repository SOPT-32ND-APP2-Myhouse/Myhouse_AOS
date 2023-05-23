package com.example.myhouse_aos.presentation.post

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.FragmentPostBinding
import com.example.myhouse_aos.util.binding.BindingFragment

class FragmentPost : BindingFragment<FragmentPostBinding>(R.layout.fragment_post) {
    private val viewModel: PostViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
    }

    fun initLayout() {
        val contentAdapterTop = ContentAdapter()
        val hotAdapter = HotContentAdapter()
        val contentAdapterBottom = ContentAdapter()

        binding.rvPostContents.adapter = contentAdapterTop
        contentAdapterTop.submitList(viewModel.contentList1)
        binding.rvHotContents.adapter = hotAdapter
        hotAdapter.submitList(viewModel.hotContentList)
        binding.rvPostContents2.adapter = contentAdapterBottom
        contentAdapterBottom.submitList(viewModel.contentList1)
    }

}