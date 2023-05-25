package com.example.myhouse_aos.data.service

import com.example.myhouse_aos.data.model.response.ResponseDeleteScrapDto
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Path

interface DeleteScrapService {
    @DELETE("scrap/{scrap_id}")
    fun delete(
        @Path("scrap_id")
        scrap_id: Int
    ): Call<ResponseDeleteScrapDto>
}