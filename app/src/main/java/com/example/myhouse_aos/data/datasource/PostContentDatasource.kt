package com.example.myhouse_aos.data.datasource

import com.example.myhouse_aos.data.ServicePool
import com.example.myhouse_aos.data.model.response.ResponsePostContent


class PostContentDatasource {
    private val postContentService = ServicePool.postContentService

    suspend fun fetchPostContents(): ResponsePostContent =
        postContentService.fetchPostContents()
}