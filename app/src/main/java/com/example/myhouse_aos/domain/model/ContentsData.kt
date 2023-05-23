package com.example.myhouse_aos.domain.model

import androidx.annotation.DrawableRes

class ContentsData (
    val contentId: Int,
    @DrawableRes val image: Int,
    var description : String,
    var subDescription : String
)