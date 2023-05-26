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

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(PostContentRepositoryImpl(PostContentDatasource())) as T
        else if (modelClass.isAssignableFrom(ScrapViewModel::class.java)) {
            return ScrapViewModel(ScrapRepositoryImpl(ScrapDatasource())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}