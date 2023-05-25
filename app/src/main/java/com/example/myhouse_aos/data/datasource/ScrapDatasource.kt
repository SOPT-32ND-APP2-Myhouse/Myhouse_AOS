package com.example.myhouse_aos.data.datasource

import com.example.myhouse_aos.data.ServicePool
import com.example.myhouse_aos.data.model.response.ResponseScrap

class ScrapDatasource {
    private val scrapService = ServicePool.scrapService

    suspend fun fetchScraps(): ResponseScrap =
        scrapService.fetchScraps()
}