package com.example.myhouse_aos.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.app.NotificationCompat.getCategory
import androidx.fragment.app.viewModels
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.FragmentHomeBinding
import com.example.myhouse_aos.util.binding.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()
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
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            initAdapter()
            getPopularContents()
            getRecommendHome()
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

        private fun getPopularContents() {
            popularContentsAdapter.submitList(viewModel.popularContentsList)
        }

        private fun getRecommendHome() {
            recommendHomeAdapter.submitList(viewModel.recommendHomeList)
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

