package com.example.myhouse_aos.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

class BestProductModel(
    val rank: Int?,
    var imageUrl: String?,
    var postTitle: String,
    var discount: Double?,
    var price: Long?,
    var brand: String,
)