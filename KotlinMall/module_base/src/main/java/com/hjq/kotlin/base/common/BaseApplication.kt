package com.hjq.kotlin.base.common

import android.annotation.SuppressLint
import android.app.Application
import kotlin.properties.Delegates

open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    /**
     * 全局伴生对象
     */
    companion object {
        var context: BaseApplication by Delegates.notNull()
    }
}