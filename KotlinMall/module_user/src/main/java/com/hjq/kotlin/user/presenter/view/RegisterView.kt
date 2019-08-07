package com.hjq.kotlin.user.presenter.view

import com.hjq.kotlin.base.presenter.view.BaseView

/**
 * 用户注册，视图回调
 */
interface RegisterView : BaseView {
    fun onRegisterResult(result: String)
}