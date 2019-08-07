package com.hjq.kotlin.user.injection.module

import com.hjq.kotlin.user.service.UserService
import com.hjq.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * 用户模块Module
 */
@Module
class UserModule {

    @Provides
    fun provideUserService(service: UserServiceImpl): UserService {
        return service
    }
}