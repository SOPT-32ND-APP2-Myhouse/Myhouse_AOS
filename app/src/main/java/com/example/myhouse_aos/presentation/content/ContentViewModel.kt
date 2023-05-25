package com.example.myhouse_aos.presentation.content

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse_aos.R
import com.example.myhouse_aos.data.ServicePool
import com.example.myhouse_aos.data.model.request.RequestScrapDto
import com.example.myhouse_aos.data.model.response.ResponseContentDetailDto
import com.example.myhouse_aos.data.model.response.ResponseDeleteScrapDto
import com.example.myhouse_aos.data.model.response.ResponseScrapDto
import com.example.myhouse_aos.domain.model.*
import retrofit2.Call
import retrofit2.Response

class ContentViewModel : ViewModel() {
    private val _contentDetailResult: MutableLiveData<ResponseContentDetailDto> = MutableLiveData()
    val contentDetailResult: LiveData<ResponseContentDetailDto> = _contentDetailResult

    private val _scrapResult: MutableLiveData<ResponseScrapDto> = MutableLiveData()
    val scrapResult: LiveData<ResponseScrapDto> = _scrapResult

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
            imageId = 1,
            image = R.drawable.content_detail_card,
            content = "식물들 창가로 몰아주기"
        ),
        ContentDetailData.Images(
            imageId = 2,
            image = R.drawable.content_detail_card,
            content = null
        ),
        ContentDetailData.Images(
            imageId = 3,
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

    val userimageList = listOf(
        UserimageData(
            image = R.drawable.userimage
        ),
        UserimageData(
            image = R.drawable.userimage
        ),
        UserimageData(
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
            image = R.drawable.userbest,
            title = "좁은 세탁실,딱 세 가지로 깔끔한 수납공간으로 대변신"
        ),
        UserBestData(
            image = R.drawable.userbest,
            title = "좁은 세탁실,딱 세 가지로 깔끔한 수납공간으로 대변신"
        ),
        UserBestData(
            image = R.drawable.userbest,
            title = "좁은 세탁실,딱 세 가지로 깔끔한 수납공간으로 대변신"
        ),
        UserBestData(
            image = R.drawable.userbest,
            title = "좁은 세탁실,딱 세 가지로 깔끔한 수납공간으로 대변신"
        )
    )

    private val getContentDetailService = ServicePool.getContentDetailService
    fun completeGetUsers() {
        getContentDetailService.get()
            .enqueue(object : retrofit2.Callback<ResponseContentDetailDto> {
                override fun onResponse(
                    call: Call<ResponseContentDetailDto>,
                    response: Response<ResponseContentDetailDto>,
                ) {
                    if (response.isSuccessful) {
                        _contentDetailResult.value = response.body()
                        Log.e("test log", "isSuccessful")

                    } else {
                        Log.e("test log", "isnotSuccessful")
                    }
                }

                override fun onFailure(call: Call<ResponseContentDetailDto>, t: Throwable) {
                    Log.e("test log", "onFailure", t)
                }
            })
    }

    fun createHashTagArray(str: String): List<HashTagData> {
        val tagArray = str.split(" ")
        return tagArray.map { str ->
            HashTagData(str)
        }.toList()
    }

    val scrapService = ServicePool.ScrapService
    fun scrap(image_url: String) {
        scrapService.scrap(RequestScrapDto(image_url))
            .enqueue(object : retrofit2.Callback<ResponseScrapDto> {
                override fun onResponse(
                    call: Call<ResponseScrapDto>,
                    response: Response<ResponseScrapDto>,
                ) {
                    if (response.isSuccessful) {
                        _scrapResult.value = response.body()
                        Log.e("test log", "isSuccessful")

                    } else {
                        Log.e("test log", "isnotSuccessful")
                    }
                }

                override fun onFailure(call: Call<ResponseScrapDto>, t: Throwable) {
                    Log.e("test log", "onFailure", t)
                }
            })
    }

    val deleteScrapService = ServicePool.deleteScrapService
    fun deleteScrap(image_id: Int) {
        deleteScrapService.delete(image_id)
            .enqueue(object : retrofit2.Callback<ResponseDeleteScrapDto> {
                override fun onResponse(
                    call: Call<ResponseDeleteScrapDto>,
                    response: Response<ResponseDeleteScrapDto>,
                ) {
                    if (response.isSuccessful) {
                        _scrapDeleteResult.value = response.body()
                        Log.e("test log", "isSuccessful")

                    } else {
                        Log.e("test log", "isnotSuccessful")
                    }
                }

                override fun onFailure(call: Call<ResponseDeleteScrapDto>, t: Throwable) {
                    Log.e("test log", "onFailure", t)
                }
            })
    }
}