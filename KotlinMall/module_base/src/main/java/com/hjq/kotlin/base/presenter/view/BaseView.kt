package com.hjq.kotlin.base.presenter.view

/**
 * MVP 中视图回调 基类
 */
interface BaseView {

    fun showLoading()
    fun hideLoading()
    fun onError(error: String)
}