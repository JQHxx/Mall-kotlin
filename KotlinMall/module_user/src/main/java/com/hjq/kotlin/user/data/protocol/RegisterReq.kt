package com.hjq.kotlin.user.data.protocol

/**
 * 注册请求体
 */
class RegisterReq(val mobile: String, val pwd: String, val verifyCode: String)