package com.example.myhouse_aos.data.model.response

import com.example.myhouse_aos.domain.model.DummyData
import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val status: Int,
    val message: String,
    val data: ResponseData,
) {
    @Serializable
    data class ResponseData(
        val id: Int,
        val name: String,
        val email: String,
    ) {
        fun toDummyData() = DummyData(
            id = id.toString(),
            email = email,
            name = name
        )
    }
}