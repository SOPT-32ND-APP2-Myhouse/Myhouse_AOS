package com.example.myhouse_aos.domain.model

import androidx.annotation.DrawableRes

class RecommendHomeModel (
    val tag: String,
    val userName: String,
    val postId: String,
    @DrawableRes val imageUrl: Int,
    val title: String
    )
