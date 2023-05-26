package com.example.myhouse_aos.data.datasource

import com.example.myhouse_aos.data.ServicePool
import com.example.myhouse_aos.data.model.response.ResponseBestProduct

class GetBestProductDataSource {
    private val getBestProductService = ServicePool.getService

    suspend fun getBestProductService(): ResponseBestProduct =
        getBestProductService.getBestProduct()
}