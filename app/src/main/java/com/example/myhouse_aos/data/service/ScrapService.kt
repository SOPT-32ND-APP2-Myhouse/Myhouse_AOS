package com.example.myhouse_aos.data.service

import com.example.myhouse_aos.data.model.request.RequestScrapDto
import com.example.myhouse_aos.data.model.response.ResponseScrapDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ScrapService {
    @POST("scrap")
    fun scrap(
        @Body request: RequestScrapDto,
    ): Call<ResponseScrapDto>
}
