package com.example.myhouse_aos.util.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.myhouse_aos.R
import java.text.DecimalFormat

@BindingAdapter("imageUrl")
fun loadImager(view: ImageView, imageurl: String?) {
    view.load(imageurl)
}

@BindingAdapter("discount")
fun TextView.discount(value: Double) {
    val formattedValue = value.toInt().toString()
    this.text = context.getString(R.string.string_home_discount_percent, formattedValue)
}

@BindingAdapter("priceAmount")
fun applyPriceFormat(view: TextView, price: Long) {
    val decimalFormat = DecimalFormat("#,###")
    view.text = decimalFormat.format(price)
}