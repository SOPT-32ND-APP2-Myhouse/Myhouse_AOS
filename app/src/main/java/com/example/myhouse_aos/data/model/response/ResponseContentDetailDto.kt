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
        val post_id: Int,
        @SerialName("user_name")
        val user_name: String,
        @SerialName("created_date")
        val created_date: String,
        @SerialName("option_tag")
        val option_tag: String,
        @SerialName("images")
        val images: List<Image>,
        @SerialName("hast_tag")
        val hast_tag: String,
        @SerialName("like_count")
        val like_count: Int,
        @SerialName("scrap_count")
        val scrap_count: Int,
        @SerialName("comment_count")
        val comment_count: Int,
        @SerialName("view_count")
        val view_count: Int,
    ) {
        @Serializable
        data class Image(
            @SerialName("image_id")
            val image_id: Int,
            @SerialName("image_url")
            val image_url: String,
            @SerialName("content")
            val content: String?,
        )
    }
}