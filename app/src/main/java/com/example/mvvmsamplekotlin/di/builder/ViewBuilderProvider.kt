package com.example.mvvmsamplekotlin.di.builder

import com.example.mvvmsamplekotlin.views.HomeActivity
import com.example.mvvmsamplekotlin.views.di.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewBuilderProvider {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun homeActivity(): HomeActivity
}