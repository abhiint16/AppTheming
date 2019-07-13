package com.example.mvvmsamplekotlin.datamanager.prefhelper

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferenceHelperImpl : PreferenceHelper {
    var context: Context
    var prefName: String
    var sharedPreferences: SharedPreferences

    @Inject
    constructor(context: Context, prefName: String) {
        this.context = context
        this.prefName = prefName
        this.sharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }
}