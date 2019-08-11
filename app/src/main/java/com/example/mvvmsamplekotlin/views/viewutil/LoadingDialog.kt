package com.example.mvvmsamplekotlin.views.viewutil

import android.app.Dialog
import android.content.Context
import com.example.mvvmsamplekotlin.R

class LoadingDialog(context: Context) : Dialog(context) {

    init {
        initView()
    }

    private fun initView() {
        setContentView(R.layout.item_loading)
        setCancelable(false)
    }
}