package com.example.myhouse_aos.presentation.content

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ActivityContentBinding
import com.example.myhouse_aos.presentation.content.adapter.*
import com.example.myhouse_aos.util.binding.BindingActivity
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class ContentActivity : BindingActivity<ActivityContentBinding>(R.layout.activity_content) {
    private val viewModel: ContentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_content
        )



        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contentDetailAdapter = ItemContentDetailAdapter()
        binding.rvContentDetail.adapter = contentDetailAdapter
        contentDetailAdapter.submitList(viewModel.ContentDetailList)

        val flexboxAdapter = ItemContentHashtagAdapter()
        FlexboxLayoutManager(this).apply{
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START
        }.let{
            binding.rvContentHashtag.layoutManager = it
            binding.rvContentHashtag.adapter = flexboxAdapter
        }

        flexboxAdapter.submitList(viewModel.hashTagList)

        val contentUserimageAdapter = ItemContentUserimageAdapter()
        binding.rvContentUserimage.adapter = contentUserimageAdapter
        binding.rvContentUserimage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        contentUserimageAdapter.submitList(viewModel.userimageList)

    }
}