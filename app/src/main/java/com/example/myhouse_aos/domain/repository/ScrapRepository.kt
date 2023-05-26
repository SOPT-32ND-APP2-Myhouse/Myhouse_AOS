package com.example.myhouse_aos.domain.repository

import com.example.myhouse_aos.domain.model.Folder

interface ScrapRepository {
    suspend fun fetchScraps(): Result<List<Folder>>
}