package com.example.myhouse_aos.data.service

import com.example.myhouse_aos.data.model.response.ResponsePostContent
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    suspend fun fetchPostContents(): ResponsePostContent
}