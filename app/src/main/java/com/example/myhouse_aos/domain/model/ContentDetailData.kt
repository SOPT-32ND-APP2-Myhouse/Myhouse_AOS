package com.example.myhouse_aos.domain.model

import androidx.annotation.DrawableRes

data class ContentDetailData(
    val post_id: Int,
    val user_name: String,
    val created_date: String,
    val potion_tag: String,
    val hash_tag: String,
    val like_count: Int,
    val scrap_count: Int,
    val comment_count: Int,
    val view_count: Int,
){
    data class Images(
        val image_id: Int,
        @DrawableRes val image: Int,
        val content: String?,
    )
    val images: List<Images>? = null
}
