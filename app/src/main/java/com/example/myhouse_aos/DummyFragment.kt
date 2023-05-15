package com.example.myhouse_aos

import android.os.Bundle
import android.view.View
import com.example.myhouse_aos.databinding.FragmentDummyBinding
import com.example.myhouse_aos.util.binding.BindingFragment

class DummyFragment : BindingFragment<FragmentDummyBinding>(R.layout.fragment_dummy) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}