package com.example.myhouse_aos.data.model.response


import com.example.myhouse_aos.domain.model.BestProductModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBestProduct(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>,
) {
    @Serializable
    data class Data(
        @SerialName("image_url")
        val imageUrl: String?,
        @SerialName("post_title")
        val postTitle: String,
        @SerialName("category")
        val category: String,
        @SerialName("discount")
        val discount: Double,
        @SerialName("price")
        val price: Long,
        @SerialName("reviews_count")
        val reviewsCount: Long,
        @SerialName("rate")
        val rate: Double,
        @SerialName("rank")
        val rank: Int,
    )

    fun toBestProductModel() = data.map { content ->
        BestProductModel(
            rank = content.rank,
            brand = content.postTitle,
            imageUrl = content.imageUrl,
            discount = content.discount,
            price = content.price,
            postTitle = content.postTitle
        )
    }
}