package com.hjq.kotlin.user.presenter

import com.hjq.kotlin.base.ext.execute
import com.hjq.kotlin.base.presenter.BasePresenter
import com.hjq.kotlin.base.rx.BaseObserver
import com.hjq.kotlin.user.presenter.view.RegisterView
import com.hjq.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * 用户注册Presenter
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService

    fun register(mobile: String, pwd: String, verifyCode: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.register(mobile, pwd, verifyCode)
            .execute(object : BaseObserver<Boolean>(mView) {
                override fun onNext(t: Boolean) {
                    super.onNext(t)
                    if (t)
                        mView.onRegisterResult("注册成功")
                }
            }, lifecycleProvider)
    }
}