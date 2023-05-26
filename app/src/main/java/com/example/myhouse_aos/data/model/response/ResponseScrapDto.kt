package com.example.myhouse_aos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseScrapDto(
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
        @SerialName("id")
        val id: Int,
        @SerialName("folder")
        val folder: FolderData,
        @SerialName("image_url")
        val imageUrl: String,
    ) {
        @Serializable
        data class FolderData(
            @SerialName("id")
            val id: Int,
            @SerialName("title")
            val title: String,
        )
    }
}
