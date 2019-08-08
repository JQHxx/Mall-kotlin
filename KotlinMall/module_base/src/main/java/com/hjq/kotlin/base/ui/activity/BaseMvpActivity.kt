package com.hjq.kotlin.base.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.hjq.kotlin.base.common.BaseApplication
import com.hjq.kotlin.base.presenter.BasePresenter
import com.hjq.kotlin.base.presenter.view.BaseView
import com.hjq.kotlin.base.widgets.ProgressLoading
import com.hjq.kotlin.base.injection.component.ActivityComponent
import com.hjq.kotlin.base.injection.component.DaggerActivityComponent
import com.hjq.kotlin.base.injection.module.ActivityModule
import com.hjq.kotlin.base.injection.module.LifecycleProviderModule
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Activity基类，业务相关
 */
abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    lateinit var mActivityComponent: ActivityComponent

    //Presenter泛型，Dagger注入
    @Inject
    lateinit var mPresenter: T

    // lateinit 定义时不需要赋值
    lateinit var mProgressLoading: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
        //初始化加载框
        mProgressLoading = ProgressLoading.create(this)
        //ARouter注册
        ARouter.getInstance().inject(this)

    }

    /**
     * Dagger注册
     */
    protected abstract fun injectComponent()

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).mAppComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()
    }

    override fun showLoading() {
        mProgressLoading.showLoading()
    }

    override fun hideLoading() {
        mProgressLoading.hideLoading()
    }

    override fun onError(error: String) {
        toast(error)
    }
}