package com.hjq.kotlin.user.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hjq.kotlin.base.ext.enable
import com.hjq.kotlin.base.ext.onClick
import com.hjq.kotlin.base.ui.activity.BaseMvpActivity
import com.hjq.kotlin.user.R
import com.hjq.kotlin.user.injection.component.DaggerUserComponent
import com.hjq.kotlin.user.presenter.LoginPresenter
import com.hjq.kotlin.user.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

/**
 * 用户登录
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    /**
     * 初始化视图
     */
    private fun initView() {
        mLoginBtn.enable(mMobileEt) { isBtnEnable() }
        mLoginBtn.enable(mPwdEt) { isBtnEnable() }

        mLoginBtn.onClick(this)
        mForgetPwdTv.onClick(this)
        mHeaderBar.getRightView().onClick(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mRightTv -> {
                startActivity<RegisterActivity>()
            }

            R.id.mLoginBtn -> {

            }

            R.id.mForgetPwdTv -> {
                startActivity<ForgetPwdActivity>()
            }
        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder()
            .activityComponent(mActivityComponent)
            .build()
            .inject(this)
        mPresenter.mView = this
    }

    /**
     * 判断按钮是否可用
     */
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}
