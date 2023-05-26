package com.example.myhouse_aos.presentation.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse_aos.data.datasource.*
import com.example.myhouse_aos.data.repository.*
import com.example.myhouse_aos.presentation.home.HomeViewModel
import com.example.myhouse_aos.presentation.post.PostViewModel
import com.example.myhouse_aos.presentation.scrap.ScrapViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(PostContentRepositoryImpl(PostContentDatasource())) as T
        } else if (modelClass.isAssignableFrom(ScrapViewModel::class.java)) {
            return ScrapViewModel(ScrapRepositoryImpl(ScrapDatasource())) as T
        } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(
                GetPopularContentsRespositoryImpl(GetPopularContentsDataSource()),
                GetRecommendHomeRepositoryImpl(GetRecommendHomeDataSource()),
                GetBestProductRepositoryImpl(GetBestProductDataSource())
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}