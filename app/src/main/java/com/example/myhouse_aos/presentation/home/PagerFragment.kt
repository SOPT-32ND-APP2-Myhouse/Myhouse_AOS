package com.example.myhouse_aos.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.FragmentPagerBinding
import com.example.myhouse_aos.presentation.common.ViewModelFactory
import com.example.myhouse_aos.util.binding.BindingFragment

class PagerFragment : BindingFragment<FragmentPagerBinding>(R.layout.fragment_pager) {

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var bestAdapter: BestAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        getBest()
    }
    private fun initAdapter() {
        bestAdapter = BestAdapter()
        binding.rvHomePager.adapter = bestAdapter

    }
    private fun getBest() {
        bestAdapter.submitList(viewModel.bestList)
    }
}

