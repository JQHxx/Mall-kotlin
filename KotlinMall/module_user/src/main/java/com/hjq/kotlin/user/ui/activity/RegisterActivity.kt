package com.hjq.kotlin.user.ui.activity

import android.os.Bundle
import com.hjq.kotlin.base.ui.activity.BaseMvpActivity
import com.hjq.kotlin.user.R
import com.hjq.kotlin.user.injection.component.DaggerUserComponent
import com.hjq.kotlin.user.presenter.RegisterPresenter
import com.hjq.kotlin.user.presenter.view.RegisterView

/**
 * 用户注册
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun injectComponent() {
        DaggerUserComponent.builder()
            .activityComponent(mActivityComponent)
            .build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        // mPresenter.register(mMobileEt.text.toString(), mPwdEt.text.toString(), mVerifyCodeEt.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
}
