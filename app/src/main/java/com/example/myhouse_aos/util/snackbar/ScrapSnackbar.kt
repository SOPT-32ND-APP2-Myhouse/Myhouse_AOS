package com.example.myhouse_aos.util.snackbar

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.CustomSnackbarBinding
import com.example.myhouse_aos.presentation.scrap.ScrapActivity
import com.google.android.material.snackbar.Snackbar


class ScrapSnackBar(
    view: View,
    val imageUrl: String,
    val showFolderBottomSheet: (String) -> Unit,
) {
    private val context = view.context
    private val snackbar = Snackbar.make(view, "", 3000)
    private val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val snackbarBinding: CustomSnackbarBinding =
        DataBindingUtil.inflate(inflater, R.layout.custom_snackbar, null, false)

    init {
        initView()
    }

    private fun initView() {
        with(snackbarLayout) {
            removeAllViews()
            setPadding(0, 0, 0, 0)
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
            addView(snackbarBinding.root, 0)
            val params = layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(0, 0, 0, 0)  // 패딩을 없애기 위해 마진 값을 0으로 설정
            layoutParams = params

            snackbarBinding.btnCustomSnackbarScrap.setOnClickListener {
                moveToScrap()
            }
            snackbarBinding.btnCustomSnackbarFolder.setOnClickListener {
                showFolderBottomSheet(imageUrl)
            }
        }
    }

    private fun moveToScrap() {
        context.startActivity(Intent(context, ScrapActivity::class.java))
    }

    fun show() {
        snackbar.animationMode = Snackbar.ANIMATION_MODE_SLIDE
        snackbar.show()
    }
}