package com.example.myhouse_aos.presentation.home

import androidx.lifecycle.ViewModel
import com.example.myhouse_aos.R
import com.example.myhouse_aos.domain.model.BestProductModel
import com.example.myhouse_aos.domain.model.ContentsData
import com.example.myhouse_aos.domain.model.PopularContentsModel
import com.example.myhouse_aos.domain.model.RecommendHomeModel

class HomeViewModel : ViewModel() {
    val popularContentsList = listOf(
        PopularContentsModel(
            postId = "1",
            rate = "1",
            imageUrl = R.drawable.img_popular_contents,
            title = "간결해진 삶에 행복을 더하\n는!",
            subTitle = " 뷰맛집 상큼하우스"
        ),
        PopularContentsModel(
            postId = "2",
            rate = "2",
            imageUrl = R.drawable.img_popular_contents,
            title = "간결해진 삶에 행복을 더하\n는!",
            subTitle = " 뷰맛집 상큼하우스"
        ),
        PopularContentsModel(
            postId = "3",
            rate = "3",
            imageUrl = R.drawable.img_popular_contents,
            title = "간결해진 삶에 행복을 더하\n는!",
            subTitle = " 뷰맛집 상큼하우스"
        ),
    )

    val recommendHomeList = listOf(
        RecommendHomeModel(
            postId = "1",
            imageUrl = R.drawable.img_recommend_home,
            title = "깔끔하게 변신한 20살 아파트",
            tag = "",
            userName = "nickname"
        ),
        RecommendHomeModel(
            postId = "2",
            imageUrl = R.drawable.img_recommend_home,
            title = "소형평수&반려묘를 위한 아이디\n어! 24평 구축 리모델링",
            tag = "",
            userName = "nickname"
        ),
        RecommendHomeModel(
            postId = "3",
            imageUrl = R.drawable.img_recommend_home,
            title = "조명맛집! 자취 4년 차의 서울 \n신축 6평 원룸",
            tag = "",
            userName = "nickname"
        ),
        RecommendHomeModel(
            postId = "4",
            imageUrl = R.drawable.img_recommend_home,
            title = "로망집 ! 흙을 밟으며 마음껏 뛰노\n는 마당 있는 집",
            tag = "",
            userName = "nickname"
        ),
    )

    val recommendProductList = listOf(
        BestProductModel(
            imageUrl = R.drawable.img_recommend_product,
            postTitle = "[10%쿠폰] 부드러운 카스\n테라 항균 옥수수솜 충전..",
            discount="56%",
            brand="헬로우슬립",
            price="34,900",
            rate="",
            reviewsCount=""
        ),
        BestProductModel(
            imageUrl = R.drawable.img_recommend_product,
            postTitle = "[10%쿠폰] 부드러운 카스\n테라 항균 옥수수솜 충전..",
            discount="56%",
            brand="헬로우슬립",
            price="34,900",
            rate="",
            reviewsCount=""

        ),
        BestProductModel(
            imageUrl = R.drawable.img_recommend_product,
            postTitle = "[10%쿠폰] 부드러운 카스\n테라 항균 옥수수솜 충전..",
            discount="56%",
            brand="헬로우슬립",
            price="34,900",
            rate="",
            reviewsCount=""
        ),
        BestProductModel(
            imageUrl = R.drawable.img_recommend_product,
            postTitle = "[10%쿠폰] 부드러운 카스\n테라 항균 옥수수솜 충전..",
            discount="56%",
            brand="헬로우슬립",
            price="34,900",
            rate="",
            reviewsCount=""
        ),
    )


    val modernInteriorList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_modern_interior,
            description = "간결해진 삶에 행복을 더하는!",
            subDescription = "뷰\n 맛집, 상큼 하우스"
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_modern_interior,
            description = "간결해진 삶에 행복을 더하는!",
            subDescription = "뷰\n 맛집, 상큼 하우스"
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_modern_interior,
            description = "간결해진 삶에 행복을 더하는!",
            subDescription = "뷰\n 맛집, 상큼 하우스"
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_modern_interior,
            description = "간결해진 삶에 행복을 더하는!",
            subDescription = "뷰\n 맛집, 상큼 하우스"
        ),
    )

    val categoryList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.ic_lamp,
            description = "조명",
            subDescription = ""
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.ic_plant,
            description = "데코 식물",
            subDescription = ""

        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.ic_furniture,
            description = "가구",
            subDescription = ""
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.ic_kitchen,
            description = "주방용품",
            subDescription = ""
        ),
        ContentsData(
            contentId = 5,
            image = R.drawable.ic_lamp,
            description = "조명",
            subDescription = ""
        ),
    )

    val summerContentsList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_summer_contents,
            description = "간결해진 삶에 행복을 더하는!",
            subDescription = "뷰\n 맛집, 상큼 하우스"
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_summer_contents,
            description = "간결해진 삶에 행복을 더하는!",
            subDescription = "뷰\n 맛집, 상큼 하우스"
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_summer_contents,
            description = "간결해진 삶에 행복을 더하는!",
            subDescription = "뷰\n 맛집, 상큼 하우스"
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_summer_contents,
            description = "간결해진 삶에 행복을 더하는!",
            subDescription = "뷰\n 맛집, 상큼 하우스"
        ),
    )

    val colorInteriorList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_color_interior,
            description = "",
            subDescription = ""
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_color_interior,
            description = "",
            subDescription = ""
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_color_interior,
            description = "",
            subDescription = ""
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_color_interior,
            description = "",
            subDescription = ""
        ),
    )
    val colorProductList = listOf(
        BestProductModel(
            imageUrl = R.drawable.img_color_product,
            postTitle = "LED 오로라 블루투스 스\n피커 무드등 인기상품임...",
            discount="56%",
            brand="헬로우슬립",
            price="34,900",
            rate="",
            reviewsCount=""
        ),
        BestProductModel(
            imageUrl = R.drawable.img_color_product,
            postTitle = "LED 오로라 블루투스 스\n피커 무드등 인기상품임...",
            discount="56%",
            brand="헬로우슬립",
            price="34,900",
            rate="",
            reviewsCount=""
        ),
        BestProductModel(
            imageUrl = R.drawable.img_color_product,
            postTitle = "LED 오로라 블루투스 스\n피커 무드등 인기상품임...",
            discount="56%",
            brand="헬로우슬립",
            price="34,900",
            rate="",
            reviewsCount=""
        ),
        BestProductModel(
            imageUrl = R.drawable.img_color_product,
            postTitle = "LED 오로라 블루투스 스\n피커 무드등 인기상품임...",
            discount="56%",
            brand="헬로우슬립",
            price="34,900",
            rate="",
            reviewsCount=""
        ),
    )
    val reviewList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_review,
            description = "#하대원동 아튼빌 #30평대",
            subDescription = "전체 인테리어를 해야겠다\n생각해서 5군데 견적을 비교\n했습니다. 일정이 촉박하..."
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_review,
            description = "#하대원동 아튼빌 #30평대",
            subDescription = "전체 인테리어를 해야겠다\n생각해서 5군데 견적을 비교\n했습니다. 일정이 촉박하..."
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_review,
            description = "#하대원동 아튼빌 #30평대",
            subDescription = "전체 인테리어를 해야겠다\n생각해서 5군데 견적을 비교\n했습니다. 일정이 촉박하..."
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_review,
            description = "#하대원동 아튼빌 #30평대",
            subDescription = "전체 인테리어를 해야겠다\n생각해서 5군데 견적을 비교\n했습니다. 일정이 촉박하..."
        ),
    )
    val menuList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.ic_cart,
            description = "쇼핑하기",
            subDescription = ""
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.ic_sale,
            description = "오!세일",
            subDescription = ""
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.ic_discount,
            description = "오늘의 딜",
            subDescription = ""
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.ic_heart,
            description = "취향의 발견",
            subDescription = ""
        ),
        ContentsData(
            contentId = 5,
            image = R.drawable.ic_food,
            description = "장보기",
            subDescription = ""
        ),
        ContentsData(
            contentId = 6,
            image = R.drawable.ic_home,
            description = "집들이",
            subDescription = ""
        ),
        ContentsData(
            contentId = 7,
            image = R.drawable.ic_cart,
            description = "쇼핑하기",
            subDescription = ""
        ),

    )

    val popularPhotoList = listOf(
        PopularContentsModel(
            postId = "1",
            rate = "1",
            imageUrl = R.drawable.img_popular_photo,
            title = "",
            subTitle = ""
        ),
        PopularContentsModel(
            postId = "2",
            rate = "2",
            imageUrl = R.drawable.img_popular_photo,
            title = "",
            subTitle = ""
        ),
        PopularContentsModel(
            postId = "3",
            rate = "3",
            imageUrl = R.drawable.img_popular_photo,
            title = "",
            subTitle = ""
        ),
    )

}