package com.example.myhouse_aos.util.snackbar

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.CustomSnackbarBinding
import com.example.myhouse_aos.presentation.scrap.ScrapActivity
import com.google.android.material.snackbar.Snackbar


class ScrapSnackBar(
    view: View,
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

            snackbarBinding.btnCustomSnackbarScrap.setOnClickListener {
                context.startActivity(Intent(context, ScrapActivity::class.java))
            }
            snackbarBinding.btnCustomSnackbarFolder.setOnClickListener {

            }
        }
    }

    fun show() {
        snackbar.animationMode = Snackbar.ANIMATION_MODE_SLIDE
        snackbar.show()
    }
}