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

    private lateinit var context: Context

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

        /*
        //给需要跳转的页面添加值为Constant.LOGIN_NEEDED的extra参数，用来标记是否需要用户先登录才可以访问该页面
        //先判断需不需要
        if(postcard.getExtra() == Constant.LOGIN_NEEDED){

            boolean isLogin = App.getSharedPreferences().getBoolean(Constant.IS_LOGIN,false);
            Log.i(TAG, "是否已登录: " + isLogin);

            //判断用户的登录情况，可以把值保存在sp中
            if (isLogin) {
                callback.onContinue(postcard);
            }else {//没有登录,注意需要传入context
                ARouter.getInstance().build(RouterPath.LOGIN_ACTIIVTY).navigation(mContext);
            }
        } else {//没有extra参数时则继续执行，不做拦截
            callback.onContinue(postcard);
        }
        */
    }

    override fun init(context: Context) {
        this.context = context
        Log.d("message","路由登录拦截器初始化成功"); //只会走一次
    }

}
