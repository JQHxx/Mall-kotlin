package com.hjq.kotlin.message.provider

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.hjq.kotlin.provider.PushProvider
import com.hjq.kotlin.provider.router.RouterPath


/**
 * 模块间接口调用  提供PushId的实现
 */
// @Route(path = RouterPath.ModuleMessage.PATH_MESSAGE_PUSH) 使用这个注解无法打包
class PushProviderImpl : PushProvider {

    private var mContext: Context? = null

    override fun init(context: Context?) {
        mContext = context
    }

    override fun getPushId(): String {
        Log.d("message", "err")
        return "err"
        // return JPushInterface.getRegistrationID(mContext)
    }

}