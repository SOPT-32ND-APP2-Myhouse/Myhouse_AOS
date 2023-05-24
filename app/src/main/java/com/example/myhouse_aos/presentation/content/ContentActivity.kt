package com.example.myhouse_aos.presentation.content

import android.os.Bundle
import androidx.activity.viewModels
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ActivityContentBinding
import com.example.myhouse_aos.presentation.content.adapter.*
import com.example.myhouse_aos.util.binding.BindingActivity
import com.example.myhouse_aos.util.snackbar.ScrapSnackBar
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class ContentActivity : BindingActivity<ActivityContentBinding>(R.layout.activity_content) {
    private val viewModel: ContentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.data = viewModel.contentDetail

        val contentDetailAdapter = ItemContentDetailAdapter(::showScrapSnackBar)
        binding.rvContentDetail.adapter = contentDetailAdapter
        contentDetailAdapter.submitList(viewModel.ContentDetailList)

        val flexboxAdapter = ItemContentHashtagAdapter()
        FlexboxLayoutManager(this).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START
        }.let {
            binding.rvContentHashtag.layoutManager = it
            binding.rvContentHashtag.adapter = flexboxAdapter
        }

        flexboxAdapter.submitList(viewModel.hashTagList)

        val contentUserimageAdapter = ItemContentUserimageAdapter()
        binding.rvContentUserimage.adapter = contentUserimageAdapter
        contentUserimageAdapter.submitList(viewModel.userimageList)

        val contentTodayRecommendAdapter = ItemContentTodayRecommendAdapter(::showScrapSnackBar)
        binding.rvContentTodayrecommend.adapter = contentTodayRecommendAdapter
        contentTodayRecommendAdapter.submitList(viewModel.todayRecommendList)

        val contentUserBestAdapter = ItemContentUserBestAdapter(::showScrapSnackBar)
        binding.rvContentUserbest.adapter = contentUserBestAdapter
        contentUserBestAdapter.submitList(viewModel.userBestList)

        binding.btnContentBack.setOnClickListener {
            moveToBack()
        }
    }

    private fun showScrapSnackBar() {
        ScrapSnackBar(binding.root).show()
    }

    private fun moveToBack() {
        finish()
    }
}