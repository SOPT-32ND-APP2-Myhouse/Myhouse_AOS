package com.example.myhouse_aos.data.model.response

import com.example.myhouse_aos.domain.model.RecommendHomeModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRecommendHome(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data,
) {
    @Serializable
    data class Data(
        val post: Post
    ) {
        @Serializable
        data class Post(
            @SerialName("image_url")
            val image_url: String,
            @SerialName("post_id")
            val post_id: Int,
            @SerialName("title")
            val title: String,
            @SerialName("user_name")
            val user_name: String,
            @SerialName("tag")
            val tag: String,
        )
    }

    fun toRecommendHomeModel(post: Data.Post): RecommendHomeModel {
        return RecommendHomeModel(
            tag = post.tag,
            userName = post.user_name,
            postId = post.post_id,
            imageUrl = post.image_url,
            title = post.title
        )
    }

}