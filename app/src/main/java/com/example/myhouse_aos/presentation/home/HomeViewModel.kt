package com.example.myhouse_aos.presentation.home

import androidx.lifecycle.ViewModel
import com.example.myhouse_aos.R
import com.example.myhouse_aos.domain.model.ContentsData

class HomeViewModel : ViewModel() {
    val popularContentsList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_popular_contents,
            description = "간결해진 삶에 행복을 더하\n는! 뷰맛집 상큼하우스",
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_popular_contents,
            description = "간결해진 삶에 행복을 더하\n는! 뷰맛집 상큼하우스",
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_popular_contents,
            description = "간결해진 삶에 행복을 더하\n는! 뷰맛집 상큼하우스",
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_popular_contents,
            description = "간결해진 삶에 행복을 더하\n는! 뷰맛집 상큼하우스",
        ),
    )

    val recommendHomeList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_recommend_home,
            description = "깔끔하게 변신한 20살 아파트",
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_recommend_home,
            description = "소형평수&반려묘를 위한 아이디\n어! 24평 구축 리모델링",
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_recommend_home,
            description = "조명맛집! 자취 4년 차의 서울 \n신축 6평 원룸",
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_recommend_home,
            description = "로망집 ! 흙을 밟으며 마음껏 뛰노\n는 마당 있는 집",
        ),
    )

    val recommendProductList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_recommend_product,
            description = ""
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_recommend_product,
            description = ""

        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_recommend_product,
            description = ""
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_recommend_product,
            description = ""
        ),
    )


    val modernInteriorList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_modern_interior,
            description = "간결해진 삶에 행복을 더하는! 뷰\n맛집, 상큼 하우스"
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_modern_interior,
            description = "간결해진 삶에 행복을 더하는! 뷰\n맛집, 상큼 하우스"

        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_modern_interior,
            description = "간결해진 삶에 행복을 더하는! 뷰\n맛집, 상큼 하우스"
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_modern_interior,
            description = "간결해진 삶에 행복을 더하는! 뷰\n맛집, 상큼 하우스"
        ),
    )

    val categoryList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.ic_lamp,
            description = "조명"
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.ic_plant,
            description = "데코 식물"

        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.ic_furniture,
            description = "가구"
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.ic_kitchen,
            description = "주방용품"
        ),
        ContentsData(
            contentId = 5,
            image = R.drawable.ic_lamp,
            description = "조명"
        ),
    )

    val summerContentsList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_summer_contents,
            description = ""
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_summer_contents,
            description = ""
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_summer_contents,
            description = ""
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_summer_contents,
            description = ""
        ),
    )

    val colorInteriorList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_color_interior,
            description = ""
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_color_interior,
            description = ""
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_color_interior,
            description = ""
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_color_interior,
            description = ""
        ),
    )
    val colorProductList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_color_product,
            description = ""
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_color_product,
            description = ""
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_color_product,
            description = ""
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_color_product,
            description = ""
        ),
    )
    val reviewList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_review,
            description = ""
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_review,
            description = ""
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_review,
            description = ""
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_review,
            description = ""
        ),
    )
    val menuList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.ic_cart,
            description = "쇼핑하기"
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.ic_sale,
            description = "오!세일"
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.ic_discount,
            description = "오늘의 딜"
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.ic_heart,
            description = "취향의 발견"
        ),
        ContentsData(
            contentId = 5,
            image = R.drawable.ic_food,
            description = "장보기"
        ),
        ContentsData(
            contentId = 6,
            image = R.drawable.ic_home,
            description = "집들이"
        ),
        ContentsData(
            contentId = 7,
            image = R.drawable.ic_cart,
            description = "쇼핑하기"
        ),

    )

}