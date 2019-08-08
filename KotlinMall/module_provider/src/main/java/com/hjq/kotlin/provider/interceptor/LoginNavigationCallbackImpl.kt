package com.hjq.kotlin.provider.interceptor

import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.hjq.kotlin.provider.router.RouterPath

class LoginNavigationCallbackImpl: NavigationCallback {
    override fun onLost(postcard: Postcard?) {
    }

    override fun onFound(postcard: Postcard?) {
    }

    override fun onInterrupt(postcard: Postcard) {
        var path = postcard.path
        var bundle: Bundle = postcard.extras
        // 拦截了
        ARouter.getInstance().build(RouterPath.ModuleUser.PATH_LOGIN)
            .with(bundle)
            // .withString(ConfigConstants.PATH, path)
            .navigation()
    }

    override fun onArrival(postcard: Postcard?) {
    }

}