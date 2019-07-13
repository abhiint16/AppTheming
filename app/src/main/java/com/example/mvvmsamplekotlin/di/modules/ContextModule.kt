package com.example.mvvmsamplekotlin.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class ContextModule {
    @Inject
    lateinit var context: Context

    @Provides
    fun providesApplicationContext(): Context {
        return context
    }
}