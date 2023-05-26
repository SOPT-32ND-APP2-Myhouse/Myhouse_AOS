package com.example.myhouse_aos.data.service

import com.example.myhouse_aos.data.model.response.ResponseScrap
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ScrapService {
    @GET("scrap/all")
    suspend fun fetchScraps(): ResponseScrap

    @POST("scrap")
    fun scrap(
        @Body request: RequestScrapDto,
    ): Call<ResponseScrapDto>
}
