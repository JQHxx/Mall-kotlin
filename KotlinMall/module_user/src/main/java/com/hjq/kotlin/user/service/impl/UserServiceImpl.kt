package com.hjq.kotlin.user.service.impl

import com.hjq.kotlin.base.ext.convertBoolean
import com.hjq.kotlin.user.data.respository.UserRepository
import com.hjq.kotlin.user.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, pwd: String, verityCode: String): Observable<Boolean> {
        return repository.register(mobile, pwd, verityCode).convertBoolean()
        // Observable.just(true)
    }

    override fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {
        return Observable.just(true)
    }

}