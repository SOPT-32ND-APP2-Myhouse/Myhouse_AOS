package com.example.myhouse_aos.util

import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.ScrapCompleteSnackbarBinding
import com.google.android.material.snackbar.Snackbar

class ScrapCompleteSnackBar(
    view: View,
) {
    private val context = view.context
    private val snackbar = Snackbar.make(view, "", 3000)
    private val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val snackbarBinding: ScrapCompleteSnackbarBinding =
        DataBindingUtil.inflate(inflater, R.layout.scrap_complete_snackbar, null, false)

    init {
        initView()
    }

    private fun initView() {
        with(snackbarLayout) {
            removeAllViews()
            setPadding(0, 0, 0, 0)
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            addView(snackbarBinding.root, 0)
        }

        addListeners()
    }

    private fun addListeners() {
        snackbarBinding.btnShowScrap.setOnClickListener {
            moveToMain()
        }
    }

    // TODO 스크랩뷰로 이동하도록 수정
    fun moveToMain() {
//        context.startActivity(Intent(context, MainActivity::class.java))
    }

    fun show() {
        snackbar.show()
    }
}