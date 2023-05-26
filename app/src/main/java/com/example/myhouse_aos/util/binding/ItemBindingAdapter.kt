package com.example.myhouse_aos.util.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun loadImager(view: ImageView, imageurl: String?) {
    view.load(imageurl)
}

@BindingAdapter("imageDrawable")
fun ImageView.setImageDrawableFromAny(image: Any?) {
    val drawable = when (image) {
        is Drawable -> image
        is Int -> ContextCompat.getDrawable(context, image)
        is String -> Drawable.createFromPath(image)
        else -> null
    }
    setImageDrawable(drawable)
}