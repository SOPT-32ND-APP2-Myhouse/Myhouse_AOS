package com.example.myhouse_aos.data.repository

import com.example.myhouse_aos.data.datasource.PostContentDatasource
import com.example.myhouse_aos.domain.model.PostContent
import com.example.myhouse_aos.domain.repository.PostContentRepository

class PostContentRepositoryImpl(private val postContentDatasource: PostContentDatasource) :
    PostContentRepository {
    override suspend fun fetchPostContent(): Result<List<PostContent>> =
        runCatching {
            postContentDatasource.fetchPostContents().toPostContent()
        }
}