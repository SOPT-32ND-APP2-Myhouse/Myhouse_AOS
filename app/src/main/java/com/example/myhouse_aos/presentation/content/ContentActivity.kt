package com.example.myhouse_aos.presentation.content

import android.os.Bundle
import androidx.activity.viewModels
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ActivityContentBinding
import com.example.myhouse_aos.presentation.content.adapter.*
import com.example.myhouse_aos.presentation.home.BottomSheetDialog
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

        viewModel.completeGetUsers()


        val contentDetailAdapter =
            ItemContentDetailAdapter(::showScrapSnackBar, ::scrapContent, ::addFolder)
        binding.rvContentDetail.adapter = contentDetailAdapter


        val flexboxAdapter = ItemContentHashtagAdapter()
        FlexboxLayoutManager(this).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START
        }.let {
            binding.rvContentHashtag.layoutManager = it
            binding.rvContentHashtag.adapter = flexboxAdapter
        }


        val contentUserimageAdapter = ItemContentUserimageAdapter()
        binding.rvContentUserimage.adapter = contentUserimageAdapter
        contentUserimageAdapter.submitList(viewModel.userimageList)

        val contentTodayRecommendAdapter = ItemContentTodayRecommendAdapter()
        binding.rvContentTodayrecommend.adapter = contentTodayRecommendAdapter
        contentTodayRecommendAdapter.submitList(viewModel.todayRecommendList)

        val contentUserBestAdapter = ItemContentUserBestAdapter()
        binding.rvContentUserbest.adapter = contentUserBestAdapter
        contentUserBestAdapter.submitList(viewModel.userBestList)

        viewModel.contentDetailResult.observe(this) { contentDetailResult ->
            binding.data = contentDetailResult
            val hashtaglist = viewModel.createHashTagArray(contentDetailResult.data.hashTag)
            flexboxAdapter.submitList(hashtaglist)
            contentDetailAdapter.submitList(contentDetailResult.data.images)
        }

        binding.btnContentBack.setOnClickListener {
            moveToBack()
        }


    }

    private fun addFolder(id: Int, imageUrl: String) {
        viewModel.addFolder(id, imageUrl)
    }

    private fun scrapContent(imageUrl: String) {
        viewModel.scrap(imageUrl)
    }

    private fun showScrapSnackBar(imageUrl: String) {
        ScrapSnackBar(binding.root, imageUrl) {
            showFolderBottomSheet(imageUrl)
        }.show()
    }

    private fun showFolderBottomSheet(imageUrl: String) {
        val bottomSheetDialog = BottomSheetDialog.newInstance(imageUrl, viewModel)
        bottomSheetDialog.show(this.supportFragmentManager, bottomSheetDialog.tag)
    }

    private fun moveToBack() {
        finish()
    }


}