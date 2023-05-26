package com.example.myhouse_aos.presentation.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse_aos.data.datasource.ScrapDatasource
import com.example.myhouse_aos.data.repository.ScrapRepositoryImpl
import com.example.myhouse_aos.presentation.scrap.ScrapViewModel
import com.example.myhouse_aos.data.datasource.PostContentDatasource
import com.example.myhouse_aos.data.repository.PostContentRepositoryImpl
import com.example.myhouse_aos.presentation.post.PostViewModel
import com.example.myhouse_aos.data.datasource.DummyDatasource
import com.example.myhouse_aos.data.datasource.GetBestProductDataSource
import com.example.myhouse_aos.data.datasource.GetPopularContentsDataSource
import com.example.myhouse_aos.data.datasource.GetRecommendHomeDataSource
import com.example.myhouse_aos.data.repository.DummyRepositoryImpl
import com.example.myhouse_aos.data.repository.GetBestProductRepositoryImpl
import com.example.myhouse_aos.data.repository.GetPopularContentsRespositoryImpl
import com.example.myhouse_aos.data.repository.GetRecommendHomeRepositoryImpl
import com.example.myhouse_aos.presentation.dummy.DummyViewModel
import com.example.myhouse_aos.presentation.home.HomeViewModel
import com.example.myhouse_aos.presentation.post.PostViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(PostContentRepositoryImpl(PostContentDatasource())) as T
            else if (modelClass.isAssignableFrom(ScrapViewModel::class.java)) {
                return ScrapViewModel(ScrapRepositoryImpl(ScrapDatasource())) as T
            } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(
                    GetPopularContentsRespositoryImpl(GetPopularContentsDataSource()),
                    GetRecommendHomeRepositoryImpl(GetRecommendHomeDataSource()),
                    GetBestProductRepositoryImpl(GetBestProductDataSource())
                ) as T
                throw IllegalArgumentException("Unknown ViewModel Class")
            }
        }