package com.hjq.mall.common

import android.content.Context
import com.hjq.kotlin.base.common.BaseApplication
import android.support.multidex.MultiDex

/**
 * 应用的主入口
 * */
class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}