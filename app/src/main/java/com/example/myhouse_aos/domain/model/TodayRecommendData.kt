package com.example.myhouse_aos.domain.model

import androidx.annotation.DrawableRes

data class TodayRecommendData(
    val todayrecommend_id: Int,
    @DrawableRes val image: Int,
    val manufacture: String,
    val product: String,
    val price1: String,
    val price2: String
)
