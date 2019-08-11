package com.example.mvvmsamplekotlin.views.baseviews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsamplekotlin.datamanager.DataManager
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(dataManager: DataManager) : ViewModel() {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var loadingLiveData = MutableLiveData<Boolean>()

    protected fun showLoading() {
        loadingLiveData.value = true
    }

    protected fun hideLoading() {
        loadingLiveData.value = false
    }

    fun observeForDialog(): LiveData<Boolean> {
        return loadingLiveData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}