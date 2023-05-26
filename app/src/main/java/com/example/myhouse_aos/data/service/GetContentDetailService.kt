package com.example.myhouse_aos.data.service

import com.example.myhouse_aos.data.model.response.ResponseContentDetailDto
import retrofit2.Call
import retrofit2.http.GET

interface GetContentDetailService {
    @GET("posts/1")
    fun get(
    ): Call<ResponseContentDetailDto>
}