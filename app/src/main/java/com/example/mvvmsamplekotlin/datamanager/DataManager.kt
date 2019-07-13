package com.example.mvvmsamplekotlin.datamanager

import com.example.mvvmsamplekotlin.datamanager.apihelper.ApiHelper
import com.example.mvvmsamplekotlin.datamanager.dbhelper.DBHelper
import com.example.mvvmsamplekotlin.datamanager.prefhelper.PreferenceHelper

interface DataManager : ApiHelper, DBHelper, PreferenceHelper {
}