package com.example.mvvmsamplekotlin.views.baseviews

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import dagger.android.AndroidInjection

abstract class BaseActivity<Binding : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    lateinit var viewModel: VM

    lateinit var binding: Binding

    abstract fun setViewModel(): ViewModel

    @get:LayoutRes
    abstract val layout: Int

    abstract fun initObserver()

    abstract fun setUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDependencyInjection()
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

    }

    protected fun hideLoading() {

    }

}