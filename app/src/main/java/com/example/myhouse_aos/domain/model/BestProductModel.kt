package com.example.myhouse_aos.domain.model

import androidx.annotation.DrawableRes

class BestProductModel (
    val rate: String,
    @DrawableRes val imageUrl: Int,
    val postTitle: String,
    val discount: String,
    val price: String,
    val brand: String,
    val reviewsCount: String
    )