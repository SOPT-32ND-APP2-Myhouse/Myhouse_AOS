package com.example.myhouse_aos.domain.repository

import com.example.myhouse_aos.domain.model.PostContent

interface PostContentRepository {
    suspend fun fetchPostContent(): Result<List<PostContent>>
}