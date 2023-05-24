package com.example.myhouse_aos.domain.model

import androidx.annotation.DrawableRes

class PopularContentsModel(
    val rate: String,
    @DrawableRes val imageUrl: Int,
    val postId: String,
    var title: String,
    var subTitle: String
)