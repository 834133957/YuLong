package com.yulong.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class YuLongWeatherApplication : Application() {

    //获取全局context
    companion object {
        const val TOKEN = "9bQDrDZhfSS9rchB"

        @SuppressLint
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}