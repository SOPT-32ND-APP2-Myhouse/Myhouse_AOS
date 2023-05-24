package com.example.myhouse_aos.presentation.post

import androidx.lifecycle.ViewModel
import com.example.myhouse_aos.R
import com.example.myhouse_aos.domain.model.PostContent

class PostViewModel : ViewModel() {
    val hotContentList = listOf(
        PostContent(
            postId = 1,
            image = R.drawable.hot_content,
            title = "좁은 다용도실!\n팬트리처럼 예쁘고...",
        ),
        PostContent(
            postId = 2,
            image = R.drawable.hot_content,
            title = "좁은 다용도실!\n팬트리처럼 예쁘고...",
        ),
        PostContent(
            postId = 3,
            image = R.drawable.hot_content,
            title = "좁은 다용도실!\n팬트리처럼 예쁘고...",
        ),
        PostContent(
            postId = 4,
            image = R.drawable.hot_content,
            title = "좁은 다용도실!\n팬트리처럼 예쁘고...",
        )
    )

    val contentList1 = listOf(
        PostContent(
            postId = 1,
            image = R.drawable.post_content,
            title = "좁은 세탁실, 딱 세 가지로 깔끔한\n수납공간으로 대변신",
        ),
        PostContent(
            postId = 2,
            image = R.drawable.post_content,
            title = "좁은 세탁실, 딱 세 가지로 깔끔한\n수납공간으로 대변신",
        ),
        PostContent(
            postId = 3,
            image = R.drawable.post_content,
            title = "좁은 세탁실, 딱 세 가지로 깔끔한\n수납공간으로 대변신",
        ),
        PostContent(
            postId = 4,
            image = R.drawable.post_content,
            title = "좁은 세탁실, 딱 세 가지로 깔끔한\n수납공간으로 대변신",
        )
    )
}