package com.example.myhouse_aos.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun loadImager(view: ImageView, imageurl: String?) {
    view.load(imageurl)
}