package com.example.myhouse_aos.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.myhouse_aos.R
import com.example.myhouse_aos.data.service.AuthState
import com.example.myhouse_aos.databinding.FragmentHomeBinding
import com.example.myhouse_aos.domain.model.RecommendHomeModel
import com.example.myhouse_aos.presentation.common.ViewModelFactory
import com.example.myhouse_aos.util.binding.BindingFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private val recommendHomeList: MutableList<RecommendHomeModel> = mutableListOf()
    private lateinit var popularContentsAdapter: PopularContentsAdapter
    private lateinit var recommendHomeAdapter: RecommendHomeAdapter
    private lateinit var recommendProductAdapter: RecommendProductAdapter
    private lateinit var modernContentsAdapter: ModernContentsAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var summerContentsAdapter: SummerContentsAdapter
    private lateinit var colorInteriorAdapter: ColorInteriorAdapter
    private lateinit var colorProductAdapter: ColorProductAdapter
    private lateinit var reviewAdapter: ReviewAdapter
    private lateinit var menuAdapter: MenuAdapter
    private lateinit var popularPhotoAdapter: PopularPhotoAdapter
    private lateinit var planAdapter: TodayPlanAdapter
    private lateinit var bestAdapter: BestAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBestTab()
        initAdapter()
        getPopularContentsData()
        //getBestProductData()
        getRecommendHomeData()
        getRecommendProduct()
        getModernInterior()
        getCategory()
        getSummerContents()
        getColorInterior()
        getColorProduct()
        getReview()
        getMenu()
        getPopularPhoto()
        getTodayPlan()

    }

    private fun getPopularContentsData(){
        viewModel.getListState.observe(viewLifecycleOwner) { getListState ->
            if(getListState == AuthState.SUCCESS){
                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.popularContentsList?.let { contentsList ->
                        popularContentsAdapter.submitList(contentsList)
                        Log.e("success", contentsList.toString())
                    }
                }
            }else{
                Log.e("fail", "fail")
            }
        }
    }

    private fun getRecommendHomeData() {
        viewModel.getListState.observe(viewLifecycleOwner) { getListState ->
            if (getListState == AuthState.SUCCESS) {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.recommendHome?.let { recommendHome ->
                        repeat(4) {
                            recommendHomeList.addAll(listOf(recommendHome))
                        }
                        recommendHomeAdapter.submitList(recommendHomeList)
                        Log.e("getRecommendHomeData_success", recommendHomeList.toString())
                    }
                }
            } else {
                Log.e("getRecommendHomeData_fail", "fail")
            }
        }
    }

    private fun initAdapter() {
        popularContentsAdapter = PopularContentsAdapter()
        recommendHomeAdapter = RecommendHomeAdapter()
        recommendProductAdapter = RecommendProductAdapter()
        modernContentsAdapter = ModernContentsAdapter()
        categoryAdapter = CategoryAdapter()
        summerContentsAdapter = SummerContentsAdapter()
        colorInteriorAdapter = ColorInteriorAdapter()
        colorProductAdapter = ColorProductAdapter()
        reviewAdapter = ReviewAdapter()
        menuAdapter = MenuAdapter()
        popularPhotoAdapter = PopularPhotoAdapter()
        planAdapter = TodayPlanAdapter()
        bestAdapter = BestAdapter()

        binding.rvHomePopularContents.adapter = popularContentsAdapter
        binding.rvHomeRecommendHouse.adapter = recommendHomeAdapter
        binding.rvHomeRecommendProduct.adapter = recommendProductAdapter
        binding.rvHomeModernInterior.adapter = modernContentsAdapter
        binding.rvHomeFindCategoryProduct.adapter = categoryAdapter
        binding.rvHomeSummerContent.adapter = summerContentsAdapter
        binding.rvHomeColorInterior.adapter = colorInteriorAdapter
        binding.rvHomeColorProduct.adapter = colorProductAdapter
        binding.rvHomeReview.adapter = reviewAdapter
        binding.rvHomeMenu.adapter = menuAdapter
        binding.rvHomePopularPhoto.adapter = popularPhotoAdapter
        binding.rvHomePlan.adapter = planAdapter
    }


    private fun initBestTab() {
        val tabLayout = binding.homeTabLayout
        val pagerAdapter = PagerFragmentAdapter(requireActivity())
            .apply {
                addFragment(PagerFragment())
                addFragment(PagerFragment())
                addFragment(PagerFragment())
                addFragment(PagerFragment())
                addFragment(PagerFragment())
                addFragment(PagerFragment())
            }
        val viewPager = binding.homeViewPager.apply {
            adapter = pagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val tabTitles = resources.getStringArray(R.array.home_tab_item)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun getRecommendProduct() {
        recommendProductAdapter.submitList(viewModel.recommendProductList)
    }

    private fun getModernInterior() {
        modernContentsAdapter.submitList(viewModel.modernInteriorList)
    }

    private fun getCategory() {
        categoryAdapter.submitList(viewModel.categoryList)
    }

    private fun getSummerContents() {
        summerContentsAdapter.submitList(viewModel.summerContentsList)
    }

    private fun getColorInterior() {
        colorInteriorAdapter.submitList(viewModel.colorInteriorList)
    }

    private fun getColorProduct() {
        colorProductAdapter.submitList(viewModel.colorProductList)
    }

    private fun getReview() {
        reviewAdapter.submitList(viewModel.reviewList)
    }

    private fun getMenu() {
        menuAdapter.submitList(viewModel.menuList)
    }

    private fun getPopularPhoto() {
        popularPhotoAdapter.submitList(viewModel.popularPhotoList)
    }

    private fun getTodayPlan() {
        planAdapter.submitList(viewModel.planList)
    }
}

