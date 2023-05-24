package com.example.myhouse_aos.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.app.NotificationCompat.getCategory
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.FragmentHomeBinding
import com.example.myhouse_aos.databinding.FragmentPagerBinding
import com.example.myhouse_aos.util.binding.BindingFragment
import com.google.android.material.tabs.TabLayoutMediator

class PagerFragment : BindingFragment<FragmentPagerBinding>(R.layout.fragment_pager) {

    private val viewModel by viewModels<HomeViewModel>()

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

