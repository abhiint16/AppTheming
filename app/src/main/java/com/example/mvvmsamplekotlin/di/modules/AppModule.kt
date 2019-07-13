package com.example.mvvmsamplekotlin.di.modules

import com.example.mvvmsamplekotlin.AppConstants
import com.example.mvvmsamplekotlin.datamanager.DataManager
import com.example.mvvmsamplekotlin.datamanager.DataManagerImpl
import com.example.mvvmsamplekotlin.datamanager.apihelper.ApiHelper
import com.example.mvvmsamplekotlin.datamanager.apihelper.ApiHelperImpl
import com.example.mvvmsamplekotlin.datamanager.apihelper.ApiService
import com.example.mvvmsamplekotlin.datamanager.dbhelper.DBHelper
import com.example.mvvmsamplekotlin.datamanager.dbhelper.DBHelperImpl
import com.example.mvvmsamplekotlin.datamanager.prefhelper.PreferenceHelper
import com.example.mvvmsamplekotlin.datamanager.prefhelper.PreferenceHelperImpl
import com.example.mvvmsamplekotlin.di.qualifier.PreferenceName
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun providesDataManager(dataManagerImpl: DataManagerImpl):
            DataManager {
        return dataManagerImpl
    }

    @Provides
    @Singleton
    fun providesApiHelper(apiHelper: ApiHelperImpl):
            ApiHelper {
        return apiHelper
    }

    @Provides
    fun providesDBHelper(dbHelper: DBHelperImpl):
            DBHelper {
        return dbHelper
    }

    @Provides
    fun providesPrefHelper(preferenceHelper: PreferenceHelperImpl):
            PreferenceHelper {
        return preferenceHelper
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @PreferenceName
    fun providesSharedPrefName(): String {
        return AppConstants.SHARED_PREFERENCE_NAME;
    }
}