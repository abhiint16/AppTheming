package com.example.mvvmsamplekotlin.views.appviews.home.di

import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsamplekotlin.datamanager.DataManager
import com.example.mvvmsamplekotlin.utils.ViewModelProviderFactory
import com.example.mvvmsamplekotlin.views.appviews.home.viewmodel.HomeActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    fun providesHomeActivityViewModel(dataManager: DataManager): HomeActivityViewModel {
        return HomeActivityViewModel(dataManager)
    }

    @Provides
    fun providesViewModelProvider(homeActivityViewModel: HomeActivityViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(homeActivityViewModel)
    }
}