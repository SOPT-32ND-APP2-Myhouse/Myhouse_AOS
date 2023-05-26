package com.example.myhouse_aos.data.model.response

import com.example.myhouse_aos.domain.model.PostContent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponsePostContent(
    val data: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean,
) {
    @Serializable
    data class Data(
        @SerialName("image_url")
        val imageUrl: String,
        @SerialName("post_id")
        val postId: Int,
        val title: String,
    )

    fun toPostContent() = data.map { content ->
        PostContent(
            postId = content.postId,
            image = content.imageUrl,
            title = content.title,
            postRate = null
        )
    }
}