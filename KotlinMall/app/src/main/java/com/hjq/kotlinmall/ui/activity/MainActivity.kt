package com.hjq.kotlinmall.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.hjq.kotlin.base.ui.activity.BaseActivity
import com.hjq.kotlinmall.R


/**
 * 通过隐藏fragment的方式，达到切换的效果
 */
class MainActivity : BaseActivity() {

    private var pressTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
