package com.example.myhouse_aos.presentation.scrap

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse_aos.data.repository.ScrapRepositoryImpl
import com.example.myhouse_aos.domain.model.Folder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScrapViewModel(val scrapRepositoryImpl: ScrapRepositoryImpl) : ViewModel() {

    private var _scrapFolderLists = MutableStateFlow<List<Folder>>(listOf())
    val scrapFolderLists get() = _scrapFolderLists.asStateFlow()

    init {
        fetchFollowerList()
    }

    private fun fetchFollowerList() {
        viewModelScope.launch {
            scrapRepositoryImpl.fetchScraps()
                .onSuccess { followerList ->
                    _scrapFolderLists.value = followerList
                }
                .onFailure { throwable ->
                    Log.d("서버 통신 실패", throwable.message.toString())
                }
        }
    }
}