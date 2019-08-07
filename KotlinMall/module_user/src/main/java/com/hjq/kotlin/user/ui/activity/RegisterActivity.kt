package com.hjq.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.hjq.kotlin.base.ext.enable
import com.hjq.kotlin.base.ext.onClick
import com.hjq.kotlin.base.ui.activity.BaseMvpActivity
import com.hjq.kotlin.user.R
import com.hjq.kotlin.user.injection.component.DaggerUserComponent
import com.hjq.kotlin.user.presenter.RegisterPresenter
import com.hjq.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 用户注册
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {



    /**
     * 注册回调
     */
    override fun onRegisterResult(result: String) {
        toast(result)
        // finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
    }

    private fun initView() {
        mRegisterBtn.enable(mMobileEt, { isBtnEnable() })
        mRegisterBtn.enable(mVerifyCodeEt, { isBtnEnable() })
        mRegisterBtn.enable(mPwdEt, { isBtnEnable() })
        mRegisterBtn.enable(mPwdConfirmEt, { isBtnEnable() })

        mVerifyCodeBtn.onClick(this)
        mRegisterBtn.onClick(this)
        mHeaderBar.getRightView().onClick(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证成功")
            }
            R.id.mRegisterBtn -> {
                mPresenter.register(mMobileEt.text.toString(), mPwdEt.text.toString(), mVerifyCodeEt.text.toString())
            }
            R.id.mRightTv -> {
                startActivity<LoginActivity>()
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
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}
