package com.example.myhouse_aos.presentation.post

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse_aos.R
import com.example.myhouse_aos.data.repository.PostContentRepositoryImpl
import com.example.myhouse_aos.domain.model.PostContent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostViewModel(private val postContentRepositoryImpl: PostContentRepositoryImpl) :
    ViewModel() {

    private var _postContentLists = MutableStateFlow<List<PostContent>>(listOf())
    val postContentLists get() = _postContentLists.asStateFlow()

    val hotContentList = listOf(
        PostContent(
            postId = 1,
            image = R.drawable.hot_content,
            title = "좁은 다용도실!\n팬트리처럼 예쁘고...",
            postRate = 1,
        ),
        PostContent(
            postId = 2,
            image = R.drawable.hot_content,
            title = "좁은 다용도실!\n팬트리처럼 예쁘고...",
            postRate = 2,
        ),
        PostContent(
            postId = 3,
            image = R.drawable.hot_content,
            title = "좁은 다용도실!\n팬트리처럼 예쁘고...",
            postRate = 3,
        ),
        PostContent(
            postId = 4,
            image = R.drawable.hot_content,
            title = "좁은 다용도실!\n팬트리처럼 예쁘고...",
            postRate = 4,
        )
    )

    init {
        fetchPostContentList()
    }

    private fun fetchPostContentList() {
        viewModelScope.launch {
            postContentRepositoryImpl.fetchPostContent()
                .onSuccess { ContentList ->
                    _postContentLists.value = ContentList
                }
                .onFailure { throwable ->
                    Log.d("서버 통신 실패", throwable.message.toString())
                }
        }
    }
}