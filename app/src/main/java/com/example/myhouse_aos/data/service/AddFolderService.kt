package com.example.myhouse_aos.data.service

import com.example.myhouse_aos.data.model.request.RequestAddFolderDto
import com.example.myhouse_aos.data.model.response.ResponseAddFolderDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AddFolderService {
    @POST("scrap/{folder_id}")
    fun add(
        @Path("folder_id")
        folder_id: Int,
        @Body request: RequestAddFolderDto,
    ): Call<ResponseAddFolderDto>
}