package com.example.myhouse_aos.data.model.response

import androidx.annotation.DrawableRes
import com.example.myhouse_aos.domain.model.PopularContentsModel
import com.example.myhouse_aos.domain.model.PostContent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
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
        val subtitle: String,
        @SerialName("rate")
        val rate: Int,
    )

    fun toPopularModel() = data.map { content ->
        PopularContentsModel(
            rate = content.rate,
            image = content.image,
            postId = content.postId,
            title = content.title,
            subTitle = content.subtitle
        )
    }
}