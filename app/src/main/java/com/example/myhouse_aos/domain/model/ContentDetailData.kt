package com.example.myhouse_aos.domain.model

import androidx.annotation.DrawableRes

data class ContentDetailData(
    val post_id: Int,
    val user_name: String,
    val created_date: String,
    val option_tag: String,
    val hash_tag: String,
    val like_count: String,
    val scrap_count: String,
    val comment_count: String,
    val view_count: String,
){
    data class Images(
        val image_id: Int,
        @DrawableRes val image: Int,
        val content: String?,
    )
    val images: List<Images>? = null
}
