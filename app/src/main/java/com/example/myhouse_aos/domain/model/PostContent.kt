package com.example.myhouse_aos.domain.model

import androidx.annotation.DrawableRes

data class PostContent(
    val postId: Int,
    @DrawableRes val image: Int,
    val title: String,
)
