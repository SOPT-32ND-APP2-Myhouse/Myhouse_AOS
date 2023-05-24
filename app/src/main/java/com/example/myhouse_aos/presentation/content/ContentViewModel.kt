package com.example.myhouse_aos.presentation.content

import androidx.lifecycle.ViewModel
import com.example.myhouse_aos.R
import com.example.myhouse_aos.domain.model.*

class ContentViewModel : ViewModel() {
    val contentDetail = ContentDetailData(
        1,
        "nickname",
        "2023-05-19",
        "20평대 | 내추럴스타일 | 아파트",
        "#취미일상 #6평 #원룸 #오피스텔 #방꾸미기 #홈테코 #홈스타일링 #인테리어",
        "좋아요  90",
        "스크랩  598",
        "댓글  7",
        "조회수  27,764"
    )
    val ContentDetailList = listOf(
        ContentDetailData.Images(
            imageId = 1, image = R.drawable.content_detail_card, content = "식물들 창가로 몰아주기"
        ), ContentDetailData.Images(
            imageId = 2, image = R.drawable.content_detail_card, content = null
        ), ContentDetailData.Images(
            imageId = 3, image = R.drawable.content_detail_card, content = null
        )
    )

    val hashTagList = listOf(
        HashTagData(
            hash_tag = "#취미일상"
        ), HashTagData(
            hash_tag = "#6평"
        ), HashTagData(
            hash_tag = "#원룸"
        ), HashTagData(
            hash_tag = "#오피스텔"
        ), HashTagData(
            hash_tag = "#방꾸미기"
        ), HashTagData(
            hash_tag = "#홈테코"
        ), HashTagData(
            hash_tag = "#홈스타일링"
        ), HashTagData(
            hash_tag = "#인테리어"
        )
    )

    val userimageList = listOf(
        UserimageData(
            image = R.drawable.userimage
        ), UserimageData(
            image = R.drawable.userimage
        ), UserimageData(
            image = R.drawable.userimage
        )
    )

    val todayRecommendList = listOf(
        TodayRecommendData(
            1,
            image = R.drawable.todayrecommend,
            manufacture = "우드레이",
            product = "홈카페 원형 식탁 테이블\n800size",
            price1 = "60%",
            price2 = "74,800"
        ),
        TodayRecommendData(
            2,
            image = R.drawable.todayrecommend,
            manufacture = "우드레이",
            product = "홈카페 원형 식탁 테이블\n800size",
            price1 = "60%",
            price2 = "74,800"
        ),
        TodayRecommendData(
            3,
            image = R.drawable.todayrecommend,
            manufacture = "우드레이",
            product = "홈카페 원형 식탁 테이블\n800size",
            price1 = "60%",
            price2 = "74,800"
        ),
        TodayRecommendData(
            4,
            image = R.drawable.todayrecommend,
            manufacture = "우드레이",
            product = "홈카페 원형 식탁 테이블\n800size",
            price1 = "60%",
            price2 = "74,800"
        ),
    )

    val userBestList = listOf(
        UserBestData(
            image = R.drawable.userbest, title = "좁은 세탁실,딱 세 가지로 깔끔한 수납공간으로 대변신"
        ), UserBestData(
            image = R.drawable.userbest, title = "좁은 세탁실,딱 세 가지로 깔끔한 수납공간으로 대변신"
        ), UserBestData(
            image = R.drawable.userbest, title = "좁은 세탁실,딱 세 가지로 깔끔한 수납공간으로 대변신"
        ), UserBestData(
            image = R.drawable.userbest, title = "좁은 세탁실,딱 세 가지로 깔끔한 수납공간으로 대변신"
        )
    )
}