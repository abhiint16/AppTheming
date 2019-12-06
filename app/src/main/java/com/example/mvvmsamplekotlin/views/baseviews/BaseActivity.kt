package com.example.mvvmsamplekotlin.views.baseviews

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mvvmsamplekotlin.R
import com.example.mvvmsamplekotlin.views.themeType
import com.example.mvvmsamplekotlin.views.viewutil.LoadingDialog
import dagger.android.AndroidInjection

abstract class BaseActivity<Binding : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    lateinit var viewModel: VM

    lateinit var binding: Binding

    abstract fun setViewModel(): ViewModel

    lateinit var dialog: LoadingDialog

    @get:LayoutRes
    abstract val layout: Int

    //lateinit var themeType: String

    abstract fun initObserver()

    abstract fun setUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDependencyInjection()

        if (themeType.equals("LIGHT")) {
            setTheme(R.style.AppTheme_LightTheme)
        } else if (themeType.equals("DARK")) {
            setTheme(R.style.AppTheme_DarkTheme)
        }

        setBinding()
        viewModel = setViewModel() as VM
        baseViewModelObserver()
        initObserver()
        setUp()
    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this@BaseActivity, layout)
    }

    private fun setDependencyInjection() {
        AndroidInjection.inject(this)
    }

    private fun baseViewModelObserver() {
        viewModel.observeForDialog().observe(this, Observer {
            if (it)
                showLoading()
            else
                hideLoading()
        })
    }

    protected fun showToast(toastMsg: String) {
        Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show()
    }

    protected fun showLoading() {
        dialog = LoadingDialog(this@BaseActivity)
        dialog.show()
    }

    protected fun hideLoading() {
        if (dialog.isShowing)
            dialog.dismiss()
    }

}