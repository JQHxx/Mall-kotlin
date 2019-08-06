package com.hjq.kotlin.base.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * 基类Activity,与业务无关
 * */
open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle, persistentState: PersistableBundle) {
        super.onCreate(savedInstanceState, persistentState)
    }
}