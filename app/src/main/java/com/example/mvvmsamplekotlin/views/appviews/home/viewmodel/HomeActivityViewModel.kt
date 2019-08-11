package com.example.mvvmsamplekotlin.views.appviews.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmsamplekotlin.datamanager.DataManager
import com.example.mvvmsamplekotlin.views.baseviews.BaseViewModel

class HomeActivityViewModel(dataManager: DataManager) : BaseViewModel(dataManager) {

    internal var mutableLiveData = MutableLiveData<Boolean>()

    fun testFun() {
        mutableLiveData.value = true
    }

    fun observeForLiveData(): LiveData<Boolean> {
        return mutableLiveData
    }
}