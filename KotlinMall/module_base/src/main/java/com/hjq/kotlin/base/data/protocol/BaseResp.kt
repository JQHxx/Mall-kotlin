package com.hjq.kotlin.base.data.protocol

/**
 * 接口响应数据格式
 */
data class BaseResp<out T> constructor(val status: Int, val message: String, val data: T) {
}