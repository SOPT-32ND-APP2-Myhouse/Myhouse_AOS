package com.example.myhouse_aos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseContentDetailDto(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: Data,
) {
    @Serializable
    data class Data(
        @SerialName("post_id")
        val postId: Int,
        @SerialName("user_name")
        val userName: String,
        @SerialName("created_date")
        val createdDate: String,
        @SerialName("option_tag")
        val optionTag: String,
        @SerialName("images")
        val images: List<Image>,
        @SerialName("hast_tag")
        val hashTag: String,
        @SerialName("like_count")
        val likeCount: Int,
        @SerialName("scrap_count")
        val scrapCount: Int,
        @SerialName("comment_count")
        val commentCount: Int,
        @SerialName("view_count")
        val viewCount: Int,
    ) {
        @Serializable
        data class Image(
            @SerialName("image_id")
            val imageId: Int,
            @SerialName("image_url")
            val imageUrl: String,
            @SerialName("content")
            val content: String?,
        )
    }
}