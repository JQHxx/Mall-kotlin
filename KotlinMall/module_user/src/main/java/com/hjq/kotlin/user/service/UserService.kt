package com.hjq.kotlin.user.service

import io.reactivex.Observable

interface UserService {
    //用户注册
    fun register(mobile: String, pwd: String, verityCode: String): Observable<Boolean>

    //忘记密码
    fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean>
}