package com.hjq.kotlin.base.injection.module

import android.app.Activity
import com.hjq.kotlin.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Activity级别Module
 */
@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    @ActivityScope
    fun provideActivity(): Activity {
        return this.activity
    }
}