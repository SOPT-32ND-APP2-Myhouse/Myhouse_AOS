package com.example.myhouse_aos.data.service

import com.example.myhouse_aos.data.model.response.ResponseScrap
import retrofit2.http.GET

interface ScrapService {
    @GET("scrap/all")
    suspend fun fetchScraps(): ResponseScrap
}