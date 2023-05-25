package com.example.myhouse_aos.domain.repository

import com.example.myhouse_aos.domain.model.BestProductModel

interface GetBestProductRepository {
    suspend fun getBestProduct(): Result<List<BestProductModel>>
}