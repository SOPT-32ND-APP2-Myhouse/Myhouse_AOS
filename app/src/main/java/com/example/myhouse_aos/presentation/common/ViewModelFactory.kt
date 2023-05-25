package com.example.myhouse_aos.presentation.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse_aos.data.datasource.DummyDatasource
import com.example.myhouse_aos.data.datasource.GetPopularContentsDataSource
import com.example.myhouse_aos.data.repository.DummyRepositoryImpl
import com.example.myhouse_aos.data.repository.GetPopularContentsRespositoryImpl
import com.example.myhouse_aos.presentation.dummy.DummyViewModel
import com.example.myhouse_aos.presentation.home.HomeViewModel
import com.example.myhouse_aos.presentation.post.PostViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(GetPopularContentsRespositoryImpl(GetPopularContentsDataSource())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}