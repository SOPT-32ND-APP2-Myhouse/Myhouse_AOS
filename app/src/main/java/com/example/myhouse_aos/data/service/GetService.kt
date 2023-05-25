package com.example.myhouse_aos.data.service

import com.example.myhouse_aos.data.model.response.ResponsePopularContent
import retrofit2.http.GET

interface GetService {
    @GET("home/post/popular")
    suspend fun getPopularContents(): ResponsePopularContent
}