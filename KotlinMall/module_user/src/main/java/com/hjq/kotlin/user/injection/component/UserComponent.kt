package com.hjq.kotlin.user.injection.component

import com.hjq.kotlin.base.injection.PerComponentScope
import com.hjq.kotlin.base.injection.component.ActivityComponent
import com.hjq.kotlin.user.injection.module.UserModule
import com.hjq.kotlin.user.ui.activity.*
import dagger.Component

/**
 *  用户模块Component
 */
@PerComponentScope
//@Component(dependencies = arrayOf(ActivityComponent::class),
//        modules = arrayOf(UserModule::class))
@Component(dependencies = [(ActivityComponent::class)],
    modules = [(UserModule::class)])
interface UserComponent {
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
    fun inject(activity: UserInfoActivity)
}