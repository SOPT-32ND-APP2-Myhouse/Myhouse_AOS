package com.example.myhouse_aos.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.myhouse_aos.R
import com.example.myhouse_aos.data.service.AuthState
import com.example.myhouse_aos.databinding.FragmentPagerBinding
import com.example.myhouse_aos.presentation.common.ViewModelFactory
import com.example.myhouse_aos.util.binding.BindingFragment
import kotlinx.coroutines.launch

class PagerFragment : BindingFragment<FragmentPagerBinding>(R.layout.fragment_pager) {

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var bestAdapter: BestAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        getBestProductData()
    }

    private fun initAdapter() {
        bestAdapter = BestAdapter()
    }

    fun getBestProductData(){
        viewModel.getListState.observe(viewLifecycleOwner) { getListState ->
            if(getListState == AuthState.SUCCESS){
                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.bestProductList?.let { productList ->
                        binding.bestProductModel = productList[0]
                        Log.e("getBestProductData_productList", productList[0].toString())
                    }
                }
            }else{
                Log.e("getBestProductData_fail", "fail")
            }
        }
    }
}

