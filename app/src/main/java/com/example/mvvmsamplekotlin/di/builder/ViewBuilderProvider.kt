package com.example.mvvmsamplekotlin.di.builder

import com.example.mvvmsamplekotlin.views.appviews.home.HomeActivity
import com.example.mvvmsamplekotlin.views.appviews.home.di.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewBuilderProvider {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun homeActivity(): HomeActivity
}