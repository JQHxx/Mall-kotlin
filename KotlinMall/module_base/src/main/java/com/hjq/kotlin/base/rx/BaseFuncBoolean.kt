package com.hjq.kotlin.base.rx

import com.hjq.kotlin.base.common.ResultCode
import com.hjq.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Boolean 类型转换封装
 */
class BaseFuncBoolean<T> : Function<BaseResp<T>, Observable<Boolean>> {
    override fun apply(t: BaseResp<T>): Observable<Boolean> {
        return if (t.status != ResultCode.SUCCESS) {
            Observable.error(BaseException(t.status, t.message))
        } else {
            Observable.just(true)
        }
    }
}