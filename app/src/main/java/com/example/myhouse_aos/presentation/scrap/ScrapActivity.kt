package com.example.myhouse_aos.presentation.scrap

import android.os.Bundle
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ActivityScrapBinding
import com.example.myhouse_aos.util.binding.BindingActivity

class ScrapActivity : BindingActivity<ActivityScrapBinding>(R.layout.activity_scrap) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners() {
        binding.ivScrapBack.setOnClickListener {
            moveToBack()
        }
    }

    private fun moveToBack() {
        finish()
    }
}