package com.example.myhouse_aos.domain.repository

import com.example.myhouse_aos.domain.model.PopularContentsModel
import com.example.myhouse_aos.domain.model.PostContent


interface GetPopularContentsRepository {
    suspend fun getPopularContents(): Result<List<PopularContentsModel>>
}
