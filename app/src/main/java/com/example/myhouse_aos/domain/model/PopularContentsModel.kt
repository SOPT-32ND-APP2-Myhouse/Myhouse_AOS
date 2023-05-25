package com.example.myhouse_aos.domain.model

import androidx.annotation.DrawableRes

class PopularContentsModel(
    val rate: Int?,
    val image: String,
    val postId: Int,
    var title: String,
    var subTitle: String
)