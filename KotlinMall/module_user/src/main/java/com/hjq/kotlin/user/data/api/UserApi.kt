package com.hjq.kotlin.user.data.api

import com.hjq.kotlin.base.data.protocol.BaseResp
import com.hjq.kotlin.user.data.protocol.RegisterReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 用户相关接口
 */
interface  UserApi {

    /**
     * 用户注册
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>
}