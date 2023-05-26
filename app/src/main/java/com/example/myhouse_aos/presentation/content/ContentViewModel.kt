package com.example.myhouse_aos.presentation.content

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse_aos.R
import com.example.myhouse_aos.data.ServicePool
import com.example.myhouse_aos.data.model.request.RequestAddFolderDto
import com.example.myhouse_aos.data.model.request.RequestScrapDto
import com.example.myhouse_aos.data.model.response.ResponseAddFolderDto
import com.example.myhouse_aos.data.model.response.ResponseContentDetailDto
import com.example.myhouse_aos.data.model.response.ResponseScrapDto
import com.example.myhouse_aos.domain.model.HashTagData
import com.example.myhouse_aos.domain.model.TodayRecommendData
import com.example.myhouse_aos.domain.model.UserBestData
import com.example.myhouse_aos.domain.model.UserimageData
import retrofit2.Call
import retrofit2.Response

class ContentViewModel : ViewModel() {
    private val getContentDetailService = ServicePool.getContentDetailService
    private val scrapService = ServicePool.scrapService
    private val addFolderService = ServicePool.addFolderService

    private val _contentDetailResult: MutableLiveData<ResponseContentDetailDto> = MutableLiveData()
    val contentDetailResult: LiveData<ResponseContentDetailDto> = _contentDetailResult

    private val _scrapResult: MutableLiveData<ResponseScrapDto> = MutableLiveData()
    val scrapResult: LiveData<ResponseScrapDto> = _scrapResult


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


    fun addFolder(id: Int, image_url: String?) {
        addFolderService.add(id, RequestAddFolderDto(image_url))
            .enqueue(object : retrofit2.Callback<ResponseAddFolderDto> {
                override fun onResponse(
                    call: Call<ResponseAddFolderDto>,
                    response: Response<ResponseAddFolderDto>,
                ) {
                    if (response.isSuccessful) {
                        Log.e("test log", "isSuccessful")

                    } else {
                        Log.e("test log", "isnotSuccessful")
                    }
                }

                override fun onFailure(call: Call<ResponseAddFolderDto>, t: Throwable) {
                    Log.e("test log", "onFailure", t)
                }
            })
    }
}