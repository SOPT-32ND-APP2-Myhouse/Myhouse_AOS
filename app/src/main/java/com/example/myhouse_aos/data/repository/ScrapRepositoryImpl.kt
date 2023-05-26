package com.example.myhouse_aos.data.repository

import com.example.myhouse_aos.data.datasource.ScrapDatasource
import com.example.myhouse_aos.domain.model.Folder
import com.example.myhouse_aos.domain.repository.ScrapRepository

class ScrapRepositoryImpl(val scrapDatasource: ScrapDatasource) : ScrapRepository {
    override suspend fun fetchScraps(): Result<List<Folder>> =
        runCatching {
            scrapDatasource.fetchScraps().data.toFolder()
        }
}