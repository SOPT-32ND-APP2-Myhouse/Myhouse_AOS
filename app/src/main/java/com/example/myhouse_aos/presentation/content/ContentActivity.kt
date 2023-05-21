package com.example.myhouse_aos.presentation.content

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ActivityContentBinding
import com.example.myhouse_aos.domain.model.ContentDetailData
import com.example.myhouse_aos.presentation.content.adapter.ItemContentDetailAdapter
import com.example.myhouse_aos.presentation.content.adapter.ItemContentHashtagAdapter
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

    }
}