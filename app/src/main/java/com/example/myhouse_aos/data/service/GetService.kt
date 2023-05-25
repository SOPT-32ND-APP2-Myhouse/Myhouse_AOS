package com.example.myhouse_aos.data.service

import com.example.myhouse_aos.data.model.response.ResponsePopularContent
import com.example.myhouse_aos.data.model.response.ResponseRecommendHome
import retrofit2.http.GET

interface GetService {
    @GET("home/post/popular")
    suspend fun getPopularContents(): ResponsePopularContent

    @GET("home/post/recommend")
    suspend fun getRecommendHome(): ResponseRecommendHome
}