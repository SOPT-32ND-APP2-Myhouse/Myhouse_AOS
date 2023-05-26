package com.example.myhouse_aos.data.repository

import com.example.myhouse_aos.data.datasource.GetBestProductDataSource
import com.example.myhouse_aos.data.datasource.GetRecommendHomeDataSource
import com.example.myhouse_aos.domain.model.BestProductModel
import com.example.myhouse_aos.domain.model.RecommendHomeModel
import com.example.myhouse_aos.domain.repository.GetBestProductRepository
import com.example.myhouse_aos.domain.repository.GetRecommendHomeRepository

class GetBestProductRepositoryImpl(private val getBestProductDataSource: GetBestProductDataSource) :
    GetBestProductRepository {
    override suspend fun getBestProduct(): Result<List<BestProductModel>> =
        runCatching {
            getBestProductDataSource.getBestProductService().toBestProductModel()
        }
}