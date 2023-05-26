package com.example.myhouse_aos.data.repository

import com.example.myhouse_aos.data.datasource.GetPopularContentsDataSource
import com.example.myhouse_aos.domain.model.PopularContentsModel
import com.example.myhouse_aos.domain.model.PostContent
import com.example.myhouse_aos.domain.repository.GetPopularContentsRepository

class GetPopularContentsRespositoryImpl(private val getPopularContentsDataSource: GetPopularContentsDataSource) :
    GetPopularContentsRepository {
    override suspend fun getPopularContents(): Result<List<PopularContentsModel>> =
        runCatching {
            getPopularContentsDataSource.getPopularContents().toPopularModel()
        }
}