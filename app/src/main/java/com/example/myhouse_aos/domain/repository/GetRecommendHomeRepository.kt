package com.example.myhouse_aos.domain.repository

import com.example.myhouse_aos.domain.model.RecommendHomeModel

interface GetRecommendHomeRepository {
    suspend fun getRecommendHome(): Result<RecommendHomeModel>
}