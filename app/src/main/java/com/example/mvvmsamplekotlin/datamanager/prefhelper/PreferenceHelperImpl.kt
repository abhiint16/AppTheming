package com.example.mvvmsamplekotlin.datamanager.prefhelper

import android.content.Context
import android.content.SharedPreferences
import com.example.mvvmsamplekotlin.di.qualifier.PreferenceName
import javax.inject.Inject

class PreferenceHelperImpl : PreferenceHelper {
    var context: Context
    var prefName: String
    var sharedPreferences: SharedPreferences

    @Inject
    constructor(context: Context, @PreferenceName prefName: String) {
        this.context = context
        this.prefName = prefName
        this.sharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }
}