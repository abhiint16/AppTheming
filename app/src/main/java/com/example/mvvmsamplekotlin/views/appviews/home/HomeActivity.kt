package com.example.mvvmsamplekotlin.views.appviews.home

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsamplekotlin.R
import com.example.mvvmsamplekotlin.databinding.ActivityHomeBinding
import com.example.mvvmsamplekotlin.views.appviews.home.viewmodel.HomeActivityViewModel
import com.example.mvvmsamplekotlin.views.baseviews.BaseActivity
import com.example.mvvmsamplekotlin.views.themeType
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeActivityViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun setViewModel(): ViewModel {
        return ViewModelProviders.of(this, factory).get(HomeActivityViewModel::class.java)
    }

    override val layout: Int
        get() = R.layout.activity_home

    override fun initObserver() {
        viewModel.observeForLiveData().observe(this, Observer { boolean ->
            Toast.makeText(this, "Live Data Observed", Toast.LENGTH_LONG).show()
        })
    }

    override fun setUp() {
        binding.btn1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                themeType = "LIGHT"
                recreate()
            }

        })

        binding.btn2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                themeType = "DARK"
                recreate()
            }

        })
    }
}