package com.example.myhouse_aos.data.model.response

import com.example.myhouse_aos.domain.model.PopularContentsModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponsePopularContent(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>,
) {
    @Serializable
    data class Data(
        @SerialName("image")
        val image: String,
        @SerialName("post_id")
        val postId: Int,
        @SerialName("title")
        val title: String,
        @SerialName("subtitle")
        val subTitle: String,
        @SerialName("rate")
        val rate: Int,
    )

    fun toPopularModel() = data.map { content ->
        PopularContentsModel(
            rate = content.rate,
            image = content.image,
            postId = content.postId,
            title = content.title,
            subTitle = content.subTitle
        )
    }
}