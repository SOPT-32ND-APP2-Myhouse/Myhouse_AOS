package com.example.myhouse_aos.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestAddFolderDto(
    @SerialName("image_url")
    val imageUrl: String?,
)
