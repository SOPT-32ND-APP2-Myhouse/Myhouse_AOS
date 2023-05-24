package com.example.myhouse_aos.domain.model

import androidx.annotation.DrawableRes

data class ContentDetailData(
    val postId: Int,
    val userName: String,
    val createdDate: String,
    val optionTag: String,
    val hashTag: String,
    val likeCount: String,
    val scrapCount: String,
    val commentCount: String,
    val viewCount: String,
){
    data class Images(
        val imageId: Int,
        @DrawableRes val image: Int,
        val content: String?,
    )
    val images: List<Images>? = null
}
