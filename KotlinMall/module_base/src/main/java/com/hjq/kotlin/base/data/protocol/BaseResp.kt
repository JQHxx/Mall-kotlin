package com.hjq.kotlin.base.data.protocol

data class BaseResp<out T> constructor(val status: Int, val message: String, val data: T) {
}