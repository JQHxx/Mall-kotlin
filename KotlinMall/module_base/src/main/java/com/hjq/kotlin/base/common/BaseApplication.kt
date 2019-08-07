package com.hjq.kotlin.base.common

import android.app.Application
import com.hjq.kotlin.base.injection.component.AppComponent
import com.hjq.kotlin.base.injection.component.DaggerAppComponent
import com.hjq.kotlin.base.injection.module.AppModule
import kotlin.properties.Delegates

/**
 * Application基类
 * */
open class BaseApplication : Application() {

    lateinit var mAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        context = this
        initAppInjection()
    }

    private fun initAppInjection() {
        mAppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }


    /**
     * 全局伴生对象
     */
    companion object {
        var context: BaseApplication by Delegates.notNull()
    }
}