package com.hjq.kotlin.user.presenter

import com.hjq.kotlin.base.presenter.BasePresenter
import com.hjq.kotlin.user.presenter.view.LoginView
import com.hjq.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * 用户登录Presenter
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    fun login() {

    }
}