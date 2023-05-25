package com.example.myhouse_aos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAddFolderDto(
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
        @SerialName("folder_id")
        val folder_id: Int,
        @SerialName("scrap_id")
        val scrap_id: Int,
        @SerialName("image_url")
        val image_url: String,
    )
}
