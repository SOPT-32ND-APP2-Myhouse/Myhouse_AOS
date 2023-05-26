package com.example.myhouse_aos.data

import com.example.myhouse_aos.BuildConfig
import com.example.myhouse_aos.data.service.AddFolderService
import com.example.myhouse_aos.data.service.DeleteScrapService
import com.example.myhouse_aos.data.service.GetContentDetailService
import com.example.myhouse_aos.data.service.ScrapService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {
    private val client by lazy {
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }).build()
    }
    val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client).build()
    }


    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    val scrapService = ApiFactory.create<ScrapService>()
    val getContentDetailService = ApiFactory.create<GetContentDetailService>()
    val deleteScrapService = ApiFactory.create<DeleteScrapService>()
    val addFolderService = ApiFactory.create<AddFolderService>()
}
