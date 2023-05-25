package com.example.myhouse_aos.data.repository

import com.example.myhouse_aos.data.datasource.GetRecommendHomeDataSource
import com.example.myhouse_aos.domain.model.RecommendHomeModel
import com.example.myhouse_aos.domain.repository.GetRecommendHomeRepository

class GetRecommendHomeRepositoryImpl(private val getRecommendHomeDataSource: GetRecommendHomeDataSource) :
    GetRecommendHomeRepository {
    override suspend fun getRecommendHome(): Result<RecommendHomeModel> =
        runCatching {
            RecommendHomeModel(
                postId = getRecommendHomeDataSource.getRecommendHome().data.post.post_id,
                tag = getRecommendHomeDataSource.getRecommendHome().data.post.tag,
                userName = getRecommendHomeDataSource.getRecommendHome().data.post.user_name,
                title = getRecommendHomeDataSource.getRecommendHome().data.post.title,
                imageUrl = getRecommendHomeDataSource.getRecommendHome().data.post.image_url
            )
        }
}