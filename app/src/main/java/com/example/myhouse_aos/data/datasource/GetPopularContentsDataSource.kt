package com.example.myhouse_aos.data.datasource

import com.example.myhouse_aos.data.ServicePool
import com.example.myhouse_aos.data.model.response.ResponsePopularContent

class GetPopularContentsDataSource {
    private val getPopularContentsService = ServicePool.getService

    suspend fun getPopularContents(): ResponsePopularContent =
        getPopularContentsService.getPopularContents()
}