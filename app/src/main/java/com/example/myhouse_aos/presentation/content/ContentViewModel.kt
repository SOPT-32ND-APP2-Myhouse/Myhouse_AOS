package com.example.myhouse_aos.presentation.content

import androidx.lifecycle.ViewModel
import com.example.myhouse_aos.R
import com.example.myhouse_aos.domain.model.ContentDetailData
import com.example.myhouse_aos.domain.model.HashTagData

class ContentViewModel : ViewModel() {
    val ContentDetailList = listOf(
        ContentDetailData.Images(
            image_id = 1,
            image = R.drawable.content_detail_card,
            content = "식물들 창가로 몰아주기"
        ),
        ContentDetailData.Images(
            image_id = 2,
            image = R.drawable.content_detail_card,
            content = null
        ),
        ContentDetailData.Images(
            image_id = 3,
            image = R.drawable.content_detail_card,
            content = null
        )
    )

    val hashTagList = listOf(
        HashTagData(
            hash_tag = "#취미일상"
        ),
        HashTagData(
            hash_tag = "#6평"
        ),
        HashTagData(
            hash_tag = "#원룸"
        ),
        HashTagData(
            hash_tag = "#오피스텔"
        ),
        HashTagData(
            hash_tag = "#방꾸미기"
        ),
        HashTagData(
            hash_tag = "#홈테코"
        ),
        HashTagData(
            hash_tag = "#홈스타일링"
        ),
        HashTagData(
            hash_tag = "#인테리어"
        )
    )
}