package com.hjq.kotlin.base.rx

import com.hjq.kotlin.base.common.ResultCode
import com.hjq.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function
/**
 * 通用数据类型转换封装
 */
class BaseFunc<T> : Function<BaseResp<T>, Observable<T>> {
    override fun apply(t: BaseResp<T>): Observable<T> {
        return if (t.status != ResultCode.SUCCESS) {
            Observable.error(BaseException(t.status, t.message))
        } else {
            Observable.just(t.data)
        }
    }
}