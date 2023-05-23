package com.example.myhouse_aos.util.snackbar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.myhouse_aos.R
import com.example.myhouse_aos.databinding.CustomSnackbarBinding
import com.google.android.material.snackbar.Snackbar


class ScrapSnackBar(view: View) {

    companion object {
        fun make(view: View) = ScrapSnackBar(view)
    }

    private val context = view.context
    private val snackbar = Snackbar.make(view, "", 3000)
    private val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val snackbarBinding: CustomSnackbarBinding = DataBindingUtil.inflate(inflater, R.layout.custom_snackbar, null, false)
    private val scrapButton = snackbarBinding.btnCustomSnackbarScrap
    private val folderButton = snackbarBinding.btnCustomSnackbarFolder

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
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT
            params.setMargins(0, 0, 0, 0)
            layoutParams = params
            clipToPadding = false
            clipChildren = false

            scrapButton.setOnClickListener{

            }
            folderButton.setOnClickListener{

            }
        }
    }
    fun show() {
        snackbar.animationMode = Snackbar.ANIMATION_MODE_SLIDE
        snackbar.show()
    }

    fun dismiss(){
        snackbar.dismiss()
    }
}