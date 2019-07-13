package com.example.mvvmsamplekotlin.di

import android.app.Application
import com.example.mvvmsamplekotlin.MVVMSampleApp
import com.example.mvvmsamplekotlin.di.modules.AppModule
import com.example.mvvmsamplekotlin.di.modules.ContextModule
import com.example.mvvmsamplekotlin.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, ContextModule::class, NetworkModule::class,
        AndroidInjectionModule::class]
)
interface AppComponent {

    fun inject(mvvmSampleApp: MVVMSampleApp)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}