package com.hjq.kotlinmall.common

import android.app.Application
import android.util.Log


/**
 * 应用的主入口
 * */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("debug", "msg")
    }
}