package com.hjq.kotlin.user.data.respository

import com.hjq.kotlin.base.data.net.RetrofitFactory
import com.hjq.kotlin.base.data.protocol.BaseResp
import com.hjq.kotlin.user.data.api.UserApi
import com.hjq.kotlin.user.data.protocol.RegisterReq
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor() {
    /**
     * 用户注册
     */
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
            .register(RegisterReq(mobile, pwd, verifyCode))
    }
}