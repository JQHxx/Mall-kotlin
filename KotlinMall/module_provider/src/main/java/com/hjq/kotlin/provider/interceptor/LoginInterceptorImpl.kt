package com.hjq.kotlin.provider.interceptor

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.hjq.kotlin.base.common.BaseConstant
import com.hjq.kotlin.base.utils.AppPrefsUtils
import com.hjq.kotlin.provider.router.RouterPath

@Interceptor(name = "login", priority = 6)
class LoginInterceptorImpl: IInterceptor {
    override fun process(postcard: Postcard, callback: InterceptorCallback?) {
        var path = postcard.path;
        var islogin = AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
        if (islogin) { // 如果已经登录不拦截
            callback?.onContinue(postcard)
        } else { // 没有登录拦截
            when(path) {
                RouterPath.ModuleMessage.PATH_MESSAGE_ORDER -> {

                }
                RouterPath.ModuleMessage.PATH_MESSAGE_PUSH -> {

                }
            }
        }
    }

    override fun init(context: Context?) {
        Log.d("message","路由登录拦截器初始化成功"); //只会走一次
    }

}
