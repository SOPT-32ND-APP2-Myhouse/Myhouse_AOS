package com.example.myhouse_aos.presentation.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.os.Bundle
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ActivityDummyBinding
import com.example.myhouse_aos.databinding.ActivityMainBinding
import com.example.myhouse_aos.presentation.dummy.DummyFragment
import com.example.myhouse_aos.util.binding.BindingActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_main)
        if(currentFragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fcv_main, DummyFragment.newInstance()).commit()
        }

        binding.bnvMain.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_home->{
                    changeFragment(DummyFragment())
                }
                R.id.menu_todayfind->{
                    changeFragment(DummyFragment())
                }
            }
            true
        }
    }
    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_main, fragment)
            .commit()
    }
}