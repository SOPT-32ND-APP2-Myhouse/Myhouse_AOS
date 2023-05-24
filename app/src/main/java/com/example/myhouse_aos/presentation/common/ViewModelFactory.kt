package com.example.myhouse_aos.presentation.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse_aos.data.datasource.DummyDatasource
import com.example.myhouse_aos.data.repository.DummyRepositoryImpl
import com.example.myhouse_aos.presentation.dummy.DummyViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // TODO 삭제
        if (modelClass.isAssignableFrom(DummyViewModel::class.java)) {
            return DummyViewModel(DummyRepositoryImpl(DummyDatasource())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}