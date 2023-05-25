package com.example.myhouse_aos.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.FragmentPagerBinding
import com.example.myhouse_aos.util.binding.BindingFragment

class PagerFragment : BindingFragment<FragmentPagerBinding>(R.layout.fragment_pager) {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var bestAdapter: BestAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        bestAdapter = BestAdapter()
    }
}

