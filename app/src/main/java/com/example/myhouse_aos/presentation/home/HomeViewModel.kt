package com.example.myhouse_aos.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse_aos.R
import com.example.myhouse_aos.data.repository.GetBestProductRepositoryImpl
import com.example.myhouse_aos.data.repository.GetPopularContentsRespositoryImpl
import com.example.myhouse_aos.data.repository.GetRecommendHomeRepositoryImpl
import com.example.myhouse_aos.data.service.AuthState
import com.example.myhouse_aos.domain.model.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPopularContentsRespositoryImpl: GetPopularContentsRespositoryImpl,
    private val getRecommendHomeRepositoryImpl: GetRecommendHomeRepositoryImpl,
    private val getBestProductRepositoryImpl: GetBestProductRepositoryImpl
) :
    ViewModel() {
    private val _getListState = MutableLiveData<AuthState>()
    val getListState: LiveData<AuthState>
        get() = _getListState

    private var _popularContentsList = MutableLiveData<List<PopularContentsModel>>()
    val popularContentsList: List<PopularContentsModel>?
        get() = _popularContentsList.value

    private var _bestProductList = MutableLiveData<List<BestProductModel>>()
    val bestProductList: List<BestProductModel>?
        get() = _bestProductList.value

    private var _recommendHome = MutableLiveData<RecommendHomeModel>()
    val recommendHome: RecommendHomeModel?
        get() = _recommendHome.value

    init {
        getPopularContentList()
        getRecommendHomeList()
        getBestProductList()
    }

    private fun getPopularContentList() {
        viewModelScope.launch {
            getPopularContentsRespositoryImpl.getPopularContents()
                .onSuccess { response ->
                    _popularContentsList.value = response
                    _getListState.value = AuthState.SUCCESS
                }
                .onFailure {
                    _getListState.value = AuthState.FAIL
                }
        }
    }

    private fun getBestProductList() {
        viewModelScope.launch {
            getBestProductRepositoryImpl.getBestProduct()
                .onSuccess { response ->
                    _bestProductList.value = response
                    _getListState.value = AuthState.SUCCESS
                }
                .onFailure {
                    _getListState.value = AuthState.FAIL
                }
        }
    }

    private fun getRecommendHomeList() {
        viewModelScope.launch {
            getRecommendHomeRepositoryImpl.getRecommendHome()
                .onSuccess { response ->
                    _recommendHome.value = response
                    _getListState.value = AuthState.SUCCESS
                }
                .onFailure { response ->
                    _getListState.value = AuthState.FAIL
                    Log.e("home", "Failed to get recommend home: ${response.message}", response)
                }
        }
    }

    val recommendProductList = listOf(
        BestProductModel(
            imageUrl = "drawable://" + R.drawable.img_recommend_product,
            postTitle = "[10%쿠폰] 부드러운 카스\n테라 항균 옥수수솜 충전..",
            discount = 56.0,
            brand = "헬로우슬립",
            price = 34900,
            rank = 1,
        ),
        BestProductModel(
            imageUrl = "drawable://" + R.drawable.img_recommend_product,
            postTitle = "[10%쿠폰] 부드러운 카스\n테라 항균 옥수수솜 충전..",
            discount = 56.0,
            brand = "헬로우슬립",
            price = 34900,
            rank = 2,

            ),
        BestProductModel(
            imageUrl = "drawable://" + R.drawable.img_recommend_product,
            postTitle = "[10%쿠폰] 부드러운 카스\n테라 항균 옥수수솜 충전..",
            discount = 56.0,
            brand = "헬로우슬립",
            price = 34900,
            rank = 3,
        ),
        BestProductModel(
            imageUrl = "drawable://" + R.drawable.img_recommend_product,
            postTitle = "[10%쿠폰] 부드러운 카스\n테라 항균 옥수수솜 충전..",
            discount = 56.0,
            brand = "헬로우슬립",
            price = 34900,
            rank = 4,
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
            imageUrl = "drawable://" + R.drawable.img_color_product,
            postTitle = "LED 오로라 블루투스 스\n피커 무드등 인기상품임...",
            discount = 56.0,
            brand = "헬로우슬립",
            price = 34900,
            rank = 1,
        ),
        BestProductModel(
            imageUrl = "drawable://" + R.drawable.img_color_product,
            postTitle = "LED 오로라 블루투스 스\n피커 무드등 인기상품임...",
            discount = 56.0,
            brand = "헬로우슬립",
            price = 34900,
            rank = 2,
        ),
        BestProductModel(
            imageUrl = "drawable://" + R.drawable.img_color_product,
            postTitle = "LED 오로라 블루투스 스\n피커 무드등 인기상품임...",
            discount = 56.0,
            brand = "헬로우슬립",
            price = 34900,
            rank = 3,
        ),
        BestProductModel(
            imageUrl = "drawable://" + R.drawable.img_color_product,
            postTitle = "LED 오로라 블루투스 스\n피커 무드등 인기상품임...",
            discount = 56.0,
            brand = "헬로우슬립",
            price = 34900,
            rank = 4,
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
            image = R.drawable.ic_shopping,
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
            image = R.drawable.ic_deal,
            description = "오늘의 딜",
            subDescription = ""
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.ic_fav,
            description = "취향의 발견",
            subDescription = ""
        ),
        ContentsData(
            contentId = 5,
            image = R.drawable.ic_market,
            description = "장보기",
            subDescription = ""
        ),
        ContentsData(
            contentId = 6,
            image = R.drawable.ic_house,
            description = "집들이",
            subDescription = ""
        ),
        ContentsData(
            contentId = 7,
            image = R.drawable.ic_shopping,
            description = "쇼핑하기",
            subDescription = ""
        ),

        )

    val popularPhotoList = listOf(
        PopularContentsModel(
            postId = 1,
            rate = 1,
            image = "drawable://" + R.drawable.img_popular_photo,
            title = "",
            subTitle = ""
        ),
        PopularContentsModel(
            postId = 2,
            rate = 2,
            image = "drawable://" + R.drawable.img_popular_photo,
            title = "",
            subTitle = ""
        ),
        PopularContentsModel(
            postId = 3,
            rate = 3,
            image = "drawable://" + R.drawable.img_popular_photo,
            title = "",
            subTitle = ""
        ),
    )
    val planList = listOf(
        ContentsData(
            contentId = 1,
            image = R.drawable.img_plan,
            description = "",
            subDescription = ""
        ),
        ContentsData(
            contentId = 2,
            image = R.drawable.img_plan,
            description = "",
            subDescription = ""
        ),
        ContentsData(
            contentId = 3,
            image = R.drawable.img_plan,
            description = "",
            subDescription = ""
        ),
        ContentsData(
            contentId = 4,
            image = R.drawable.img_plan,
            description = "",
            subDescription = ""
        )
    )


}