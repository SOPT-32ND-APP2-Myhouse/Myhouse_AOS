package com.example.myhouse_aos.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ActivityMainBinding
import com.example.myhouse_aos.presentation.home.HomeFragment
import com.example.myhouse_aos.presentation.post.PostFragment
import com.example.myhouse_aos.util.binding.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        changeFragment(HomeFragment())

        binding.bnvMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    changeFragment(HomeFragment())
                }
                R.id.menu_todayfind -> {
                    changeFragment(PostFragment())
                }
            }
            true
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_main, fragment)
            .commit()
    }
}