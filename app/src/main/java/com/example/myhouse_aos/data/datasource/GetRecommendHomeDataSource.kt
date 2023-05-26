package com.example.myhouse_aos.data.datasource

import com.example.myhouse_aos.data.ServicePool
import com.example.myhouse_aos.data.model.response.ResponseRecommendHome

class GetRecommendHomeDataSource {
    private val getRecommendHomeService = ServicePool.getService

    suspend fun getRecommendHome(): ResponseRecommendHome =
        getRecommendHomeService.getRecommendHome()
}