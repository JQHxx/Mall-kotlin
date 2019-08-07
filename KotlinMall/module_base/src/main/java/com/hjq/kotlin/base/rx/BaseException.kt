package com.hjq.kotlin.base.rx

/**
 * 通用异常类
 */
class BaseException(val status: Int, val msg: String) : Throwable() {
}