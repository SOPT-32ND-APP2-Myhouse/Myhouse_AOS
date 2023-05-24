package com.example.myhouse_aos.presentation.dummy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.FragmentDummyBinding
import com.example.myhouse_aos.util.binding.BindingFragment

class DummyFragment : BindingFragment<FragmentDummyBinding>(R.layout.fragment_dummy) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object{
        fun newInstance() : DummyFragment{
            return DummyFragment()
        }
    }
}