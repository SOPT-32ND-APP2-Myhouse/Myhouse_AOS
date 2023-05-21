package com.example.myhouse_aos.presentation.dummy

import android.os.Bundle
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ActivityDummyBinding
import com.example.myhouse_aos.util.ScrapCompleteSnackBar
import com.example.myhouse_aos.util.binding.BindingActivity

class DummyActivity : BindingActivity<ActivityDummyBinding>(R.layout.activity_dummy) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScrapCompleteSnackBar(binding.root).show()
    }
}